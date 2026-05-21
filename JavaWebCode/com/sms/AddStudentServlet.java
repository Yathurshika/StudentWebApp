package com.sms;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;

public class AddStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String course = request.getParameter("course");

        Student s = new Student(name, age, course);
        StudentDAO dao = new StudentDAO();

        dao.addStudent(s);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("</head><body class='bg-light'>");

        out.println("<div class='container mt-5'>");
        out.println("<div class='card shadow p-4 text-center'>");

        out.println("<h2 class='text-success'>Student Added Successfully!</h2>");

        out.println("<div class='mt-4'>");

        out.println("<a href='viewStudents' class='btn btn-primary me-2'>View Students</a>");
        out.println("<a href='addStudent.html' class='btn btn-success me-2'>Add Another</a>");
        out.println("<a href='index.html' class='btn btn-secondary'>Home</a>");

        out.println("</div>");

        out.println("</div>");
        out.println("</div>");

        out.println("</body></html>");
    }
}  