AUI()
		.use(
				'autocomplete-list',
				'aui-base',
				'aui-io-request',
				'autocomplete-filters',
				'autocomplete-highlighters',
				function(A) {
					A.one('#_lgopenaccessvideos_WAR_lecture2goportlet_searchQuery').show();
					var testData;
					new A.AutoCompleteList(
							{
								allowBrowserAutocomplete : 'false',
								activateFirstItem : 'true',
								inputNode : '#_lgopenaccessvideos_WAR_lecture2goportlet_searchQuery',
								resultTextLocator : 'word',
								render : 'true',
								resultHighlighter : 'phraseMatch',
								resultFilters : [ 'phraseMatch' ],
								source : function() {
									var inputValue = A
											.one(
													"#_lgopenaccessvideos_WAR_lecture2goportlet_searchQuery")
											.get('value');
									var myAjaxRequest = A.io
											.request(
													'/web/vod/l2go?p_p_id=lgopenaccessvideos_WAR_lecture2goportlet&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_cacheability=cacheLevelPage&p_p_col_id=column-1&p_p_col_count=1&_lgopenaccessvideos_WAR_lecture2goportlet_cmd=get_search_words',
													{
														dataType : 'json',
														method : 'POST',
														data : {
															_lgopenaccessvideos_WAR_lecture2goportlet_searchWord : inputValue,
														},
														autoLoad : false,
														sync : false,
														on : {
															success : function() {
																var data = this
																		.get('responseData');
																testData = data;
																
															},
															results : function() {
																console.log("results!");
															}
														}
													});
									myAjaxRequest.start();
									return testData;
								}
							});
				});