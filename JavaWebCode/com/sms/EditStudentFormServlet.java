package com.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.*;

public class EditStudentFormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM student WHERE id=?"
            );

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                out.println("<h2>Edit Student</h2>");
                out.println("<form method='post' action='updateStudent'>");

                out.println("<input type='hidden' name='id' value='" + id + "'/>");

                out.println("Name: <input name='name' value='" + rs.getString("name") + "'/><br><br>");
                out.println("Age: <input name='age' value='" + rs.getInt("age") + "'/><br><br>");
                out.println("Course: <input name='course' value='" + rs.getString("course") + "'/><br><br>");

                out.println("<input type='submit' value='Update'/>");

                out.println("</form>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}