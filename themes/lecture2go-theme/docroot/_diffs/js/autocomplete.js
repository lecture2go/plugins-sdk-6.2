AUI().use('autocomplete-list','aui-base','aui-io-request','autocomplete-filters','autocomplete-highlighters',
		function (A) {
	
	// fetch video list from server
	var cachedVideoStrings;
	var ac;
	
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
				if (data.length != 0) {
					cachedVideoStrings = data;
				} else {
					console.log("fetching video list failed...");
				}
				createAutocomplete();
			}
		}
			});
	myAjaxRequest.start();

	//	create autocomplete-list
	function createAutocomplete () {
		document.ac = new A.AutoCompleteList({
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

		A.one('#_lgopenaccessvideos_WAR_lecture2goportlet_searchQuery').show();
	    var aclist = A.one('.yui3-aclist');
	    var list = aclist.one('.yui3-aclist-list');
	    list.delegate('mouseenter', function (event) {
	    	console.log( "data-text: " + event.currentTarget.getAttribute('data-text') );
	    	var ci = A.one(event.currentTarget);
	    	aclist.selectItem(ci);
	    }, 'li');
	    
	    document.ac.on("select", function (event) {
	    	$("#_lgopenaccessvideos_WAR_lecture2goportlet_searchQuery").val(event.itemNode.text());
	    	$("#_lgopenaccessvideos_WAR_lecture2goportlet_fm").submit();
	    });
	    
	    document.ac.on("hoveredItemChange", function (event) {window.ev=event;});
	}
});