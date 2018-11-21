<%@page import="com.javalec.mysite.vo.BoardVO"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>글 상세</title>
</head>
<body>
	<% if(session.getAttribute("id")==null){
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.forward(request, response);
			}
	%>
				<center>
					<h1>게시글 상세</h1>
					<hr>
					<form action="" method="post">

						<table border="1" cellpadding="0" cellspacing="0" width=700px>
							<tr>
								<td  width=20%>제목</td>
								<td >&nbsp;&nbsp;<input name="" type="text"
									 disabled="disabled"/></td>
							</tr>
							<tr>
								<td >작성자</td>
								<td >&nbsp;&nbsp;<input name="" type="text"
									disabled="disabled" /></td>
							</tr>
							<tr>
								<td >내용</td>
								<td >&nbsp;&nbsp;<textarea name="" cols="70" rows="10" disabled="disabled"></textarea>
								</td>
							</tr>
							<tr>
								<td >등록일</td>
								<td ></td>
							</tr>
							<tr>
								<td >조회수</td>
								<td ></td>
							</tr>

						</table>
					</form>
					<hr>
				</center>
				<div align="center"	width:100%	height:50px  margin:20px auto;>
					<a href="" >변경</a>&nbsp;&nbsp;&nbsp; 
					<a href="" >삭제</a>&nbsp;&nbsp;&nbsp;
					<a href="" >목록</a>
				</div>
</body>
</html>
