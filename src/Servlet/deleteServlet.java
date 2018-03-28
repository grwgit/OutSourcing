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

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("username");
		String className = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/lms";

		String user = "root";

		String password1 = "root";
		Connection conn = null;
		Statement st = null;
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(url, user, password1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String del = "DELETE FROM Entity_1 WHERE name='"+name+"'";
		System.out.println(del);
		try {
			st = (Statement) conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int count = 0;
		try {
			count = st.executeUpdate(del);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (count > 0)

		{

			out.println("<script languagehttp = 'javascript'> window.location='teams.jsp';alert('É¾³ý³É¹¦') </script>");

		}

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
