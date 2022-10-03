<%@page import="com.school.portal.pojo.Teacher"%>
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
	<h1>List of Teachers</h1>
	
	<form action="<%=request.getContextPath()%>/addTeacher" method="post">
		Add Teacher <input type="text" name="teacherName"> <br> <br>
		<table>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Add Teacher"></td>
			</tr>
		</table>
		
	</form>

<%-- 	<table>
		<%
		if (request.getAttribute("teachers") != null) {
			ArrayList<Teacher> teachers = (ArrayList<Teacher>) request.getAttribute("teachers");
			for (Teacher teacher : teachers) {
		%>
		<tr>
			<td>ID: <%=teacher.getTeacherID()%> / Name: <%=teacher.gettName()%>
			</td>

		</tr>
		<%
		}
		}
		%>
	</table> --%>
</body>
</html>