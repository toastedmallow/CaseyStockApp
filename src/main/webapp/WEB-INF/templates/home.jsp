
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>
    Hello World! Welcome to ${title}
    
    <br/>
    <c:forEach var="i" items="${someList}">
   		<c:out value="${i}"/><br/>
	</c:forEach>
</body>
</html>