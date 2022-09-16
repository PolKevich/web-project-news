package by.htp.ex.controller.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.controller.Command;
import by.htp.ex.service.IntUserService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoRegistration implements Command {

	private final IntUserService userService = ServiceProvider.getInstance().getUserService();
	
	private final Map<String, String> invalidRegistrationData = new HashMap();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		NewUserInfo user = new NewUserInfo(firstName, lastName, email, login, password, confirmPassword);

		try {

			if (userService.registration(user)) {

				request.getSession(true).setAttribute("user", "active");
				request.getSession(true).setAttribute("password", null);
				request.getSession(true).setAttribute("confirmPassword", null);

				response.sendRedirect("controller?command=go_to_news_list");

			}

		} catch (ServiceException massage) {


			for (Entry<String, String> entry : massage.getListMassage().entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				invalidRegistrationData.put(key, value);
			}

			
			if (invalidRegistrationData.containsKey("email")) {
				email = invalidRegistrationData.get("email");
				request.getSession(true).setAttribute("email", email);
			}
			else {
				request.getSession(true).removeAttribute("email");
			}

			if (invalidRegistrationData.containsKey("login")) {
				login = invalidRegistrationData.get("login");
				request.getSession(true).setAttribute("login", login);
			}
			else {
				request.getSession(true).removeAttribute("login");
			}

			if (invalidRegistrationData.containsKey("password")) {
				password = invalidRegistrationData.get("password");
				request.getSession(true).setAttribute("password", password);

			}
			else {
				request.getSession(true).removeAttribute("password");
			}

			if (invalidRegistrationData.containsKey("confirmPassword")) {
				confirmPassword = invalidRegistrationData.get("confirmPassword");
				request.getSession(true).setAttribute("confirmPassword", confirmPassword);
			}
			
			else {
				request.getSession(true).removeAttribute("confirmPassword");
			}
			
			invalidRegistrationData.clear();
			response.sendRedirect("controller?command=go_to_registration_page");

		}
	}

}
