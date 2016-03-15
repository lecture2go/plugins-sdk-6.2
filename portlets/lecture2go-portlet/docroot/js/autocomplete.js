AUI().use('autocomplete-list','aui-base','aui-io-request','autocomplete-filters','autocomplete-highlighters',
		function (A) {
	
	// fetch video list from server
	var cachedVideoStrings;
	var testData = [{"word":"Test eins !"}, {"word":"testtestestetstesrt"}, {"word":"Rattattataatestattatat"}, {"word":"Flabber flabber bumm  test bumm bumm!"}, {"word":"Ach das test ja interessant!"}, {"word":"Tomatestensalat"}, {"word":"Test 778"}];
	var inputValue=A.one("#_lgopenaccessvideos_WAR_lecture2goportlet_searchQuery").get('value');
	var myAjaxRequest=A.io.request('/web/vod/l2go?p_p_id=lgopenaccessvideos_WAR_lecture2goportlet&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_cacheability=cacheLevelPage&p_p_col_id=column-1&p_p_col_count=1&_lgopenaccessvideos_WAR_lecture2goportlet_cmd=get_search_words',
			{
		dataType: 'json',
		method:'POST',
		data:{_lgopenaccessvideos_WAR_lecture2goportlet_searchWord: inputValue},
		autoLoad:false,
		sync:false,
		on: {
			success:function(){
				var data = this.get('responseData');
				if (data.length == 0) {
					cachedVideoStrings = testData;
				} else {
					cachedVideoStrings = data;
				}
				createAutocomplete();
			}
		}
			});
	myAjaxRequest.start();

	//	create autocomplete-list
	function createAutocomplete () {
		new A.AutoCompleteList({
			allowBrowserAutocomplete: false,
			activateFirstItem: false,
			inputNode: '#_lgopenaccessvideos_WAR_lecture2goportlet_searchQuery',
			maxResults: 7,
			minQueryLength: 3,
			resultTextLocator:'word',
			render: 'true',
			resultHighlighter: 'phraseMatch',
			resultFilters:['phraseMatch'],
			source: cachedVideoStrings
		});
		console.log("na?");
		A.one('#_lgopenaccessvideos_WAR_lecture2goportlet_searchQuery').show();
	}
});