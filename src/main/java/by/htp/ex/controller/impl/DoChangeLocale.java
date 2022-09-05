package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DoChangeLocale implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession getSession = request.getSession(true);
						
		getSession.setAttribute("local", request.getParameter("local"));
		
		String url = (String) getSession.getAttribute("url");
		
		System.out.println("url = " + url);
		
		
		getSession.setAttribute("url", url);
		
		if (url == null | url.isEmpty() ) {
			
			response.sendRedirect("controller?command=go_to_base_page");
		}

		response.sendRedirect(url);

	}

}
