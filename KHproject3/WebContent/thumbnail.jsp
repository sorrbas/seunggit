<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.File"%>
<%@page import="java.awt.Graphics2D"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="javax.media.jai.RenderedOp"%>
<%@page import="javax.media.jai.JAI"%>
<%@page import="java.awt.image.renderable.ParameterBlock"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

   ServletContext context = request.getServletContext();
  //모든것의 관문이란 뜻   SecletContext
  String imagePath = context.getRealPath("images");
  //폴더의 경로 images에 넣을거니까 images라고 해줌
  int size = 1*1024*1024;
  String filename = "";
  
  
  MultipartRequest multi = new MultipartRequest(request,imagePath,size,"utf-8",new DefaultFileRenamePolicy());
  //new DefaultFileRenamePolicy() 이름이 없는 생성자 함수 한번 쓰고 버릴 때 사용
  try{
  Enumeration files = multi.getFileNames();
  //  Enumeration 파일에 빠르게 접근하기 위해
  String file = (String)files.nextElement();
  filename = multi.getFilesystemName(file);
  }catch(Exception e) {
	  e.printStackTrace();
  }

  ParameterBlock pb = new ParameterBlock();
  pb.add(imagePath+"/"+filename);
  RenderedOp rOp = JAI.create("fileload",pb);
  BufferedImage bi = rOp.getAsBufferedImage();
  BufferedImage thumb = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
  Graphics2D g = thumb.createGraphics();
  g.drawImage(bi, 0, 0, 100, 100, null);
  File file  = new File(imagePath+"/sm_"+filename);
  ImageIO.write(thumb, "jpg", file);
  
  
  
  
%>

- 원본이미지 <br> 
<img src="images/<%=filename %>"><p>
- 썸네일 이미지 <br>
<img src="images/sm_<%=filename %>">

</body>
</html>