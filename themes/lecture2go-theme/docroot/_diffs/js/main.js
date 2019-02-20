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
		
		// fix navigation bug on chrome or firefox with touch devices
		fixNavigationHoverOnTouchDevices();
	}
);

/**
 * This is workaround to fix missing mouseover event handler for the navigation 
 * elements if the user has a touch device and uses chrome or now also firefox (since 60+). This seems to be a bug
 * from Liferay/ AUI
 */
function fixNavigationHoverOnTouchDevices() {
	/* detect chrome */
	var isChrome = !!window.chrome && (!!window.chrome.webstore || !!window.chrome.runtime);
	
	/* detect firefox */
	var isFirefox = typeof InstallTrigger !== 'undefined';


	/* detect touch device */
	function isTouchDevice() {
	    return (('ontouchstart' in window)
	    || (navigator.MaxTouchPoints > 0)
	    || (navigator.msMaxTouchPoints > 0));
	}

	if(isTouchDevice() && (isChrome || isFirefox)){
		$(".nav>.lfr-nav-item").not(".responsive_li_item").mouseenter(function(){
			$(this).addClass("hover open");
		}).mouseleave(function() {
			$(this).removeClass("hover open");
		});
	}
}

//AUI().use('aui-viewport');