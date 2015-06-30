<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Actions</th>
            </tr>            
            <c:forEach items="${applist}" var="app">
                <tr>
                    <td>${app.idApp}</td>
                    <td>${app.nameApp}</td>
                    <td>                        
                        <a href= "<c:url value="/app/edit/${app.idApp}"/>">Edit</a>
                        <a href= "<c:url value="/app/delete/${app.idApp}"/>">Delete</a>
                    </td>
                </tr>                
            </c:forEach>
        </table>
    </body>
</html>
