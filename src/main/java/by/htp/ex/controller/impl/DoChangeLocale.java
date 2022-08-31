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
				
		request.getSession(true).setAttribute("local", local);
		
		String url =  (String) request.getSession(true).getAttribute("url");
		
		System.out.println("url = " + url);
		if (url != null) {
			
			response.sendRedirect(url);
		}

		response.sendRedirect("controller?command=go_to_base_page");

	}

}
