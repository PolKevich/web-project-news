package by.htp.ex.controller.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.controller.Command;

import by.htp.ex.service.IntUserService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoSIgnIn implements Command {
	
	private static final Logger log = LogManager.getRootLogger();
	
	private final IntUserService service = ServiceProvider.getInstance().getUserService();

	private static final String JSP_LOGIN_PARAM = "login";
	private static final String JSP_PASSWORD_PARAM = "password";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login;
		String password;

		login = request.getParameter(JSP_LOGIN_PARAM);
		password = request.getParameter(JSP_PASSWORD_PARAM);
		
		try {
			String role = service.signIn(login, password);
			
			if (!role.equals("guest")) {
				request.getSession(true).setAttribute("user", "active");
				request.getSession(true).setAttribute("role", role); 
				response.sendRedirect("controller?command=go_to_news_list");
			} else {
				//request.getSession(true).setAttribute("user", "notActive");				
				//request.getSession(true).setAttribute("AuthenticationError", "wrong login or password");
				request.setAttribute("AuthenticationError", "wrong login or password");
				request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response); // нужен редирект
				response.sendRedirect("controller?command=go_to_base_page");
			}
			
		} catch (ServiceException e) {
			log.error(e);
			response.sendRedirect("controller?command=go_to_error_page");
		}
		
	}

}
