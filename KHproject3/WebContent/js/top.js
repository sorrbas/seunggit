 $(function(){
    $(".menu li a").wrapInner( '<span class="out"></span>' );

    $(".menu li a").each(function() {
     $( '<span class="over">' +  $(this).text() + '</span>' ).appendTo( this );
    });


    $(".menu li a").hover(function() {
     $(".out", this).stop().animate({'top': '45px'}, 200); 
     $(".over", this).stop().animate({'top': '0px'}, 200);

    }, function() {
     $(".out", this).stop().animate({'top': '0px'},  200); 
     $(".over", this).stop().animate({'top': '-45px'}, 200);
    });
   });
 
 $('#news').innerfade({
		animationtype : 'slide',
		speed : 750,
		timeout : 2000,
		type : 'sequence',
		containerheight : '1em'
	});