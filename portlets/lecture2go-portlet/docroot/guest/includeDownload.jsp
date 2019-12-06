<c:if test="${video.downloadLink==1}">
<div id="down">
		<!-- openaccess start -->
			<div id="downloads">
				<c:if test="${video.mp4File.isFile()==true}">
					<div class="download">
						<a href="${video.mp4DownloadLink}" download> <span class="icon-large icon-film"></span><br/><liferay-ui:message key="mp4-video"/> </a>
					</div>
				</c:if>
				<c:if test="${video.mp3File.isFile()==true}">
					<div class="download">
						<a href="${video.mp3DownloadLink}" download> <span class="icon-large icon-music"></span><br/><liferay-ui:message key="mp3-audio"/> </a>
					</div>
				</c:if>

				<c:if test="${video.pdfFile.isFile()==true}">
					<div class="download">
						<a href="${video.pdfDownloadLink}" download> <span class="icon-large icon-book"></span><br/><liferay-ui:message key="pdf-text"/> </a>
					</div>
				</c:if>
				
				<c:if test="${video.m4vFile.isFile()==true}">
					<div class="download">
						<a href="${video.m4vDownloadLink}" download> <span class="icon-large icon-film"></span><br/><liferay-ui:message key="m4v-video"/> </a>
					</div>
				</c:if>

				<c:if test="${video.m4aFile.isFile()==true}">
					<div class="download">
						<a href="${video.m4aDownloadLink}" download> <span class="icon-large icon-music"></span><br/><liferay-ui:message key="m4a-audio"/> </a>
					</div>
				</c:if>

				<c:if test="${video.oggFile.isFile()==true}">
					<div class="download">
						<a href="${video.oggDownloadLink}" download> <span class="icon-large icon-film"></span><br/><liferay-ui:message key="ogg-video"/> </a>
					</div>
				</c:if>

				<c:if test="${video.webmFile.isFile()==true}">
					<div class="download">
						<a href="${video.webmDownloadLink}" download> <span class="icon-large icon-film"></span><br/><liferay-ui:message key="webm-video"/> </a>
					</div>
				</c:if>

				<c:if test="${video.flvFile.isFile()==true}">
					<div class="download">
						<a href="${video.flvDownloadLink}" download> <span class="icon-large icon-film"></span><br/><liferay-ui:message key="flv-video"/> </a>
					</div>
				</c:if>
			</div>
		<!-- openaccess end -->
</div>
</c:if>