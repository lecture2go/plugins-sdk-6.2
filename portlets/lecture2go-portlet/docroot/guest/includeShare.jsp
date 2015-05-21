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

			<div class="sharetile">
				<p class="tileheading">links</p>
				<div id="urls">
					<ul>
						<li>
							<label class="citation-label">url </label>
							<input id="embed_code3" name="embed_code3" title="url-address-title" type="text" value="${video.url}" onclick="document.embedForm.embed_code3.focus();document.embedForm.embed_code3.select();" readonly />
						</li>
						<li>
							<label class="citation-label">embed </label>
							<input id="embed_code" name="embed_code" title="embed-title" type="text" value="#" readonly />
						</li>
					</ul>
				</div>
			</div>
	</form>

	<br/>
	
	<p class="smallitalic">embed-conditions</p>
	<%@ include file="/guest/includeQR.jsp" %>
</div>