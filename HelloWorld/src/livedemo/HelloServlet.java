package livedemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try (PrintWriter out = resp.getWriter()) {
			out.write("<html><head><title>Hello, Servlet!</title></head><body>");
			out.write("<h1>Hello, World!</h1>");
			out.write("<h1>Hello, " + req.getParameter("visitor") + "!</h1>");
			out.write("<p>The time now is " + new Date() + "</p>");
			out.write("</body></html>");
		}
	}
}