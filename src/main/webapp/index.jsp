<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--https://tomcat.apache.org/download-60.cgi or better yet fix on oliva-->
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a><br>
<a href="example-servlet">Example Servlet</a><br/>
<a href="index.html">index</a><br/>
<a href="https://www.javatpoint.com/jstl">javapoint link</a><br/>
<a href="${pageContext.request.contextPath}/movie-list.dispatch">Movies</a><br/>
<a href="parameter-servlet?key=value&otherkey=othervalue">parameters</a><br/>
<!--add slash at beggining for absolute position rather than relative -->
</body>
</html>