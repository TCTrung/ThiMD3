package com.example.thimd3;

import com.example.thimd3.model.Student;
import com.example.thimd3.model.StudentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "studentServlet",urlPatterns = "/home")
public class StudentServlet extends HttpServlet {
    private StudentDAO studentDAO;
    @Override
    public void init() throws ServletException {
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "delete":
                try {
                    deleteUser(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "update":
                try {
                    showEdit(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "create" :
                try {
                    showFormAdd(req,resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                listStudent(req,resp);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "update":
                try {
                    updateStudent(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "create" :
                insertStudent(req,resp);
                break;
            default:
                break;
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String localDate = request.getParameter("localDate");
        String address = request.getParameter("address");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String classroom = request.getParameter("classroom");

        Student studentNew = new Student(name,email,localDate, address, phone, classroom);

        studentDAO.insert(studentNew);
        request.setAttribute("message","Da them thanh cong !");
        RequestDispatcher view = request.getRequestDispatcher("/create.jsp");
        view.forward(request,response);
    }

    private void showFormAdd(HttpServletRequest req, HttpServletResponse resp) throws Exception,ServletException {

        RequestDispatcher view = req.getRequestDispatcher("/create.jsp");
        view.forward(req,resp);
    }

    private void listStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> listStudents = this.studentDAO.selectAllStudents();
        req.setAttribute("listStudents", listStudents);
        RequestDispatcher view = req.getRequestDispatcher("/home.jsp");
        view.forward(req, resp);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException,IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.delete(id);
        List<Student> listStudents = studentDAO.selectAllStudents();
        request.setAttribute("listStudents",listStudents);
        RequestDispatcher view = request.getRequestDispatcher("/home.jsp");
        view.forward(request,response);

    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException,IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentDAO.selectStudent(id);
        RequestDispatcher view = request.getRequestDispatcher("/update.jsp");
        request.setAttribute("student",student);
        view.forward(request,response);
    }

    private void updateStudent(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException,ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String localDate = request.getParameter("localDate");
        String address = request.getParameter("address");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String classroom = request.getParameter("classroom");

        Student studentNew = new Student(id,name,email,localDate,address,phone,classroom);
        studentDAO.updateStudent(studentNew);
        request.setAttribute("message","Da sua thanh cong !");
        RequestDispatcher view = request.getRequestDispatcher("/update.jsp");
        view.forward(request,response);
    }
}
