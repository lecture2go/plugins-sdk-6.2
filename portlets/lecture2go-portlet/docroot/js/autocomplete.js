
AUI().use('autocomplete-list','aui-base','aui-io-request','autocomplete-filters','autocomplete-highlighters',
			function (A) {
				var testData="";
				new A.AutoCompleteList({
					allowBrowserAutocomplete: 'true',
					activateFirstItem: 'true',
					inputNode: '#_lgopenaccessvideos_WAR_lecture2goportlet_searchQuery',
					resultTextLocator:'word',
					render: 'true',
					resultHighlighter: 'phraseMatch',
					resultFilters:['phraseMatch'],
					source: function(){
						console.log("===");
						console.log("source: function(): ");
						var inputValue=A.one("#_lgopenaccessvideos_WAR_lecture2goportlet_searchQuery").get('value');
						console.log("inputValue: " + inputValue);
						var myAjaxRequest=A.io.request('/web/vod/l2go?p_p_id=lgopenaccessvideos_WAR_lecture2goportlet&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_cacheability=cacheLevelPage&p_p_col_id=column-1&p_p_col_count=1&_lgopenaccessvideos_WAR_lecture2goportlet_cmd=get_search_words',
						{
							dataType: 'json',
						  	method:'POST',
						  	data:{_lgopenaccessvideos_WAR_lecture2goportlet_searchWord: inputValue},
						  	autoLoad:false,
						  	sync:false,
						  	on: {
						   		success:function(){
						   			 var data=this.get('responseData');
						   			 testData=data;
						   			 }
						  	}
						});
						myAjaxRequest.start();
						var testArr=[{"word":"Day 3 - Research, Development and Field Test of Robotic Observation Systems for Sctive Volcanic Areas in Japan (Keynote)"},{"word":"12 - Testen/Listen"},{"word":"2 - Testing"},{"word":"25 - Bestimmung dichtester Punkte; Geometrische Datenstrukturen"},{"word":"Documentary Film Images of Sites of Mass Shootings as Testimony of the Holocaust in the USSR"},{"word":"8 - Schnittstellen mit Interfaces; Systematisches Testen"},{"word":"Effektiver Einsatz von  Lasttest zur Optimierung der Saklierbarkeit  von Websites bei OTTO"},{"word":"2 - Objektorientierte Tests, Vertragsmodell"},{"word":"Testgestützte PHP-Entwicklung aus betriebswirtschaftlicher Sicht"},{"word":"8 - Interfaces, Testen"},{"word":"Experiments in Digital Philosophy \u2013 Putting new paradigms to the test in the Agora project"},{"word":"14 - Testen"},{"word":"02 - Objektorientierte Tests, Vertragsmodell"},{"word":"Enterprise Testing with Spock"},{"word":"8 - Interfaces, systematisches Testen"},{"word":"Kommentar zur Sektion \"Sozialer Protest\" II (Strukturwandel und Protest / Forschungsstelle für Zeitgeschichte)"},{"word":"Militanz als Praxis und Identität (Sektion \"Sozialer Protest\" II)"},{"word":"Jenseits der Friedensbewegung? Sozialer Protest und militante Anti-Kriegsbewegung in Nordeutschland (Sektion \"Sozialer Protest\" I)"},{"word":"Strukturwandel und sozialer Protest"},{"word":"Kommentar zu \"Zum Spannungsverhältnis von Stadt und Land\" I (Strukturwandel und Protest / Forschungsstelle für Zeitgeschichte)"},{"word":"Kommentar zu \"Wirtschaft und Arbeit\" II (Strukturwandel und Protest / Forschungsstelle für Zeitgeschichte in Hamburg)"},{"word":"Einführung: Tagung \"Strukturwandel und Protest in Hamburg und Norddeutschland  seit den 1970er Jahren\", Forschungsstelle für Zeitgeschichte in Hamburg, 23. und 24. Sept. 2011"},{"word":"13 - Testen von objektorientierten"},{"word":"SE1, Vorlesung 8- Klassen, Typen und Interfaces / Einführung in systematisches Testen (08.12.2010)"},{"word":"Elektronische Tests - Didaktik"},{"word":"OOPM, Vorlesung 13- Testen von objektorientierten Programmen (07.07.2010)"},{"word":"Stresstest: Wie die Finanzkrise die Transformation von Staatlichkeit beeinflusst"},{"word":"Thema: Spurenanalysen radioaktiver Edelgase in der Atmosphäre: Analytik, Ergebnisse und Bedeutung für die Überwachung des Atomwaffenteststoppabkommens"}];
						return testData;}
					});
				A.one('#_lgopenaccessvideos_WAR_lecture2goportlet_searchQuery').show();
			});