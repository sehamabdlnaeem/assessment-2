package com.school.portal.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.school.portal.pojo.Batch;
import com.school.portal.pojo.Course;
import com.school.portal.pojo.Student;
import com.school.portal.pojo.Teacher;
import com.school.portal.utils.HibernateConfigurations;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("************************START-doPost()**************************************");
		Transaction tx = null;
		try {
			String path = request.getServletPath();
			System.out.println(path);

			SessionFactory sf = HibernateConfigurations.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

			RequestDispatcher rd_batch = request.getRequestDispatcher("/getBatches");
			RequestDispatcher rd_teacher = request.getRequestDispatcher("/getTeachers");
			RequestDispatcher rd_course = request.getRequestDispatcher("/getCourses");

//			ArrayList<Course> courses = getCourses(session, request);

			switch (path) {
			case "/addBatch":
				rd_batch.forward(request, response);
				addBatch(session, request, response);
				break;
			case "/addTeacher":
				rd_teacher.forward(request, response);
				addTeacher(session, request, response);
				break;
			case "/addCourse":
//				request.setAttribute("courses", courses);
				rd_course.forward(request, response);
				addCourse(session, request, response);
				break;
			case "/addStudent":
				addStudent(session, request, response);
			case "/getBatches":
				getBatches(session, request, response);
				break;
			case "/getTeachers":
				getTeachers(session, request, response);
				break;
			case "/getCourses":
				getCourses(session, request, response);
				break;
			case "/getStudent":
				getStudents(session, request, response);
			break;
			default:
				System.out.println("default case");

			}

			tx.commit();
			session.close();

		} catch (Exception e) {

			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		System.out.println("************************END-doPost()**************************************");
	}
	
	private List<Student> getStudents(Session session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
//		SQLQuery query = session.createSQLQuery("select * from Student");
		
		List<Student> coursesList = session.createQuery("from Student").list();
		
		
		PrintWriter out = response.getWriter();
		out.append("<html><body>");		
		
		out.println("<h1> Student List :");
		out.println("<table style='border: 1px solid black; margin-top: 10px;'>");
		out.println(" <tr style='border: 1px solid black'>\n"
				+ "    <th style='border: 1px solid black' >Student ID</th>\n"
				+ "    <th style='border: 1px solid black' >Student Name</th>\n"
				+ "    <th style='border: 1px solid black'>Student Email</th>\n"
				+ "  </tr>");

		for(Student course : coursesList) {
			out.println("<tr>");
			out.println("<td>"+course.getsID()+"</td>");
			out.println("<td>"+course.getsName()+"</td>");
			out.println("<td>"+course.getsEmail()+"</td>");
	
			out.println("</tr>");
		}
		out.println("</table>");
		out.append("</body></html>");
		return null;
	
		
	}

	private void addStudent(Session session, HttpServletRequest request, HttpServletResponse response) {

		Student student = new Student();
		String studentID = request.getParameter("studentID");
		String studentName = request.getParameter("studentName");
		String studentEmail = request.getParameter("studentEmail");
		
		student.setsID(Integer.parseInt(studentEmail));
		student.setsName(studentName);
		student.setsEmail(studentEmail);		
		session.save(student);
		
	}

	private void addCourse(Session session, HttpServletRequest request, HttpServletResponse response) {

		Course course = new Course();
		String courseCode = request.getParameter("courseCode");
		String courseName = request.getParameter("courseName");	
		
		course.setCourseCode(courseCode);
		course.setCourseName(courseName);
		session.save(course);

	}

	private void getCourses(Session session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		out.append("<html><body>");
		
		List<Course> coursesList = session.createQuery("from Course").list();
		
		out.println("<h1> Courses List :");
		out.println("<table style='border: 1px solid black; margin-top: 10px;'>");
		out.println(" <tr style='border: 1px solid black'>\n"
				+ "    <th style='border: 1px solid black' >Course Code</th>\n"
				+ "    <th style='border: 1px solid black' >Course Name</th>\n"
				+ "    <th style='border: 1px solid black'>Course Teacher ID</th>\n"
				+ "    <th style='border: 1px solid black'>Course Teacher Name</th>\n"
				+ "  </tr>");

		for(Course course : coursesList) {
			out.println("<tr>");
			out.println("<td>"+course.getCourseCode()+"</td>");
			out.println("<td>"+course.getCourseName()+"</td>");
			out.println("<td>"+course.getCourseTeacher().getTeacherID()+"</td>");
			out.println("<td>"+course.getCourseTeacher().gettName()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.append("</body></html>");

	}

	private void addTeacher(Session session, HttpServletRequest request, HttpServletResponse response) {

		Teacher teacher = new Teacher((String) request.getParameter("teacherName"));
		session.save(teacher);

	}

	private void getTeachers(Session session, HttpServletRequest request, HttpServletResponse response) throws IOException {

		
		SQLQuery query = session.createSQLQuery("select * from Teacher");

		PrintWriter out = response.getWriter();
		
		out.append("<html><body>");
		out.append("<h1>List of Teachers</h1>");
		out.println("<table>");
		List<Object[]> rows = query.list();

		for (Object[] row : rows) {
			Teacher teacher = new Teacher(row[1].toString());
			
			String ID = row[0].toString();
			teacher.setTeacherID(Integer.parseInt(ID));
			System.out.println(row[0]);
			out.println("<tr>");
			out.println("<td> ID: "+teacher.getTeacherID()+"</td>");
			out.println("<td> Teacher Name: "+teacher.gettName()+"</td>");
			out.println("</tr>");
			
		}
	}

	private void getBatches(Session session, HttpServletRequest request, HttpServletResponse response ) throws IOException {

		SQLQuery query = session.createSQLQuery("select * from Batch");
		
		PrintWriter out = response.getWriter();
		out.append("<html><body>");
		out.append("<h1>List of Batches</h1>");
		out.println("<table>");
		
		

		out.println("<table style='border: 1px solid black; margin-top: 10px;'>");
		out.println(" <tr style='border: 1px solid black'>\n"
				+ "    <th style='border: 1px solid black' >ID</th>\n"
				+ "    <th style='border: 1px solid black' >Batch Number</th>\n"
				+ "  </tr>");
	
		out.println("<tr>");
		List<Object[]> rows = query.list();
		for (Object[] row : rows) {
			Batch batch = new Batch();
			String ID = row[0].toString();
			batch.setBatchID(Integer.parseInt(ID));
			batch.setBatchNumber(row[1].toString());
			
			out.println("<tr>");
			out.println("<td> "+batch.getBatchID()+"</td>");
			out.println("<td> "+batch.getBatchNumber()+"</td>");
			
			out.println("</tr>");
			
		}
	}

	private void addBatch(Session session, HttpServletRequest request, HttpServletResponse response) {

		System.out.println("************************ADD BATCH**************************************");

		Batch b1 = new Batch((String) request.getParameter("batchName"));

		session.save(b1);

	}

}
