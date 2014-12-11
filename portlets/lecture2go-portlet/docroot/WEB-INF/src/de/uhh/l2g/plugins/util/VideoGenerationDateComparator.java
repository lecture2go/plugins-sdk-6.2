package de.uhh.l2g.plugins.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import de.uhh.l2g.plugins.model.Video;


/**
 * The Class VideoGenerationDateComparator.
 */
public class VideoGenerationDateComparator implements Comparator<Video> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	/**
	 * Compare.
	 *
	 * @param v1 the v1
	 * @param v2 the v2
	 * @return the int
	 */
	public int compare(Video v1, Video v2) {
		Date d1 = new Date();
		Date d2 = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
		try {
			d1 = df.parse(v1.getGenerationDate());
			d2 = df.parse(v2.getGenerationDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int ret = 0;
		if (d1.before(d2)) ret = 1;
		if (d1.after(d2)) ret = -1;

		return ret;
	}

}
