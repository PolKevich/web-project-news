package by.htp.ex.controller.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String encoding;
	private ServletContext context;

	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);

		context.log("UTF-8 was set.");

		chain.doFilter(request, response);

	}

	public void init(FilterConfig fConfig) throws ServletException {

		encoding = fConfig.getInitParameter("characterEncoding");
		context = fConfig.getServletContext();

	}

}
