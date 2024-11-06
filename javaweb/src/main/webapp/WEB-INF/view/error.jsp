<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Error</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
  </head>
  
  <body style="padding: 15px">
  <!-- menu bar -->
		<%@include file="/WEB-INF/view/menu.jspf" %>
		
		<div style="padding: 15px">
    <h1 style="color: red">
      錯誤訊息: <%=request.getAttribute("message") %>
    </h1>
    </div>
  </body>
</html>