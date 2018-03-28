package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grw.dao.impl.DaoImpl;

import javabean.Person;
import service.addService;

/**
 * Servlet implementation class addServlet
 */
@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Person person = new Person();
		
		person.setName(request.getParameter("name"));
		person.setPhone(request.getParameter("phone"));
		person.setId(request.getParameter("id"));
		person.setBirthday(request.getParameter("year1") + "-" + request.getParameter("month1") + "-"
				+ request.getParameter("day1"));
		person.setRu_zhu_time(request.getParameter("year2") + "-" + request.getParameter("month2") + "-"
				+ request.getParameter("day2"));
		person.setJie_zhi_time(request.getParameter("year3") + "-" + request.getParameter("month3") + "-"
				+ request.getParameter("day3"));
		person.setLou_number(request.getParameter("danyuan") + request.getParameter("lou") + "-"
				+ request.getParameter("jian"));
		person.setPicture1(request.getParameter("file1"));
		person.setPicture2(request.getParameter("file2"));
		person.setPicture3(request.getParameter("file3"));
		
		addService addService = new addService();
		addService.add(person);
		response.sendRedirect("about.jsp");
	}

}
