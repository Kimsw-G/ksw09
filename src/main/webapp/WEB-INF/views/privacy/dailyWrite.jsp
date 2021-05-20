<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="wrapper">
		<jsp:include page="./todonav/todoNav.jsp"/>
	<form action="/todo/dailyWrite" method="post">
		<%-- 드롭다운으로 dday 일정과 연동시키기 --%>
		<c:forEach var="i" begin="1" end="7">
			${date[i-1]}<input type="checkbox" value="${i-1}" name="todoDate">
		</c:forEach>
		<input type="text" name="ctnt">
	
		<input type="submit" value="등록하기">
	</form>
	</div>
</body>
</html>

