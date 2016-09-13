$(document).ready(function(){
	ustaw();
	



	$(".wolne").click(function(){

		$(".wolne").removeClass("wybrane");
		$(this).addClass("wybrane");
		m=$(this).attr("value")
		$.get(
		    "miejsca.php",
		    {
		       
		       miejsce: m,
		    },
		    function(dane){
		        $("#parternotatka").html(dane);
		    }
		);
		
															
	});
	
});


function ustaw()
{
	
	 
	        $.ajax({
                type: "POST",
                url: "wolne.php",
                dataType : 'json',
                data: {
                    
                },
                success : function(json) {

                 var wolne=new Array();
                	console.log("start");
                    $.each(json, function(i, ob) {
                      console.log(ob);
                     wolne=ob;
						var pozycjax= new Array(150,150,150,150,150,190,190,190,190,190);
						var pozycjay= new Array(150,190,230,270,310,150,190,230,270,310);
						var sizew=40;
						var sizeh=40;

						for(var i=0;i<wolne.length;i++)
						{
							 
							var t='<div value="'+(i+1)+'"><center>'+(i+1)+'</center></div>"';
							if(wolne[i]==0)
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
                    });

                    
	$(".wolne").click(function(){

		$(".wolne").removeClass("wybrane");
		$(this).addClass("wybrane");
		m=$(this).attr("value")
		$.get(
		    "miejsca.php",
		    {
		       
		       miejsce: m,
		    },
		    function(dane){
		        $("#parternotatka").html(dane);
		    }
		);
		
															
	});

                  
                },
                error: function() {
                    console.warn('wystąpił błąd');
                }
            })

	
	

}


