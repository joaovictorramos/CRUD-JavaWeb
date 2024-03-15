package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentDAO {
    private Connection connectionDatabase(){
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (Exception e){
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/bd_task", "cefetino", "cefetino");
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e){
            e.printStackTrace();
        }

        return conn;
    }

    public boolean saveStudent(Student student) {
        boolean key = false;
        Connection conn = null;
        String create = "INSERT INTO student (name, lastname, registration) VALUES (?, ?, ?)";
        try {
            conn = connectionDatabase();
            PreparedStatement pst = conn.prepareStatement(create);

            pst.setString(1, student.getName());
            pst.setString(2, student.getLastname());
            pst.setString(3, student.getRegistration());
            pst.executeUpdate();
            key = true;

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e){
            e.printStackTrace();

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return key;
    }

    public boolean updateStudant(Student student){
        boolean key = false;
        Connection conn = null;
        String updateName = "UPDATE student SET name = ? WHERE registration = ?";
        String updateLastname = "UPDATE student SET lastname = ? WHERE registration = ?";
        String updateAll = "UPDATE student SET name = ?, lastname = ? WHERE registration = ?";

        try{
            conn = connectionDatabase();
            if (student.getName() != null && student.getLastname() == null){
                PreparedStatement pst = conn.prepareStatement(updateName);

                pst.setString(1, student.getName());
                pst.setString(2, student.getRegistration());
                pst.executeUpdate();
                key = true;

            } else if (student.getName() == null && student.getLastname() != null){
                PreparedStatement pst = conn.prepareStatement(updateLastname);

                pst.setString(1, student.getLastname());
                pst.setString(2, student.getRegistration());
                pst.executeUpdate();
                key = true;

            } else if (student.getName() != null && student.getLastname() != null){
                PreparedStatement pst = conn.prepareStatement(updateAll);

                pst.setString(1, student.getName());
                pst.setString(2, student.getLastname());
                pst.setString(3, student.getRegistration());
                pst.executeUpdate();
                key = true;
            }

        } catch (SQLException e){
            e.printStackTrace();

        } catch (Exception e){
            e.printStackTrace();

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return key;
    }

    public Student findByRegistration(String registration){
        Connection conn = null;
        String search = "SELECT * FROM student WHERE registration = ?"; 

        Student student = null;
        try {
            conn = connectionDatabase();
            PreparedStatement pst = conn.prepareStatement(search);
            pst.setString(1, registration);

            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()){
                student = new Student(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("lastname"),
                    resultSet.getString("registration")
                );
            }
            
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e){
            e.printStackTrace();

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    public List<Student> findAll(){
        List<Student> students = new ArrayList<>();
        Connection conn = null;
        String getAll = "SELECT * FROM student";
        try {
            conn = connectionDatabase();
            PreparedStatement pst = conn.prepareStatement(getAll);
            
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                Student student = new Student(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("lastname"),
                    resultSet.getString("registration")
                );

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e){
            e.printStackTrace();

        } finally{
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return students;
    }

    public boolean deleteStudent(String registration){
        boolean key = false;
        Connection conn = null;
        String delete = "DELETE FROM student WHERE registration = ?";
        try {
            conn = connectionDatabase();
            PreparedStatement pst = conn.prepareStatement(delete);
            pst.setString(1, registration);
            pst.executeUpdate();
            key = true;

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e){
            e.printStackTrace();

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return key;
    }
}
