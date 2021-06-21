$( document ).ready( function() {
	$(window).on("scroll", function(){
		var scroll_top=$(this).scrollTop();
		if(scroll_top==0){
			$('.Header').css('position','absolute');
			$('.Header').css('font-size','30px');
			$('.Header').css('color','white');
			$('.Header').css('line-height','60px');
			$('.Header').css('padding','20px 30px');
			$('.Header').css('background','none');
			$('.Header').css('box-shadow','none');
			$('#main_search').css('width','50%');
			$('#main_search').css('top','100px');
			$('#main_searchbar').css('height','60px');
			$('#search_title').css('border-bottom','none');
			$('#search_title').css('border-radius','30px 0px 0px 30px');
			$('#search_title').css('border-right','2px solid lightgray');
			$('#search_date').css('width','100%');
			$('#search_date').css('border-right','2px solid lightgray');
			$('#search_author').css('width','100%');
			$('#search_btn').css('width','60px');
			$('#search_btn').css('height','60px');
			$('#search_title').blur();
			$('#search_date').css('display','inline-block');
			$('#search_author').css('display','inline-block');
			$('#header_right a').css('color','rgb(168, 215, 253)');
		}
		if(scroll_top!=0){
			$('.Header').css('position','fixed');
			$('.Header').css('font-size','20px');
			$('.Header').css('color','black');
			$('.Header').css('line-height','40px');
			$('.Header').css('padding','10px 30px');
			$('.Header').css('background','white');
			$('.Header').css('box-shadow','0px 2px 3px 2px grey');
			$('#main_search').css('width','30%');
			$('#main_search').css('top','10px');
			$('#main_searchbar').css('height','40px');
			$('#search_title').css('border-bottom','2px solid red');
			$('#search_title').css('border-radius','0px');
			$('#search_title').css('border-right','none');
			$('#search_date').css('width','0px');
			$('#search_date').css('border','0px');
			$('#search_author').css('width','0px');
			$('#search_btn').css('width','30px');
			$('#search_btn').css('height','30px');
			$('#search_date').css('display','none');
			$('#search_author').css('display','none');
			$('#header_right a').css('color','black');
		}
	});
	
	$('#search_title').focus(function(){
		$('#search_title').css('border-right','none');
		$('#search_date').css('width','0px');
		$('#search_date').css('border','0px');
		$('#search_author').css('width','0px');
	});
	
	$('#search_title').blur(function(){
		$('#search_title').css('border-right','2px solid lightgray');
		$('#search_date').css('width','100%');
		$('#search_date').css('border-right','2px solid lightgray');
		$('#search_author').css('width','100%');
	});
	
	$('#search_date').focus(function(){
		$('#search_date').css('border-radius','30px 0px 0px 30px');
		$('#search_date').css('border-right','none');
		$('#search_title').css('width','0px');
		$('#search_title').css('border','0px');
		$('#search_author').css('width','0px');
	});
	
	$('#search_date').blur(function(){
		$('#search_date').css('border-radius','none');
		$('#search_date').css('border-right','2px solid lightgray');
		$('#search_title').css('width','100%');
		$('#search_title').css('border-right','2px solid lightgray');
		$('#search_author').css('width','100%');
	});
	
	$('#search_author').focus(function(){
		$('#search_author').css('border-radius','30px 0px 0px 30px');
		$('#search_date').css('border-right','none');
		$('#search_title').css('width','0px');
		$('#search_title').css('border','0px');
		$('#search_date').css('width','0px');
	});
	
	$('#search_author').blur(function(){
		$('#search_author').css('border-radius','none');
		$('#search_date').css('border-right','2px solid lightgray');
		$('#search_title').css('width','100%');
		$('#search_title').css('border-right','2px solid lightgray');
		$('#search_date').css('width','100%');
	});
	
	$('#search_author').on("change", function(){
		$('#search_title').val("");
		$('#search_date').val(null);
	});
	$('#search_title').on("change", function(){
		$('#search_author').val("");
		$('#search_date').val(null);
	});
	$('#search_date').on("change", function(){
		$('#search_author').val("");
		$('#search_title').val(null);
	});
});
