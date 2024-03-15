package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDAO;
import model.Student;

@WebServlet(name="RegisterStudent", urlPatterns={"/RegisterStudent"})
public class StudentController extends HttpServlet{
    private StudentDAO studentDAO = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String method = request.getParameter("_method");
        
        if(method.equals("GET ALL")){
            List<Student> students = studentDAO.findAll();
            if (students.isEmpty()){
                
            }else{
                System.out.println(students);
                request.setAttribute("list", students);
            }

        }else{
            String registration = request.getParameter("registrationGet").trim();
            String message = "Matrícula não encontrada!";

            if (registration == null){
                request.setAttribute("messageGet", message);
    
            }else {
                Student student = studentDAO.findByRegistration(registration);
                if(student != null){
                    request.setAttribute("idGet", student.getId().toString());
                    request.setAttribute("nameGet", student.getName());
                    request.setAttribute("lastnameGet", student.getLastname());
                    request.setAttribute("registrationGet", student.getRegistration());
    
                }else{
                    request.setAttribute("messageGet", message);
                }
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String method = request.getParameter("_method");
        String name = null;
        String lastname = null;
        String registration = null;

        if("PUT".equals(method)){
            name = request.getParameter("namePut").trim();
            lastname = request.getParameter("lastnamePut").trim();
            registration = request.getParameter("registrationPut").trim();
            String message = "Erro na atualização!";

            if ((name == null && lastname == null) || registration == null){
                request.setAttribute("messagePut", message);

            }else {
                Student student = new Student(name, lastname, registration);
                boolean key = studentDAO.updateStudant(student);

                if (key){
                    message = "Atualização realizada com sucesso!";
                }
                request.setAttribute("messagePut", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);

        }else if ("DELETE".equals(method)){
            registration = request.getParameter("registrationDelete");
            String message = "Matrícula não encontrada!";

            if(registration == null ){
                request.setAttribute("messageDelete", message);

            }else {
                boolean key = studentDAO.deleteStudent(registration);
                if(key){
                    message = "Estudante deletado com sucesso!";
                }
                request.setAttribute("messageDelete", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);

        }else{
            name = request.getParameter("namePost").trim();
            lastname = request.getParameter("lastnamePost").trim();
            registration = request.getParameter("registrationPost").trim();
            String message = "Erro no cadastro!";

            if (name == null || lastname == null || registration == null){
                request.setAttribute("message", message);
    
            }else{
                Student student = new Student(name, lastname, registration);
                boolean key = studentDAO.saveStudent(student);
        
                if (key) {
                    message = "Cadastro realizado com sucesso!";
                }
                request.setAttribute("messagePost", message);
            }
    
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
