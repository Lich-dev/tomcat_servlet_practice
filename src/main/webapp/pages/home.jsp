<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%--jsp tag library, this one enables (bad) java, theres also one for sql--%>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Home Page</h1>
<h2>
    <c:if test="${empty email}"><%--not or ! for negating--%>
        User not logged in!
    </c:if>
    <c:if test="${not empty email}">
        Welcome ${user}<br>

        <form name="log-out" action="/log-out-servlet" method="post">
            <input type="submit" value="Log off">
        </form>
    </c:if>
    <%
        //pure java code
        Enumeration<String> attributes = session.getAttributeNames();
        out.print("<ul>");
        while(attributes.hasMoreElements()){
            String attribute = attributes.nextElement();
            out.print("<li>"+attribute+": "+session.getAttribute(attribute)+"</li>");
        }
        out.print("</ul>");
    %>
</h2>
</body>
</html>
