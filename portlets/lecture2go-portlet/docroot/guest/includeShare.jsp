<div id="metadata">
	<!-- Facebook Twitter Google+ -->
	<div class="sharetile">
		<p class="tileheading">social-media</p>
		<div id="socialshareprivacy"></div>
	</div>

	<script type="text/javascript">
		$('#socialshareprivacy').socialSharePrivacy({
			services : {
				gplus : {
					status : 'on'
				}
			}
		});
	</script>
	
	<br/>
	
	<form name="embedForm" id="embedForm">
		<!-- citation2go allowed -->
		<c:if test="${video.citation2go==1}">
				<div class="sharetile">
					<p class="tileheading">citation2go</p>
					<div id="c2g">
						<ul>
							<li>
								<aui:input name="segmentBegin" label="citation-start" required="false" id="timeStart" readonly="true"/>
							</li>
							<li>
								<aui:input name="segmentEnd" label="citation-end" required="false" id="timeEnd" readonly="true"/>
							</li>
							<li>
								<aui:input name="citation" label="citation" required="false" id="citation" readonly="true" onclick="document.embedForm._lgopenaccessvideos_WAR_lecture2goportlet_citation.focus(); document.embedForm._lgopenaccessvideos_WAR_lecture2goportlet_citation.select();"/>
							</li>
						</ul>
					</div>
				</div>
		</c:if>
		<!-- citation2go allowed end-->
		<!-- embed start -->
			<div class="sharetile">
				<p class="tileheading">links</p>
				<div id="urls">
					<ul>
						<li>
							<label>url </label>
							<input id="embed_code3" name="embed_code3" title="url-address-title" type="text" value="${video.url}" onclick="document.embedForm.embed_code3.focus();document.embedForm.embed_code3.select();" readonly />
						</li>
						<li>
							<label>embed-iframe </label>
							<input id="embed_code" name="embed_code" title="embed-iframe-title" type="text" value="${video.embedIframe}" onclick="document.embedForm.embed_code.focus();document.embedForm.embed_code.select();" readonly />
						</li>
						<c:if test="${video.downloadLink==1}">
							<li>
								<label>embed-html5 </label>
								<input id="embed_code1" name="embed_code1" title="embed-html5-title" type="text" value="${video.embedHtml5}" onclick="document.embedForm.embed_code1.focus();document.embedForm.embed_code1.select();" readonly />
							</li>
						</c:if>
					</ul>
				</div>
			</div>
		<!-- embed end -->
	</form>

	<br/>
	
	<p class="smallitalic">embed-conditions</p>
	<%@ include file="/guest/includeQR.jsp" %>
</div>