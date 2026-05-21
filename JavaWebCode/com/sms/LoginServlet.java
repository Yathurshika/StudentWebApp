package com.sms;

import java.io.IOException;

import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // SIMPLE HARD-CODED LOGIN
        if(username.equals("admin") &&
           password.equals("1234")) {

            response.sendRedirect("index.html");

        } else {

            response.getWriter().println(
                "<h2>Invalid Username or Password!</h2>"
            );
        }
    }
}  