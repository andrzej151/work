$(document).ready(function(){
	ustaw();
	


	$(".wolne").click(function(){
		
		$("#miejsce").text("ok").addClass("wolne").css($(this).css("top")+10);
															
	});
	
});


function ustaw()
{
	var iloscstanowisk=3
	var wolne= new Array(true, false, true);
	var pozycjax= new Array(30,70,100);
	var pozycjay= new Array(50,70,100);
	var sizew=40;
	var sizeh=40;

	for(var i=0;i<iloscstanowisk;i++)
	{
		 
		var t='<div id="stanowisko'+i+'"><center>'+i+'</center></div>"';
		if(wolne[i])
		{
					$(t).insertAfter("#parter > img").addClass("wolne").css(
																{"top":pozycjay[i], "left":pozycjax[i], "width":sizew, "height":sizeh});
		}
		else
		{
			$(t).insertAfter("#parter > img").addClass("zajete").css(
																{"top":pozycjay[i], "left":pozycjax[i], "width":sizew, "height":sizeh});
		}
	}
	t='<div id="miejsce"></div>"';
	$(t).insertAfter("#parter > img");

}


