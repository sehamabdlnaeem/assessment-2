<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<h1>School Portal</h1>

	<a href="<%=request.getContextPath()%>/batch.jsp"><input
		type="button" value="Add Batch" name="batch"></a>

	<a href="<%=request.getContextPath()%>/teacher.jsp"><input
		type="button" value="Add Teacher" name="teacher"></a>

	<a href="<%=request.getContextPath()%>/course.jsp"><input
		type="button" value="Add Course" name="course"></a>
	
	<a href="<%=request.getContextPath()%>/student.jsp"><input
		type="button" value="Add Student" name="student"></a>
		
		
		<br/>
		
		<form action="<%=request.getContextPath()%>/getBatches" method="post">
		<table>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Get Batch"></td>
			</tr>
		</table>
		
	</form>
	
		<form action="<%=request.getContextPath()%>/getTeachers" method="post">
		<table>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Get Teachers"></td>
			</tr>
		</table>
		
	</form>


		<form action="<%=request.getContextPath()%>/getCourses" method="post">
		<table>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Get Courses"></td>
			</tr>
		</table>
		
	</form>
	
		<form action="<%=request.getContextPath()%>/getStudent" method="post">
		<table>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Get Students "></td>
			</tr>
		</table>
		
	</form>
	<script>
		
	</script>
</body>
</html>