package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;

@WebServlet("/signinServlet")
public class signinServlet extends javax.servlet.http.HttpServlet{
	protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String account = request.getParameter("name");

        String password = request.getParameter("pwd");


        System.out.println(account+password);

        if(account.equals("")||password.equals("")){

            out.println("<script languagehttp = 'javascript'> window.location='signin.jsp';alert('«Î ‰»Î’À∫≈√‹¬Î') </script>" );
        }

       String className="com.mysql.jdbc.Driver";

       String url="jdbc:mysql://127.0.0.1:3306/lms";

       String user="root";

       String password1="root";
        Connection conn = null;
        try {
            Class.forName(className);
      } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }


        try {
          conn=DriverManager.getConnection(url, user, password1);
       } catch (SQLException e) {
           e.printStackTrace();
      }
        String sql="select password from Test where id = "+account ;
        System.out.println(sql);
        PreparedStatement pstmt= null;
        try {
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs=pstmt.executeQuery();
            if (rs.next()&&rs.getString("password").equals(password)){
                response.sendRedirect("index.jsp");
            }
            else {
                out.println("<script languagehttp = 'javascript'> window.location='signin.jsp';alert('’À∫≈ªÚ√‹¬Î¥ÌŒÛ') </script>" );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }


}
