package by.htp.ex.controller.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.controller.Command;
import by.htp.ex.service.IntUserService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoRegistration implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IntUserService userService = ServiceProvider.getInstance().getUserService();
		
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm_password");
		String invalidRegistration = "invalidRegistration";
		
		
		
		
		NewUserInfo user = new NewUserInfo(firstName, lastName, gender, email, login, 
				password, confirmPassword);

		try {
			String role = userService.signIn(login, password);
			
			if (!userService.registration(user)) {
				
				request.setAttribute("invalidRegistration", invalidRegistration);
				
			}
			request.getSession(true).setAttribute("user", "active");
			//request.setAttribute("registration_status", true);
			request.getSession(true).setAttribute("role", role);
			response.sendRedirect("controller?command=go_to_news_list");
			//request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		} catch (ServiceException e) {
			
		}
	}

}
