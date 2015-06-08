<c:if test="${video.downloadLink==1}">
	<div id="down">
		<!-- openaccess start -->
		<c:if test="${video.openAccess==1}">
			<div id="downloads">
				<c:if test="${video.mp4File.isFile()==true}">
					<div class="download">
						<a href="${video.mp4OpenAccessDownloadLink}" target="_blank"> <span class="icon-large icon-film"/><br/>mp4-video </a>
					</div>
				</c:if>
				<c:if test="${video.mp3File.isFile()==true}">
					<div class="download">
						<a href="${video.mp3OpenAccessDownloadLink}" target="_blank"> <span class="icon-large icon-music"/><br/>mp3-audion </a>
					</div>
				</c:if>

				<c:if test="${video.pdfFile.isFile()==true}">
					<div class="download">
						<a href="${video.pdfOpenAccessDownloadLink}" target="_blank"> <span class="icon-large icon-book"/><br/>pdf-text </a>
					</div>
				</c:if>
				
				<c:if test="${video.m4vFile.isFile()==true}">
					<div class="download">
						<a href="${video.m4vOpenAccessDownloadLink}" target="_blank"> <span class="icon-large icon-facetime-video"/><br/>m4v-video </a>
					</div>
				</c:if>

				<c:if test="${video.m4aFile.isFile()==true}">
					<div class="download">
						<a href="${video.m4aOpenAccessDownloadLink}" target="_blank"> <span class="icon-large icon-headphones"/><br/>m4a-audio </a>
					</div>
				</c:if>

				<c:if test="${video.oggFile.isFile()==true}">
					<div class="download">
						<a href="${video.oggOpenAccessDownloadLink}" target="_blank"> <span class="icon-large icon-headphones"/><br/>ogg-video </a>
					</div>
				</c:if>

				<c:if test="${video.webmFile.isFile()==true}">
					<div class="download">
						<a href="${video.webmOpenAccessDownloadLink}" target="_blank"> <span class="icon-large icon-headphones"/><br/>webm-video </a>
					</div>
				</c:if>

				<c:if test="${video.flvFile.isFile()==true}">
					<div class="download">
						<a href="${video.flvOpenAccessDownloadLink}" target="_blank"> <span class="icon-large icon-headphones"/><br/>flv-video </a>
					</div>
				</c:if>
			</div>
		</c:if>
		<!-- openaccess end -->
		<em class="smallitalic"><br />download-text</em>
	</div>
</c:if>