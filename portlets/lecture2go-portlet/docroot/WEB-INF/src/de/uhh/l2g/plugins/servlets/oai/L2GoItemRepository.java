package de.uhh.l2g.plugins.servlets.oai;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.dspace.xoai.dataprovider.exceptions.IdDoesNotExistException;
import org.dspace.xoai.dataprovider.exceptions.OAIException;
import org.dspace.xoai.dataprovider.filter.Filter;
import org.dspace.xoai.dataprovider.filter.FilterResolver;
import org.dspace.xoai.dataprovider.filter.Scope;
import org.dspace.xoai.dataprovider.filter.ScopedFilter;
import org.dspace.xoai.dataprovider.handlers.results.ListItemIdentifiersResult;
import org.dspace.xoai.dataprovider.handlers.results.ListItemsResults;
import org.dspace.xoai.dataprovider.model.InMemoryItem;
import org.dspace.xoai.dataprovider.model.Item;
import org.dspace.xoai.dataprovider.model.ItemIdentifier;
import org.dspace.xoai.dataprovider.repository.InMemoryItemRepository;
import org.dspace.xoai.dataprovider.repository.ItemRepository;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringUtil;
import org.dspace.xoai.dataprovider.model.conditions.Condition;
import com.lyncode.builder.ListBuilder;

import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.impl.VideoImpl;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.LicenseLocalServiceUtil;
import de.uhh.l2g.plugins.service.MetadataLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.persistence.VideoUtil;
import de.uhh.l2g.plugins.servlets.oai.filters.DateFromFilter;
import de.uhh.l2g.plugins.servlets.oai.filters.DateUntilFilter;
import de.uhh.l2g.plugins.servlets.oai.filters.L2GoFilter;
import de.uhh.l2g.plugins.servlets.oai.filters.OpenAccessFilter;

import static java.lang.Math.min;



public class L2GoItemRepository implements ItemRepository {

	public L2GoItemRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getItem(String identifier) throws IdDoesNotExistException, OAIException {
		// build the lightweight item for the identifier without the metadata
		
		Long videoId = Long.parseLong(identifier);
		
		L2GoItem item = new L2GoItem(); 
		
		Video v = new VideoImpl();
		try {
			v = VideoLocalServiceUtil.getVideo(videoId);
		} catch (Exception e) {
			throw new IdDoesNotExistException();
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
		Date generationDate = new Date();
		try {
			generationDate = format.parse(v.getGenerationDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		item
			.with("identifier", identifier)
			.with("deleted", false)
			.with("sets", new ListBuilder<String>().add(randomAlphabetic(3)).build())
			.with("datestamp", generationDate);
		
		//L2GoItem item = fillItem(identifier);
		return item;
	}
	
	
	@Override
	public ListItemIdentifiersResult getItemIdentifiers(List<ScopedFilter> filters, int offset, int length)
			throws OAIException {
		
		QueryResult queryResult;
		try {
			queryResult = retrieveItems(filters, offset, length);
		} catch (IdDoesNotExistException e) {
			throw new OAIException();
		}
        return new ListItemIdentifiersResult(queryResult.hasMore(), queryResult.getResults());
	}
	
	
	
	
	
	/**
	 * This translates the scoped filters to a dynamic query
	 * @param filters the scopedFilters which are used for restricting the query to the database
	 * @return the dynamic query which can be further processed
	 */
	private DynamicQuery getDynamicQueryFromFilters(List<ScopedFilter> filters) {
		DynamicQuery dynamicQuery = VideoLocalServiceUtil.dynamicQuery();
		
		for (ScopedFilter scopedFilter: filters) {
			// if filter is a L2GoFilter and has the Query scope add the criterion to the query
			Filter filter = scopedFilter.getCondition().getFilter(null);
			if (filter instanceof L2GoFilter && scopedFilter.getScope() == Scope.Query) {
				Criterion criterion = ((L2GoFilter) filter).getCriterion();
				dynamicQuery.add(criterion);
			}
		}			
		
		return dynamicQuery;
	}
	
	
	@Override
	public ListItemIdentifiersResult getItemIdentifiers(List<ScopedFilter> filters, int offset, int length, Date from)
			throws OAIException {
		
        filters.add(new ScopedFilter(getDateFromFilter(from), Scope.Query));
        return this.getItemIdentifiers(filters, offset, length);
	}
	


	@Override
	public ListItemIdentifiersResult getItemIdentifiersUntil(List<ScopedFilter> filters, int offset, int length,
			Date until) throws OAIException {
		
        filters.add(new ScopedFilter(getDateUntilFilter(until), Scope.Query));
        return this.getItemIdentifiers(filters, offset, length);
	}

	@Override
	public ListItemIdentifiersResult getItemIdentifiers(List<ScopedFilter> filters, int offset, int length, Date from,
			Date until) throws OAIException {

        filters.add(new ScopedFilter(getDateFromFilter(from), Scope.Query));
        filters.add(new ScopedFilter(getDateUntilFilter(until), Scope.Query));
        return this.getItemIdentifiers(filters, offset, length);
	}

	@Override
	public ListItemIdentifiersResult getItemIdentifiers(List<ScopedFilter> filters, int offset, int length,
			String setSpec) throws OAIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListItemIdentifiersResult getItemIdentifiers(List<ScopedFilter> filters, int offset, int length,
			String setSpec, Date from) throws OAIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListItemIdentifiersResult getItemIdentifiersUntil(List<ScopedFilter> filters, int offset, int length,
			String setSpec, Date until) throws OAIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListItemIdentifiersResult getItemIdentifiers(List<ScopedFilter> filters, int offset, int length,
			String setSpec, Date from, Date until) throws OAIException {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public ListItemsResults getItems(List<ScopedFilter> filters, int offset, int length) throws OAIException {
		
		QueryResult queryResult;
		try {
			queryResult = retrieveItems(filters, offset, length);
		} catch (IdDoesNotExistException e) {
			throw new OAIException();
		}
		
		List<? extends ItemIdentifier> result = queryResult.getResults();
		
        return new ListItemsResults(queryResult.hasMore(), (List<Item>) result);
	}
	

	@Override
	public ListItemsResults getItems(List<ScopedFilter> filters, int offset, int length, Date from)
			throws OAIException {

        filters.add(new ScopedFilter(getDateFromFilter(from), Scope.Query));
        return this.getItems(filters, offset, length);
	}

	@Override
	public ListItemsResults getItemsUntil(List<ScopedFilter> filters, int offset, int length, Date until)
			throws OAIException {
		
        filters.add(new ScopedFilter(getDateUntilFilter(until), Scope.Query));
        return this.getItems(filters, offset, length);
	}

	@Override
	public ListItemsResults getItems(List<ScopedFilter> filters, int offset, int length, Date from, Date until)
			throws OAIException {

        filters.add(new ScopedFilter(getDateFromFilter(from), Scope.Query));
        filters.add(new ScopedFilter(getDateUntilFilter(until), Scope.Query));
        return this.getItems(filters, offset, length);
	}

	@Override
	public ListItemsResults getItems(List<ScopedFilter> filters, int offset, int length, String setSpec)
			throws OAIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListItemsResults getItems(List<ScopedFilter> filters, int offset, int length, String setSpec, Date from)
			throws OAIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListItemsResults getItemsUntil(List<ScopedFilter> filters, int offset, int length, String setSpec,
			Date until) throws OAIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListItemsResults getItems(List<ScopedFilter> filters, int offset, int length, String setSpec, Date from,
			Date until) throws OAIException {
		// TODO Auto-generated method stub
		return null;
	}
	
	// metadata for item has been moved to L2GoItem
	/*
	private L2GoItem fillItem(String identifier) throws IdDoesNotExistException {
		// get the id of the video from the identifier, which is the url is this case
		//String videoIdString = StringUtil.extractLast(identifier, "/");
		Long videoId = Long.parseLong(identifier);
		
		L2GoItem l2GoItem = new L2GoItem(); 
		
		Video v = new VideoImpl();
		try {
			v = VideoLocalServiceUtil.getVideo(videoId);
		} catch (Exception e) {
			throw new IdDoesNotExistException();
		}

		try {
			
			// Identifier
			l2GoItem.with("identifier", identifier);
			
			// Title
			String title = v.getTitle();
			l2GoItem.with("title", title);


			// Creators
			List<Creator> creators = CreatorLocalServiceUtil.getCreatorsByVideoId(v.getVideoId());
			for (Creator c: creators) {
				c.getFullName();
			}
			
			// PublicationYear
			// todo - transform to year
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
			Date generationDate = format.parse(v.getGenerationDate());
			l2GoItem.with("datestamp", generationDate);
		
			// ResourceType
			String containerFormat = v.getContainerFormat();
			l2GoItem.with("containerFormat", containerFormat);
			
			
			// Contributor 
			// todo
			
			// Language
			Metadata metadata = MetadataLocalServiceUtil.getMetadata(v.getMetadataId());
			String language = metadata.getLanguage();
			l2GoItem.with("language", language);

			
			// Size
			// todo - transform
			String duration = v.getDuration();
			l2GoItem.with("duration", duration);
			
			// Rights
			License license = LicenseLocalServiceUtil.getLicense(v.getLicenseId());
			String rights = license.getFullName();
			l2GoItem.with("rights", rights);

			
		} catch (Exception e) {
			// TODO: exception handling -> no video with id
		}
	
		l2GoItem.with("deleted", false).with("sets", new ListBuilder<String>().add(randomAlphabetic(3)).build());
		
		return l2GoItem;
	}
	*/
	
	/**
	 * Uses the Liferay DynamicQuery to fetch the corresponding data and add them to 
	 * @param filters
	 * @param offset
	 * @param length
	 * @return
	 * @throws OAIException 
	 * @throws IdDoesNotExistException 
	 */
	private QueryResult retrieveItems(List<ScopedFilter> filters, int offset, int length) throws IdDoesNotExistException, OAIException {
		// add an openaccess filter for all queries
		filters.add(new ScopedFilter(getOpenAccessFilter(), Scope.Query));
		
		List<ItemIdentifier> l2GoItems =  new ArrayList<ItemIdentifier>();
		
		long count = 0;

		// get the dynamic query according to the filters
		DynamicQuery dynamicQuery = getDynamicQueryFromFilters(filters);
		
		// TODO: this must be set to the new data type, when implemented
		List<Video> videos;
		try {
			videos = VideoLocalServiceUtil.dynamicQuery(dynamicQuery,offset, offset + length);

			// get the count of all videos
			count = VideoLocalServiceUtil.dynamicQueryCount(dynamicQuery);
			
			for (Video video: videos) {
				l2GoItems.add(getItem(String.valueOf(video.getVideoId())));
			}
		}
		catch (SystemException e) {
			throw new OAIException();
		}

		return new QueryResult(l2GoItems, offset + length < count, count);
	}

	private Condition getOpenAccessFilter() {
		return new Condition() {
			@Override
			public Filter getFilter(FilterResolver filterResolver) {
                return new OpenAccessFilter();
			}
        };
	}
	
	private Condition getDateFromFilter(final Date from) {
		return new Condition() {
			@Override
			public Filter getFilter(FilterResolver filterResolver) {
                return new DateFromFilter(from);
			}
        };
	}
	
	private Condition getDateUntilFilter(final Date unti) {
		return new Condition() {
			@Override
			public Filter getFilter(FilterResolver filterResolver) {
                return new DateUntilFilter(unti);
			}
        };
	}
	
	private class QueryResult {
        private List<ItemIdentifier> results;
        private boolean hasMore;
        private long total;

        private QueryResult(List<ItemIdentifier> results, boolean hasMore, long count) {
            this.results = results;
            this.hasMore = hasMore;
            this.total = count;
        }

        private List<ItemIdentifier> getResults() {
            return results;
        }

        private boolean hasMore() {
            return hasMore;
        }

        private long getTotal() {
            return total;
        }
    }
}
