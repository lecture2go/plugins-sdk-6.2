$( function() {
	if(!assignedCreators) assignedCreators="";
	showCreatorsList(assignedCreators);
});

function showCreatorsList(data) {
	$.template( "filesTemplate", $("#created") );
	$.tmpl( "filesTemplate", data ).appendTo( "#creators" );
}


function autocompleteCreator($creatorInputObject) {
	$creatorInputObject.autocomplete({
	    source: function(request, response) {
	        var results = $.ui.autocomplete.filter(allCreatorsInJQueryAutocompleteFormat, request.term);
	        response(results.slice(0, 10));
	    },
	    messages: {
	        noResults: '',
	        results: function() {}
	    },
		minLength: 1,
		open: function(event, ui) {
			$('.ui-autocomplete').append('<li id="addNewCreator" class="newcreator">' + Liferay.Language.get('add-new-creator') + ' <span class="icon-large icon-plus-sign"></span></li>');
			$( "#addNewCreator" ).on( "click", function() {
				/* empty the creator input field */
				$creatorInputObject.val('');
				c++;
				appendCreator(c);
				$creatorInputObject.autocomplete('close');
			});
		},
        response: function(event, ui) {
            if (ui.content.length === 0) {
            	avoidClosing = true;
	        }
        },
        close: function(event, ui) {
        	if (avoidClosing) {
        		$("ul.ui-autocomplete li:not(:last)").remove();
            	$("ul.ui-autocomplete").show();
            	avoidClosing = false;
        	}
        },
		select: function (event, ui) {
			if(ui.item.id>0){
  		        var vars = getJSONCreator(ui.item.id);
  		        $.template( "filesTemplate", $("#created") );
  		        $.tmpl( "filesTemplate", vars ).appendTo( "#creators" );
  			}
		}
	});
}

function appendCreator(c){
	$(function () {
    	var vars = {'counter':c};
    	$.template( "filesTemplate", $("#newCreator") );
    	$.tmpl( "filesTemplate", vars ).appendTo( "#creators" );
	});
};

function getJSONCreator (data){
	var ret;
	/* we can not access the portlet namespace from the external js file directly so we need to build the variable property name this way: */
	var creatorId = namespace + "creatorId";
	var dataJSON = {};
	dataJSON[creatorId] = data;
	
	$.ajax({
		  type: "POST",
		  url: getJSONCreatorURL,
		  dataType: 'json',
		  data: dataJSON,
		  global: false,
		  async:false,
		  success: function(data) {
		    ret = data;
		  }
	})
	return ret;
}


function updateCreators(){
	var jsonArray = [];
	$('#creators').children().each(function(n){
		var parameters = {};
		var $div = $(this);
		var id = $div.attr('id');
		if(id.indexOf("nc")==-1){
			parameters['creatorId'] = $div.find('input[name = '+namespace+'creatorId]').val();
			parameters['firstName'] = $div.find('input[name = '+namespace+'firstName]').val();
			parameters['lastName'] = $div.find('input[name = '+namespace+'lastName]').val();
			parameters['middleName'] = $div.find('input[name = '+namespace+'middleName]').val();
			parameters['jobTitle'] = $div.find('input[name = '+namespace+'jobTitle]').val();
			parameters['gender'] = "";
			parameters['fullName'] = $div.find('input[name = '+namespace+'fullName]').val();
		}else{
			parameters['creatorId'] = "0";
			parameters['firstName'] = $div.find('input[name = '+namespace+'firstName]').val().trim();
			parameters['lastName'] = $div.find('input[name = '+namespace+'lastName]').val().trim();
			parameters['middleName'] = $div.find('input[name = '+namespace+'middleName]').val().trim();
			parameters['jobTitle'] = $div.find('input[name = '+namespace+'jobTitle]').val().trim();
			parameters['gender'] = "";
			parameters['fullName'] = (parameters['jobTitle'].trim()+" "+(parameters['firstName'].trim()+" "+parameters['middleName'].trim()).trim()+" "+parameters['lastName'].trim()).trim();		
		}
		console.log(parameters);
		if(parameters['firstName'].length>0 && parameters['lastName'].length>0){
			jsonArray[n]=parameters;
		}
	});
	updateCreatorOnServer(jsonArray);
}
