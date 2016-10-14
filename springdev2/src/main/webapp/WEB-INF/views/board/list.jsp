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
<table border="1">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>이름</th>
	<th>날짜</th>
	<th>조회</th>
</tr>	
<c:forEach var="vo" items="${list}">
<tr>
	<td>${vo.no}</td>
	<td>
	<c:if test="${vo.level > 1}">
		<c:forEach var="le" begin="1" end="${vo.level-2}">
		&nbsp;&nbsp;&nbsp;&nbsp;
		</c:forEach>
	
		<span style="color: red;">└</span>
	</c:if>
	<a href="article?no=${vo.no}">${vo.title}</a></td>
	<td>${vo.name}</td>
	<td>${vo.regdate}</td>
	<td>${vo.readcount}</td>
</tr>
</c:forEach>
</table>
<a href="/insert">입력</a>
</body>
</html>