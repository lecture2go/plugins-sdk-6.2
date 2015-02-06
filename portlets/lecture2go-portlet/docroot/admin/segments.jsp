<%@include file="/init.jsp"%>
<jsp:useBean id="reqVideo" type="de.uhh.l2g.plugins.model.Video" scope="request" />


<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/admin/videosList.jsp" />
</portlet:renderURL>

<liferay-portlet:resourceURL id="toggleSegmentation" var="toggleSegmentationURL" />
<liferay-portlet:resourceURL id="addSegment" var="addSegmentURL" />
<liferay-portlet:resourceURL id="deleteSegment" var="deleteSegmentURL" />

<%
String backURL = request.getAttribute("backURL").toString();
%>

<aui:fieldset helpMessage="test" column="true" label='<%=reqVideo.getTitle()%>'>
	<aui:layout>
		<aui:form action="<%=addSegmentURL.toString()%>" commandName="model" name="segments" id="segments">
			<%if(reqVideo.getPermittedToSegment()==0){%>
				<aui:input name="segmentationPermitted" type="checkbox" label="segmentation allowed" id="segmentationPermitted"/>
			<%}else{%>
				<aui:input name="segmentationPermitted" type="checkbox" label="segmentation allowed" id="segmentationPermitted" checked="true"/>
			<%}%>

			<div class="player">
				<%@ include file="mediaplayer/includeStrobeMediaPlayer.html"%>
			</div>
			
		    <aui:input name="segment" value="1" type="radio" label="chapter" id="chapter" checked="true"/>	
	
		    <aui:input name="segment" value="0" type="radio" label="comment" id="comment"/>	
			
			<aui:input name="chortTitle" label="chort title" required="true" id="chortTitle"/>
	
			<aui:input name="segmentBegin" label="segment begin" required="true" onclick="updateL2GoTimeForStart();" id="timeStart" readonly="true"/>
	
			<aui:input name="segmentEnd" label="segment end" required="true" onclick="updateL2GoTimeForEnd();" id="timeEnd" readonly="true"/>
			
			<div id="iav">
				<aui:input name="text" type="textarea" label="text" autoSize="true" id="text"/>
			</div>
			
			<aui:input name="videoId" type="hidden" value="<%=reqVideo.getVideoId()%>"/>
			<div id="ignore"><aui:input type="text" name="dummy" required="true"/></div>
			
			<aui:button-row>
				<aui:button type="submit" value="add segment" onClick="addSegment()" />
			</aui:button-row>
			
			<aui:button-row>
				<aui:button type="cancel" value="cancel" href="<%=backURL%>"/>
			</aui:button-row>
		</aui:form>
	</aui:layout>
</aui:fieldset>

<div id="iframe" style="overflow: auto; width:750px; height:350px; font-size: 1.2em;">
</div>

<liferay-portlet:resourceURL id="showSegments" var="segmentsURL" />
<script type="text/javascript">
	$.ajax({
	    url: '<%=segmentsURL%>',
	    method: 'POST',
	    dataType: "json",
	    data: {
	 	   	<portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>",
	    },
	    success: function(data, textStatus, jqXHR) {
	        // since we are using jQuery, you don't need to parse response
	        drawSegmentRow(data);
	    }
	});	

	function hideSegment(sId){
		$("b#pf2_"+sId).hide();
		$("b#pf1_"+sId).show();
		$("b#iav"+sId).hide();		
	}
	function showSegment(sId){
		$("b#pf1_"+sId).hide();
		$("b#pf2_"+sId).show();
		$("b#iav"+sId).show();		
	}
	function loadSegment(sId){
		$("b#pf2_"+sId).show();
		$("b#pf1_"+sId).hide();
		$("b#iav"+sId).show();
	}
	
	function deleteSegment(segmentId){	
		$.ajax({
		    url: '<%=deleteSegmentURL.toString()%>',
		    method: 'POST',
		    dataType: "json",
		    data: {
		 	   	<portlet:namespace/>segmentId: segmentId,
		 	   	<portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>",
		    },
		    success: function(data, textStatus, jqXHR) {
		        // since we are using jQuery, you don't need to parse response
		        $("#"+data.segmentId).remove();
		    }
		});	
	}

	
	function drawSegmentRow(data) {
		for (var i = 0; i < data.length; i++) {
			drawRow(data[i]);
	    }
	}
	
	function drawRow(segment) {
	    if(segment.chapter==1){
	    	newRow='<div class="chaptertile" id="'+segment.segmentId+'">'+
			'<a><iavst begin="'+segment.start+'" end="'+segment.end+'"><img class="imgsmall" title="watch this chapter" src="'+segment.image+'"></iavst></a>'+
			'<span style="font-size:8px;">'+segment.start +' - '+segment.end+'</span><br/>'+
			'<a><iavst class="white" begin="'+segment.start+'" end="'+segment.end+'"><span style="font-size:11px;">'+segment.title+'</span></iavst></a>';
		}else{
			newRow='<div class="commenttile" id="'+segment.segmentId+'" onload="alert('+segment.segmentId+')">'+
    		'<div>'+
			'<b id="pf1_'+segment.segmentId+'">'+
    		'<input type="image" height="10" width="10" src="/lecture2go-portlet/img/commentOff.png" title="comment on" alt="comment on" id="showr'+segment.segmentId+'" onclick="showSegment('+segment.segmentId+')"/>'+
    		'</b>'+
    		'<b id="pf2_'+segment.segmentId+'">'+
    		'<input type="image" height="10" width="10" src="/lecture2go-portlet/img/commentOn.png" title=" comment off" alt="comment off" id="hidr'+segment.segmentId+'" onclick="hideSegment('+segment.segmentId+')"/>'+
    		'</b>'+
    		'<span class="fs8">'+segment.start+'</span>'+
    		'<a><iavst class="white" begin="'+segment.start+'" end="'+segment.end+'"><span style="font-size:11px;">'+segment.title+'</span></iavst></a>'+
    		'</div>';
    		if(segment.description >""){
    			newRow=newRow+'<b id="iav'+segment.segmentId+'"><span class="fs10"><div id="description"><em>'+segment.description+'</em></div></span></b>';
    		}
		}
		if(segment.userId==<%=remoteUser.getUserId()%>){
			newRow=newRow+'<input type="image" src="/lecture2go-portlet/img/delete.png" alt="delete" onclick="deleteSegment('+segment.segmentId+')" >';
		}
		newRow=newRow+'</div>';
		if(segment.chapter!=1){
			newRow=newRow+'<script>YUI().use("node-base", function(Y) {Y.on("available", loadSegment('+segment.segmentId+'), "#'+segment.segmentId+'")})<\/script>';
		}
		
		if(segment.previousSegmentId == -1){
			$("#iframe").append(newRow);
		}else{
			$(newRow).insertAfter("#"+ segment.previousSegmentId);
		}
	}
	
	AUI().use(
			'aui-node',
			function(A) {
				// Select the node(s) using a css selector string
				A.one('#ignore').hide();
				var text = A.one('#iav');
				text.hide();
				var chapter = A.one('#<portlet:namespace/>chapter');
				var comment = A.one('#<portlet:namespace/>comment');
				var segmentationPermitted = A.one('#<portlet:namespace/>segmentationPermittedCheckbox');
				
				chapter.on('click',function(A){text.hide()});
				comment.on('click',function(A){text.show()});
				segmentationPermitted.on('click',function(A){toggleSegmentationPermitted(segmentationPermitted.get('checked'))});
			}
	);
	
	function addSegment(){
		AUI().use('aui-io-request', 'aui-node',
			function(A){
	 	   	var chortTitle = A.one('#<portlet:namespace/>chortTitle').get('value');
	 	   	var timeStart = A.one('#<portlet:namespace/>timeStart').get('value');
	 	   	var timeEnd = A.one('#<portlet:namespace/>timeEnd').get('value');
	 	   		if(chortTitle.trim()>""&&timeStart.trim()>""&&timeEnd.trim()>""){
					A.io.request('<%=addSegmentURL.toString()%>', {
				 	dataType: 'json',
				 	method: 'POST',
					 	//send data to server
					 	data: {
						 	   	<portlet:namespace/>chortTitle: chortTitle,
						 	   	<portlet:namespace/>timeStart: timeStart,
						 	   	<portlet:namespace/>timeEnd: timeEnd,
						 	   	<portlet:namespace/>text: A.one('#<portlet:namespace/>text').get('value'),
						 	   	<portlet:namespace/>chapter: A.one('#<portlet:namespace/>chapter').get('checked'),
						 	   	<portlet:namespace/>comment: A.one('#<portlet:namespace/>comment').get('checked'),
						 	   	<portlet:namespace/>videoId: A.one('#<portlet:namespace/>videoId').get('value'),
					 	},
					 	//get server response
						on: {
							   success: function() {
							     var segment = this.get('responseData');
							        setTimeout(function() {
							        	drawRow(segment);
							        }, 2000)
							   }
						}
					});	
	 	   		}
			}
		);
	}
	
	function toggleSegmentationPermitted(data){
		AUI().use('aui-io-request', 'aui-node',
			function(A){
				A.io.request('<%=toggleSegmentationURL%>', {
			 	dataType: 'json',
			 	method: 'POST',
				 	//send data to server
				 	data: {
					 	   	<portlet:namespace/>segmentationPermittedCheckbox: data,
					 	   	<portlet:namespace/>videoId: A.one('#<portlet:namespace/>videoId').get('value'),
				 	},
				 	//get server response
					on: {
						   success: function() {
						     var jsonResponse = this.get('responseData');
						   }
					}
				});	
			}
		);
	}
</script>
