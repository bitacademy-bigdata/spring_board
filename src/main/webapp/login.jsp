<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>로그인</title>

</head>
<body>

	<center>
		<h3>로그인</h3>
		<hr>
		<form action="write.do" method="post" enctype="multipart/form-data">
			<table border="1" cellpadding="0" cellspacing="0" width=700px>
				<tr>
					<td width=50%>아이디</td>
					<td>&nbsp;&nbsp;<input type="text" name="" size="20" /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>&nbsp;&nbsp;<input type="password" name="" size="20" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="로그인" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<a href="joinform.jsp">회원가입</a> <a href="findpassword.jsp">비밀번호 찾기</a></td>
				</tr>
			</table>
		</form>
		<hr>
	</center>

</body>
</html>