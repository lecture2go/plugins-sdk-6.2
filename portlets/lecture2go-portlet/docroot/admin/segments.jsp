<%@include file="/init.jsp"%>
<jsp:useBean id="reqVideo" type="de.uhh.l2g.plugins.model.Video" scope="request" />


<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/admin/videosList.jsp" />
</portlet:renderURL>

<liferay-portlet:resourceURL id="toggleSegmentation" var="toggleSegmentationURL" />
<liferay-portlet:resourceURL id="addSegment" var="addSegmentURL" />


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
				<aui:button type="cancel" value="back" onClick="<%=cancelURL.toString()%>" />
			</aui:button-row>
		</aui:form>
	</aui:layout>
</aui:fieldset>

<script type="text/javascript">
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
							     var jsonResponse = this.get('responseData');
							     //alert(jsonResponse.key1);
							   }
						}
					});	
	 	   		}
			}
		);
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
