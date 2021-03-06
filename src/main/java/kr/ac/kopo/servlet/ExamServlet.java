package kr.ac.kopo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "examServlet", value = "/exam-servlet")
// @WebServlet("/exam")
public class ExamServlet extends HttpServlet {

    /*
     * http://localhost:9999/Lecture-Web/exam?name=hong&&hobby=music 입력시 웹 브라우저에 이름 :
     * http://localhost:9999/Lecture-Web/exam?name=hong&&hobby=music
     * hong 취미 : reading music movie 이렇게 출력되도록 간단하게 만들어봐라.\
     *
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String name = request.getParameter("name");
        String[] hobby = request.getParameterValues("hobby");

        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>서블릿 연습</title></head>");
        out.println(" <body>");
        out.println("이름 : " + name + "<br>");
        out.println("취미 : ");
        for (String s : hobby) {
            out.print(s + "&nbsp; &nbsp;");
        }
        out.println(" </body>");
        out.println("</html>");
    }
}
