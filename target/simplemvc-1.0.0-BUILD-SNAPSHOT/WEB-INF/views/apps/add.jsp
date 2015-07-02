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
        <sf:form method="POST" action="add" modelAttribute="application"> 
            <label for="prm_name" >NAME: </label>
            <sf:input path="nameApp" id="prm_name"/>
            <sf:checkboxes items="${privList}" path="privs" itemValue="idPriv" itemLabel="namePriv"/>
            <input value="Submit" type="submit"  />
        </sf:form>   
    </body>
</html>
