<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.List"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="main.css">
        <title>File Upload Example in JSP and Servlet - Java web application</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
  
    <body> 
    	<div class="topnav">
          <a href=index.jsp>Index</a>
          <a class="active" href="gallery.html">Gallery</a>
        </div>
        <div class="container-fluid">  
        <% ArrayList<String> images =  (ArrayList<String>)request.getAttribute("images"); 
         int index = 0;
         for(String s:images){%>  
           <% if(index%3 == 0) {%>
           		<div class="row">
           <% }%>
                <div class="col-sm-4"><img width="300" height="300" src=<%=s%>></img></div> 
             
             <% if(index%3 == 2) {%>
           		</div>
          	 <% }%>
            <% index++; }%>  
        </div>
       
    </body>
</html>