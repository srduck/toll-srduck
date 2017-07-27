package srduck.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by igor on 27.07.2017.
 */
public class SimpleServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("Windows-1251");
        response.setContentType("text/html; Windows-1251");

        response.getWriter().print(
                "<html>\n" +
                        "<head>\n" +
                        "    <title>Index File</title>\n" +
                        "</head>\n" +
                        "<body>");
        response.getWriter().print("GET from SimpleServlet\n");
        double random = Math.random();
        if (random > 0.95) {
            response.getWriter().print("<p>����� ���������� ���!\n");
        } else {
            response.getWriter().print("<p>����� ���� ����� ...\n");
        }
        response.getWriter().print("<p>(" + random + ")");
        response.getWriter().print(" <a href=\"" + request.getRequestURI() + "\""  + "><h3>��������� ����� ���!</h3></a>" );
        response.getWriter().print("</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().print("POST from SimpleServlet");
    }
}
