$("#nextButton").click(function(){
	if(!window.session)
		navigator.id.request();
});
$("#backButton").click(function(){
	window.location.assign("/");
});