package chapter8;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(asyncSupported=true, urlPatterns={"/chapter8/async"})
public class AsyncServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		AsyncContext asyncContext = req.getAsyncContext();
		MyAsyncTask task = new MyAsyncTask(asyncContext);
		asyncContext.start(task);
	}

}
