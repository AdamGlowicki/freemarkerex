package web;

import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.Student;
import repository.StudentRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/student")
public class StudentServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;

    @Inject
    StudentRepository studentRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idStr = req.getParameter("id");

        Integer id = Integer.valueOf(idStr);
        Student byID = studentRepository.getByID(id);

        Map<String, Object> model = new HashMap<>();
        model.put("student", byID);

        Template template = templateProvider
                .getTemplate(getServletContext(), "student");

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
