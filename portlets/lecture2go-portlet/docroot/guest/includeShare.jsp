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
								<label class="citation-label">citation-start</label>
								<input type="text" id="clipStartTime" onclick="updateL2GoTimeForStart();" title="citation2go-set-start-point" name="citation2go-set-start-point" value="click" size="5" maxlength="7" readonly/>
							</li>
							<li>
								<label class="citation-label">citation-end</label>
								<input type="text" id="clipEndTime" onclick="updateL2GoTimeForEnd();" title="citation2go-set-end-point" name="citation2go-set-end-point" value="click" size="5" maxlength="7" readonly/>
							</li>
							<li>
								<label class="citation-label">url</label>
								<input type="text" id="zitat" name="embed_code5" title="citation2go-title" value="" onclick="document.embedForm.embed_code5.focus();document.embedForm.embed_code5.select();" readonly />
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