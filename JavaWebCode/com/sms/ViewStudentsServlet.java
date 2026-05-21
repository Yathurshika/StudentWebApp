package com.sms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.*;

public class ViewStudentsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head>");

        out.println("<title>View Students</title>");

        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

        out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css'>");

        // ===== CSS STYLE =====
        out.println("<style>");
        out.println("body { background: linear-gradient(135deg, #74ebd5, #ACB6E5); min-height: 100vh; }");

        out.println(".card { border: none; border-radius: 20px; box-shadow: 0 10px 25px rgba(0,0,0,0.2); }");

        out.println(".header { text-align: center; color: white; margin-top: 20px; margin-bottom: 20px; }");

        out.println(".header i { font-size: 45px; }");

        out.println("table { background: white; border-radius: 10px; overflow: hidden; }");

        out.println(".btn { border-radius: 8px; }");

        out.println("</style>");

        out.println("</head><body>");

        // ===== HEADER =====
        out.println("<div class='container mt-4'>");

        out.println("<div class='header'>");
        out.println("<i class='fa fa-users'></i>");
        out.println("<h2>Student List</h2>");
        out.println("<p>Manage all registered students</p>");
        out.println("</div>");

        // ===== CARD START =====
        out.println("<div class='card p-4'>");

        // ===== TABLE =====
        out.println("<table class='table table-hover table-striped text-center'>");

        out.println("<thead class='table-dark'>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Age</th>");
        out.println("<th>Course</th>");
        out.println("<th>Actions</th>");
        out.println("</tr>");
        out.println("</thead>");

        out.println("<tbody>");

        try {

            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");

            while (rs.next()) {

                int id = rs.getInt("id");

                out.println("<tr>");

                out.println("<td>" + id + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getInt("age") + "</td>");
                out.println("<td>" + rs.getString("course") + "</td>");

                // ===== ACTION BUTTONS =====
                out.println("<td>");

                out.println("<a class='btn btn-warning btn-sm me-2' href='editStudentForm?id=" + id + "'>");
                out.println("<i class='fa fa-edit'></i> Edit</a>");

                out.println("<a class='btn btn-danger btn-sm' href='deleteStudent?id=" + id + "' ");
                out.println("onclick=\"return confirm('Are you sure you want to delete this student?')\">");
                out.println("<i class='fa fa-trash'></i> Delete</a>");

                out.println("</td>");

                out.println("</tr>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println("</tbody>");
        out.println("</table>");

        // ===== BACK BUTTON =====
        out.println("<a href='index.html' class='btn btn-secondary mt-3'>");
        out.println("<i class='fa fa-home'></i> Back Home</a>");

        // ===== CLOSE CARD =====
        out.println("</div>");

        out.println("</div>");

        out.println("</body></html>");
    }
}