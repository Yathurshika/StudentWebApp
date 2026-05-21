package com.sms;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {

    public void addStudent(Student s) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO student(name, age, course) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getCourse());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
} 