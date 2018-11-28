package chapter5;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter5/rd/*"})
public class UsingRequestDispatcher extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext contex = getServletContext();
		RequestDispatcher dispatcher = contex.getRequestDispatcher("/chapter4");
		
		String pathInfo = req.getPathInfo();
		switch(pathInfo){
		case "/include":
			resp.getWriter().append("Including /chapter4 \n\n");
			dispatcher.include(req, resp);		
			break;
		case "/forward":
			resp.getWriter().append("Forwarding to /chapter4 \n\n");
			dispatcher.forward(req, resp);		
			break;
		}
	}
}
