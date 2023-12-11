package com.example.thimd3.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class StudentDAO implements IStudentDAO{

    String url = "jdbc:mysql://localhost:3306/student?studentSSL=false";
    String username = "root";
    String password = "Trung123@";

    private static final String INSERT_STUDENT_SQL = "INSERT INTO student(name,email,localDate,address,phone,id_class) VALUES (?,?,?,?,?,(select id from classroom where name = ?))";
    private static final String SELECT_STUDENT_BY_ID = "SELECT student.id,student.name, student.email,student.localDate, student.address, student.phone,student.name,classroom.name from student join classroom on student.id_class = classroom.id WHERE id = ?";
    private static final String SELECT_STUDENT_ALL = "select student.id,student.name, student.email,student.localDate, student.address, student.phone,student.name,classroom.name from student join classroom on student.id_class = classroom.id";
    private static final String DELETE_STUDENT_SQL = "DELETE FROM student WHERE id = ?";
    private static final String UPDATE_STUDENT_SQL = "UPDATE student SET name = ?, email = ?,localDate = ?, address = ?,phone = ?,id_class = (select id from classroom where name = ?) WHERE id = ?";


    protected Connection getConnect(){

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnect();
             PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT_ALL);
        ) {
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString("student.name");
                String email = rs.getString("student.email");
                String localDate = rs.getString("student.localDate");
                String address = rs.getString("student.address");
                int phone = rs.getInt("student.phone");
                String classroom = rs.getString("classroom.name");

                students.add(new Student(id,name,email,localDate, address,phone,classroom));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    @Override
    public boolean updateStudent(Student student) {
        boolean rowUpdated;
        try (Connection connection = getConnect();
             PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT_SQL);) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getLocalDate());
            statement.setString(4, student.getAddress());
            statement.setInt(5, student.getPhoneNumber());
            statement.setString(6, student.getClassroom());
            statement.setInt(7,student.getId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted;
            try (Connection connection = getConnect();
                 PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_SQL);
            ){
                statement.setInt(1,id);
                rowDeleted = statement.executeUpdate() > 0;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return rowDeleted;

    }

    @Override
    public Student selectStudent(int id) {
            Student student = null;
            try (Connection connection = getConnect();
                 PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT_BY_ID);
            ) {
                statement.setInt(1,id);
                System.out.println(statement);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("student.name");
                    String email = rs.getString("student.email");
                    String localDate = rs.getString("student.localDate");
                    String address = rs.getString("student.address");
                    int phone = rs.getInt("student.phone");
                    String classroom = rs.getString("classroom.name");
                    student = new Student(id,name,email,localDate, address, phone, classroom);

                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return student;
    }

    @Override
    public void insert(Student student) {
            System.out.println(INSERT_STUDENT_SQL);
            try (Connection connection = getConnect();
                 PreparedStatement statement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
                statement.setString(1, student.getName());
                statement.setString(2, student.getEmail());
                statement.setString(3, student.getLocalDate());
                statement.setString(4, student.getAddress());
                statement.setInt(5, student.getPhoneNumber());
                statement.setString(6, student.getClassroom());
                statement.executeUpdate();
                System.out.println("da them thanh cong");
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
    }
}
