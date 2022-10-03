<%@page import="com.school.portal.pojo.Batch"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ADD a Batch</h1>

	<form action="<%=request.getContextPath()%>/addBatch" method="post">
		Add Batch <input type="text" name="batchName"> <br> <br>
		<table>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Add Batch"></td>
			</tr>
		</table>
		
	</form>

</body>
</html>