<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회해봅시다</title>
</head>
<body>
	<table>
		<tr align="center">
			<td><br> <br> <br>
				<form action="./listresult.manager" method="post">
					조회 할 회사명:&nbsp;<input type="text" name="c_id" value = "${SessionScope.logininfo.c_id }"> <input
						type="submit" value="조회">
				</form></td>
		</tr>
	</table>
</body>
</html>