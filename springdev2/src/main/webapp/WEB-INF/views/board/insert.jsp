<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.png" />
</head>
<body>
	<table>
	<caption>게시물 입력</caption>
	<form action="insert" method="post">
		
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" /></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="5" cols="10" name="content"></textarea></td>
		</tr>
		<tr>
			<input type="submit" value="전송">
			
		</tr>
		</form>
	</table>
</body>
</html>