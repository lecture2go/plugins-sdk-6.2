AUI().ready(
	'liferay-hudcrumbs', 'liferay-navigation-interaction', 'liferay-sign-in-modal',
	function(A) {
		var navigation = A.one('#navigation');

		if (navigation) {
			navigation.plug(Liferay.NavigationInteraction);
		}

		var siteBreadcrumbs = A.one('#breadcrumbs');

		if (siteBreadcrumbs) {
			siteBreadcrumbs.plug(A.Hudcrumbs);
		}

		var signIn = A.one('li.sign-in a');

		if (signIn && signIn.getData('redirect') !== 'true') {
			signIn.plug(Liferay.SignInModal);
		}
		
		// fix navigation bug on chrome with touch devices
		fixNavigationHoverOnChromeTouchDevices();
	}
);

/**
 * This is workaround to fix missing mouseover event handler for the navigation 
 * elements if the user has a touch device and uses chrome. This seems to be a bug
 * from Liferay/ AUI
 */
function fixNavigationHoverOnChromeTouchDevices() {
	var isOpera = !!window.opera || navigator.userAgent.indexOf(' OPR/') >= 0;
	/* detect chrome */
	var isChrome = !!window.chrome && !isOpera;

	/* detect touch device */
	function isTouchDevice() {
	    return (('ontouchstart' in window)
	    || (navigator.MaxTouchPoints > 0)
	    || (navigator.msMaxTouchPoints > 0));
	}

	if(isTouchDevice() && isChrome){
		$(".nav>.lfr-nav-item").not(".responsive_li_item").mouseenter(function(){
			this.addClass("hover open");
		}).mouseleave(function() {
			this.removeClass("hover open");
		});
	}
}

//AUI().use('aui-viewport');