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

import javafx.scene.control.Alert;

/**
 * Servlet implementation class ChangeServlet
 */
@WebServlet("/ChangeServlet")
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String id = request.getParameter("id");
		String birthday = request.getParameter("year1") + "-" + request.getParameter("month1") + "-"
				+ request.getParameter("day1");
		String start = request.getParameter("year2") + "-" + request.getParameter("month2") + "-"
				+ request.getParameter("day2");
		String end = request.getParameter("year3") + "-" + request.getParameter("month3") + "-"
				+ request.getParameter("day3");
		String house = request.getParameter("danyuan") + request.getParameter("lou") + "-"
				+ request.getParameter("jian");
		String picture1 = request.getParameter("file1");
		String picture2 = request.getParameter("file2");
		String picture3 = request.getParameter("file3");
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
		String sql = "INSERT INTO Entity_1(name,id,id4,id2,lou_number,phone,birthday,ru_zhu_time,jie_zhi_time,picture1,picture2,picture3,zhuang_tai)VALUES ('" + name+ "','"+ id+"',null,null,'"  + house
				+ "','" + phone + "','" + birthday+ "','" + start+ "','" + end+ "','" + picture1+"','" + picture2+"','" + picture3+"','在家" +"')";
		System.out.println(sql);
		String del = "DELETE FROM Entity_1 WHERE name='"+name+"'";
		try {
			st = (Statement) conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			st.executeUpdate(del);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int count = 0;
		try {
			count = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (count > 0)

		{
			out.println("<script languagehttp = 'javascript'> window.location='teams.jsp';alert('删除成功') </script>" );

		}

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
