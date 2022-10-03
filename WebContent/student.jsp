<%@page import="com.school.portal.pojo.Course"%>
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
	<h1>STUDENT</h1>
	
	<form action="<%=request.getContextPath()%>/addStudent" method="post">
		<h3>Add:</h3>
		Student ID: <input type="text" name="studentID"> <br> <br>
		Student Name: <input type="text" name="studentName"> <br> <br>
		Student Email: <input type="email" name="studentEmail"> <br> <br>
		
		<table>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Add Course"></td>
			</tr>
		</table>
		
	</form>

	<table>
	<%-- 	<%
		if (request.getAttribute("courses") != null) {
			ArrayList<Course> courses = (ArrayList<Course>) request.getAttribute("courses");
			for (Course course : courses) {
		%>
		<tr>
			<td>Course Code: <%=course.getCourseCode() %> / Name: <%= course.getCourseName()%>
			</td>
			<td>Course Teacher: <%=course.getCourseTeacher() %> 
			</td>

		</tr>
		<%
		}
		}
		%> --%>
	</table>
</body>
</html>