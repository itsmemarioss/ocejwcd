package chapter7;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter {

	public static final String PARAM = "my_param";
	private String paramValue;
	
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
				System.out.println("Param Value: "+paramValue);
				((HttpServletRequest)req).setAttribute("my_param", paramValue);
				chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		paramValue = config.getInitParameter(PARAM);
	}

}
