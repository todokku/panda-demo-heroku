panda.enable_loadmask_form = true;

//------------------------------------------------------
function s_preload() {
	$('body').append(
		'<div id="preload" class="p-dispear">'
			+ '<div class="ui-loadmask"></div>'
			+ '<div class="p-loader-fountain"></div>'
		+ '</div>');
}

//------------------------------------------------------
function s_setbase(c) {
	c = $.extend(site, c);
	$.cookie.defaults = c.cookie || {};
	return site;
}

//------------------------------------------------------
//site vars
//
var site = {
	statics: '/static'
};

//set default
s_setbase({
	base: '',
	cookie: { expires: 180 }
});

//------------------------------------------------------
$(function() {
	// enable script cache
	$.enableScriptCache();
	
	$('[data-toggle=offcanvas]').click(function() {
		$('.row-offcanvas').toggleClass('active');
	});
	$('[data-toggle=tooltip]').tooltip();
	$('[data-toggle=popover]').popover();

	$('#sidenav i').each(function() {
		$(this).attr('title', $(this).next('span').text());
	})

	s_setbase($.extend({ body: 'body' }, panda.meta_props()));

	s_preload();

	// google analytics
	s_google_analytics(site);
});

//------------------------------------------------------
function s_setLang(v) {
	location.href = $.addQueryParams(location.href, { '__locale': v });
}

//------------------------------------------------------
// google analytics
//
function s_google_analytics(c) {
	if (c.google_analytics && c.google_analytics != "${GA}") {
		(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
			(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
			m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
			})(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

		ga('create', c.google_analytics, 'auto');
		ga('send', 'pageview');
	}
}

