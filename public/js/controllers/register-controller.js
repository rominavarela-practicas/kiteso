angular.module('KItesoApp',[]).controller('Controller',function(){
	$("#nextButton").click(function(){
		if(!window.session)
			navigator.id.request();
	});
	$("#backButton").click(function(){
		window.location.assign("/");
	});
	
	$(document).on("ready",function(){
		
		//$('input:radio[name=mascu]').attr('checked',false);
		//$('input:radio[name=femm]').attr('checked',false);
		
		$('input:radio[name=sex]:nth(0)').attr('checked',false);
		
		$('input:radio[name=sex]:nth(1)').attr('checked',false);
		
		    $("#fem").click(function() {
		    	$('input:radio[name=sex]:nth(0)').attr('checked',true);
		    	if($('input:radio[name=sex]:nth(0)').val()==true)
		    		{
		    		$('input:radio[name=sex]:nth(1)').attr('checked',false);
		    		
		    		}
		    
		    });

		    $('#masc').click(function() {
		    	$('input:radio[name=sex]:nth(1)').attr('checked',true);
		    	if($('input:radio[name=sex]:nth(1)').val()==true)
		    		{
		    		$('input:radio[name=sex]:nth(0)').attr('checked',false);
		    		
		    		}
		    });

		
	})
});