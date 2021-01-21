<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
   #gallery_01 img{border:2px solid white;}
   .active img{border:2px solid #333 !important;}
  </style>
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery.elevatezoom.js"></script>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<img id="zoom_01" src='images/small/son1.png' data-zoom-image="images/large/son1.jpg"/>
<img id="zoom_02" src='images/small/image1.png' data-zoom-image="images/large/image1.jpg">

<img id="zoom_03" src="images/small/image1.png" data-zoom-image="images/large/image1.jpg"/> 
   <div id="gallery_01"> 
    <a href="#" data-image="images/small/image1.png" data-zoom-image="images/large/image1.jpg"> 
     <img class="gallery" src="images/thumb/image1.jpg" /> 
    </a> 
    <a href="#" data-image="images/small/image2.png" data-zoom-image="images/large/image2.jpg"> 
     <img id="gallery" src="images/thumb/image2.jpg" /> 
    </a> 
    <a href="#" data-image="images/small/image3.png" data-zoom-image="images/large/image3.jpg"> 
     <img class="gallery" src="images/thumb/image3.jpg" /> 
    </a> 
     <a href="#" data-image="images/small/image4.png" data-zoom-image="images/large/image4.jpg"> 
     <img class="gallery" src="images/thumb/image4.jpg" /> 
    </a> 
   </div>
<script>
$(function(){   
$('#zoom_01').elevateZoom({
    zoomType: "inner",
cursor: "crosshair",
zoomWindowFadeIn: 500,
zoomWindowFadeOut: 750
   });
$("#zoom_02").elevateZoom({
     zoomType   : "lens",
     lensShape : "round",
     lensSize    : 200
   });
$("#zoom_03").elevateZoom({gallery:'gallery_01', 
     cursor: 'pointer', 
     galleryActiveClass: 'active', 
     imageCrossfade: true, 
     loadingIcon: 'http://www.elevateweb.co.uk/spinner.gif'}); 
     $("#zoom_03").bind("click", function(e) { var ez = $('#zoom_03').data('elevateZoom'); $.fancybox(ez.getGalleryList()); return false; }); 
});
</script>
</body>
</html>