package chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter4"})
public class Chapter4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		response.getWriter().append("<h2>Servlet Context</h2> ");
		response.getWriter().append("Servlet Context Name: ").append(getServletContext().getServletContextName()+"\n");
		response.getWriter().append("Real Path: ").append(getServletContext().getRealPath("/chapter4")+"\n");
		response.getWriter().append("getResourceAsStream('/index.jsp');\n");
		
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getServletContext().getResourceAsStream("/index.jsp")))) {	
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line);
			}
		}
		
		response.getWriter().append(stringBuilder.toString());
	}

}
