package com.prowings.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prowings.dao.StudentDao;
import com.prowings.entity.Student;

public class StudentServlet extends HttpServlet{

	StudentDao stdDao = new StudentDao();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("inside student servlet - post method!!");
	
		Student std = new Student();
		std.setFirstName(req.getParameter("fname"));
		std.setLastName(req.getParameter("lname"));
		std.setCourse(req.getParameter("course"));
		std.setAddress(req.getParameter("address"));
		
		Student savedStudent = stdDao.saveStudent(std);
		
//		req.getSession().setAttribute("message","Student Saved successfully!!!");
//		req.getRequestDispatcher("index.jsp").forward(req, resp);

		resp.sendRedirect( "index.jsp?name=Saved to DB!!!" );
		
        
//        PrintWriter pw=resp.getWriter();//get the stream to write the data  
//		//writing html in the stream  
//		pw.println("<html><body>");  
//		pw.println("Student saved successfully!!!");  
//		pw.println("</body></html>");  
	}

	
	
}
