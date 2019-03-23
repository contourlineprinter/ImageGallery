<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="app.Client" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="main.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

<div class="topnav">
          <a href="index.jsp">Index</a>
          <a href="gallery.html">Gallery</a>
          <a class="active" href="socket.html">Socket</a>
        </div>

<div style="padding-top: 32px">
<div class="w3-container">

<form action="open_socket" method="get">
  <input class="w3-button w3-black" type="submit" value="Front">
</form>

<form action="open_socket" method="get">
  <input class="w3-button w3-black" type="submit" value="Back">
</form>

<form action="open_socket" method="get">
  <input class="w3-button w3-black" type="submit" value="Circle">
</form>
</div>
</div>
<div id="clients">
<% Object str = request.getAttribute("message"); if (str != null){ %>
<h3>File path: <%=  str %> </h3>
</div>
<%} %>
</body>
</html>