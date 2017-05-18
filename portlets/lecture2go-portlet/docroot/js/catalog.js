
$( function() {
	//turn off autocomplete
	$(document).on('focus', ':input', function() {
	    $(this).attr('autocomplete', 'off');
	});
	// only show the last terms
	var maxTerms = 4;
	$("ul.terms > li").slice(maxTerms).hide();
	// show the remaining terms
	$('#loadMoreTerms').click(function () {
	    $('ul.terms > li').show();
	    $('#loadMoreTerms').hide();
	});
	
	// toggles the panel if necessary
    toggleFilterPanel();
    
    // This is a workaround for binding the Javascript callbacks to the Videotiles. Usually the $(function() {...} should
    // execute when the dom is ready, but the liferay search container seems to build the html later then the onload event
    function start() {
		var tile = $("#_lgopenaccessvideos_WAR_lecture2goportlet_lectureseriesesSearchContainer div.videotile.wide");
		if (tile.size() > 0) {then()}
		else {
			setTimeout(start, 200);
		};
	}
	
	start();
	
	function then() {
		var tile = $("#_lgopenaccessvideos_WAR_lecture2goportlet_lectureseriesesSearchContainer div.videotile.wide");
		tile.on({
			click: function () {
					$(this).find("button").toggleClass("rotated");
					$(this).siblings("div").find("ul").slideToggle();
			},
			mouseenter: function () {
				$(this).find("button").addClass("highlight");
			},
			mouseleave: function () {
				$(this).find("button").removeClass("highlight");
			}
		});
	
		// if a link on the tile is clicked, do not let the event bubble up to the tile itself
		tile.find("a").click(function(e) {
			e.stopPropagation();
		});
	}
});

function toggleFilterPanel(){
	mediaCheck({
		  media: '(max-width: 767px)',
		  entry: function() {
		    $('.notFiltered').find('.toggler-content-expanded').addClass('toggler-content-collapsed').removeClass('toggler-content-expanded');
    		$('.notFiltered').find('.toggler-header-expanded').addClass('toggler-header-collapsed').removeClass('toggler-header-expanded');
    		$('.filtered').find('.toggler-header-collapsed').addClass('toggler-header-expanded').removeClass('toggler-header-collapsed');
		    $('.filtered').find('.toggler-content-collapsed').addClass('toggler-content-expanded').removeClass('toggler-content-collapsed');
		  },
		  exit: function() {
			$('.accordion-group').find('.toggler-content-collapsed').addClass('toggler-content-expanded').removeClass('toggler-content-collapsed');
		  	$('.accordion-group').find('.toggler-header-collapsed').addClass('toggler-header-expanded').removeClass('toggler-header-collapsed');
		  }
		});
}
