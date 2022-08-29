package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoChangeLocale implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String local = request.getParameter("local");
		// String changeLink = request.getParameter("url");
		String changeLink = "go_to_base_page";

		if (local != null) {
			request.getSession(true).setAttribute("local", local);
		}

		response.sendRedirect("controller?command=" + changeLink);

	}

}
