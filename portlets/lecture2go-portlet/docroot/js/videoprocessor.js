var videoProcessor = {
	getToolTipHtml: function() {
		return $([
		                   "<span class='taglib-icon-help'>",
		                   "  <img onmouseover=\"Liferay.Portal.ToolTip.show(this, Liferay.Language.get('conversion-description'));\" src='/html/themes/control_panel/images/portlet/help.png' id='tooltipMessage'>",
		                   "</span>"
		                 ].join("\n"));
	},
	getConversionInitializedHtml: function() {
		return $([
		                   "<span class='conversion-running'>",
		                   "  <span class='icon-exclamation-sign'> </span>",
		                   Liferay.Language.get('conversion-initializing'),
		                   "</span>"
		                 ].join("\n")).add(videoProcessor.getToolTipHtml());
	},
	getConversionRunningHtml: function() {
		return $([
		                   "<span class='conversion-running'>",
		                   "  <span class='icon-exclamation-sign'> </span>",
		                   Liferay.Language.get('conversion-running'),
		                   "</span>"
		                 ].join("\n")).add(videoProcessor.getToolTipHtml());
	},
	getConversionFinishedHtml: function() {
		return $([
		                   "<span class='conversion-finished'>",
		                   "  <span class='icon-ok-sign'> </span>",
		                   Liferay.Language.get('conversion-finished'),
		                   "</span>"
		                 ].join("\n")).add(videoProcessor.getToolTipHtml());
	},
	getConversionFailedHtml: function(namespace, convertVideoURL, videoConversionStatusURL, id) {
		return $([
		                   "<span class='conversion-failed'>",
		                   "  <span class='icon-remove-sign'> </span>",
		                   Liferay.Language.get('conversion-failed') + " - ",
		                   "  <a class='force-underline' href='javascript:videoProcessor.convert(\""+namespace+"\",\""+convertVideoURL+"\",\""+videoConversionStatusURL+"\","+id+")'> ",
		                   		Liferay.Language.get('try-again'),
		                   "  </a>",
		                   "</span>"
		                 ].join("\n")).add(videoProcessor.getToolTipHtml());
	},
	convert: function(namespace, convertVideoURL, videoConversionStatusURL, id, workflow, layout, captionurl) {
		$videoconversionNode = $('*[data-video-id="'+id+'"]');
		$videoconversionNode.html(videoProcessor.getConversionInitializedHtml());
		AUI().use('aui-io-request', 'aui-node',
			function(A){
				var videoId = namespace + "videoId";
				var workflowDescriptor = namespace + "workflow";
				var layoutDescriptor = namespace + "layout";
				var captionurlDescriptor = namespace + "captionurl";
				
				var dataForPost = {};
				dataForPost[videoId] = id;
				if (typeof workflow != "undefined") {
					// if there is a non-default workflow specified, send it
					dataForPost[workflowDescriptor] = workflow;
				}
				if (typeof layout != "undefined") {
					// if there is are workflow variables specified, send them
					dataForPost[layoutDescriptor] = layout;
				}
				if (typeof captionurl != "undefined") {
					// if there is are workflow variables specified, send them
					dataForPost[captionurlDescriptor] = captionurl;
				}
				A.io.request(convertVideoURL, {
				 	dataType: 'json',
				 	method: 'POST',
				 	//send data to server
				 	data: dataForPost,
				 	//get server response
					on: {
						   success: function() {
							   var success = this.get('responseData').status;
							   if (success) {
								   videoProcessor.pollStatus(namespace, videoConversionStatusURL, convertVideoURL, id);
							   } else {
									$videoconversionNode.html(videoProcessor.getConversionFailedHtml(namespace, convertVideoURL, videoConversionStatusURL, id));
							   }

						   }
					}
				});	
			}
		);
	},
	pollStatus: function(namespace, videoConversionStatusURL, convertVideoURL, id) {
		// poll the video conversion provider for the current video conversion status
		AUI().use('aui-io-request', 'aui-node',
			function(A){
				var videoId = namespace + "videoId";
				var dataForPost = {};
				dataForPost[videoId] = id;
				A.io.request(videoConversionStatusURL, {
				 	dataType: 'json',
				 	method: 'POST',
				 	//send data to server
				 	data: dataForPost,
				 	//get server response
					on: {
						success: function() {
							var videoConversionStatus = this.get('responseData').videoConversionStatus;
							var $videoconversionNode = $('*[data-video-id="'+id+'"]');
							var prefix = "";
							// check if videoconversion node lies with admin-videolist-date, if so add a prefix to match the format
							if ($videoconversionNode.closest(".admin-videolist-date").length) {
								prefix = " | ";
							}

							switch(videoConversionStatus) {
								case "RUNNING":
									$videoconversionNode.html(prefix).append(videoProcessor.getConversionRunningHtml());
									// poll for a status update every 5 seconds if conversion is running
									setTimeout(function() {videoProcessor.pollStatus(namespace, videoConversionStatusURL, convertVideoURL, id);},5000);
						         	break;
								case "FINISHED":
									$videoconversionNode.html(prefix).append(videoProcessor.getConversionFinishedHtml());
									break;
								case "ERROR":
									$videoconversionNode.html(prefix).append(videoProcessor.getConversionFailedHtml(namespace, convertVideoURL, videoConversionStatusURL, id));
							}
					   }
					}
				});
			}
		);
	}
};