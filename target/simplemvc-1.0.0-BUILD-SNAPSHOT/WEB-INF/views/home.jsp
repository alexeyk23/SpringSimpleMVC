<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<c:forEach items="${primitives}" var="primitive">
	<p>${primitive.id}</p>
</c:forEach>
<sf:form method="POST" modelAttribute="prim">
<label for="prm_id" >ID: </label><sf:input path="id" id="prm_id"/>

<label for="prm_name" >NAME: </label><sf:input path="name" id="prm_name"/>
<input value="Submit" type="submit" />
</sf:form>
</body>
</html>
