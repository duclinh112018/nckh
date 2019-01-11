$(document).ready(function(){
	$('#search-box').hide();
	$(".collapse").collapse('hide');
	checkEnable = false;
	checkEnableMenu = false;
	$('.slider-slick').slick({
        infinite: true,
        slidesToShow: 1,
        slidesToScroll: 1,
        fade: true,
        cssEase: 'linear',
        autoplay: true,
        autoplaySpeed: 1800,
        prevArrow : false,
        nextArrow : false,


        responsive: [
        {
          breakpoint: 992,
          settings: {
            slidesToShow: 1,
            slidesToScroll: 1
          }
        },
        {
          breakpoint: 768,
          settings: {
            slidesToShow: 1,
            slidesToScroll: 1
          }
        },
        {
          breakpoint: 576,
          settings: {
            slidesToShow: 1,
            slidesToScroll: 1
          }
        }
        // You can unslick at a given breakpoint now by adding:
        // settings: "unslick"
        // instead of a settings object
      ]
    });

});

function visitedMenu(btn) {
	if (btn == true) {
		$('#header').hover(		
	        function fat() {
	          $(this).css({"background-color":"#fff"});
	          $('.ic-menu').css('background-image',"url('asset/images/bar-black.png')");
	          $('#logo-ic img').attr('src','asset/images/logo/logo-black.png');
	          $('#name_mjf').css('color', 'black');
	          $('.ic-search').css('background-image',"url('asset/images/ic-search-black.png')");
	          $('.ic-cast').css('background-image',"url('asset/images/ic-cast-black.png')");
	          $('.ic-user').css('background-image',"url('asset/images/ic-user-black.png')");
	       }, 
			
	       function ftt() {
	          $(this).css({"background-color":"transparent"});
	          $('.ic-menu').css('background-image',"url('asset/images/bar.png')");
	          $('#logo-ic img').attr('src','asset/images/logo/logo.png');
	          $('#name_mjf').css('color', '#fff');
	          $('.ic-search').css('background-image',"url('asset/images/search-ic.png')");
	          $('.ic-cast').css('background-image',"url('asset/images/scast.png')");
	          $('.ic-user').css('background-image',"url('asset/images/ic-user.png')");
	       }
	    );
	} else if (btn == false) {
		$('#header').css({"background-color":"#fff"});
		$('.ic-menu').css('background-image',"url('asset/images/bar-black.png')");
		$('#logo-ic img').attr('src','asset/images/logo/logo-black.png');
		$('#name_mjf').css('color', 'black');
		$('.ic-search').css('background-image',"url('asset/images/ic-search-black.png')");
		$('.ic-cast').css('background-image',"url('asset/images/ic-cast-black.png')");
		$('.ic-user').css('background-image',"url('asset/images/ic-user-black.png')");	
	}
}

function enableMenuHidden() {
	if (!checkEnableMenu) {
		$(".collapse").collapse('toggle');
		$('.ic-menu').css('background-image',"url('asset/images/ic-menu-close.png')");
		check = false;
		checkEnableMenu = true;

	} else {
		$(".collapse").collapse('toggle');
		$('.ic-menu').css('background-image',"url('asset/images/bar-black.png')");
		check = true;
		checkEnableMenu = false;
	}
}

function enableOrDisableSearchBox(btn) {
	if(checkEnable) {
		$('#search-box').hide();
		checkEnable = false;
	} else {
		$('#search-box').show();
		checkEnable = true;
	}
}
