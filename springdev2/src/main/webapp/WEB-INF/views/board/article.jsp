<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/park2.png"/>
</head>
<body>
<c:set var="vo" value="${boardVO}"></c:set>
<table>
	<tr>
		<th>번호</th>
		<td>${vo.no}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${vo.title}</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${vo.name}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${vo.content}</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${vo.regdate}</td>
	</tr>	
	<tr>
		<th>조회수</th>
		<td>${vo.readcount}</td>
	</tr>
</table>
<a href="update?no=${vo.no}">수정</a> <a href="delete?no=${vo.no}">삭제</a> <a href="list">리스트</a> <a href="reply?no=${vo.no}">답글</a>
</body>
</html>