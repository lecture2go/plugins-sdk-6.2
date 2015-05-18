<div id="metadata">
	<c:if test="${video.downloadLink==1}">
		<!-- openaccess start -->
		<c:if test="${video.openAccess==1}">
			<div id="downloads">
				<c:if test="${video.mp4File.isFile()==true}">
					<div class="download">
						<a href="#" target="_blank"> <span class="icon-large icon-film"/><br/>mp4-video </a>
					</div>
				</c:if>
				<c:if test="${video.mp3File.isFile()==true}">
					<div class="download">
						<a href="#" target="_blank"> <span class="icon-large icon-music"/><br/>mp3-audion </a>
					</div>
				</c:if>

				<c:if test="${video.pdfFile.isFile()==true}">
					<div class="download">
						<a href="#" target="_blank"> <span class="icon-large icon-book"/><br/>pdf-text </a>
					</div>
				</c:if>
				
				<c:if test="${video.m4vFile.isFile()==true}">
					<div class="download">
						<a href="#" target="_blank"> <span class="icon-large icon-facetime-video"/><br/>m4v-video </a>
					</div>
				</c:if>

				<c:if test="${video.m4aFile.isFile()==true}">
					<div class="download">
						<a href="#" target="_blank"> <span class="icon-large icon-headphones"/><br/>m4a-audio </a>
					</div>
				</c:if>
			</div>
		</c:if>
		<!-- openaccess end -->

		<em class="smallitalic"><br />download-text</em>
	</c:if>
</div>