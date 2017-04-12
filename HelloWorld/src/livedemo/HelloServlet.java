package livedemo;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

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
			out.write("<h1>Hello, " + req.getParameter("visitor") + "!</h1>");
			out.write("<p>The time now is " + new Date() + "</p>");
			out.write("</body></html>");
		}
	}
}