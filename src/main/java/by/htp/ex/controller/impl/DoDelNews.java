package by.htp.ex.controller.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.controller.Command;
import by.htp.ex.service.IntNewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoDelNews implements Command {

	private static final Logger log = LogManager.getRootLogger();

	private final IntNewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String[] idNewses = request.getParameterValues("id");
			
			if (idNewses == null) {
				
				response.sendRedirect("controller?command=go_to_news_list");
				
				return;
							
			}

			newsService.delete(idNewses);

			response.sendRedirect("controller?command=go_to_news_list");

		} catch (ServiceException e) {

			log.error(e);
			response.sendRedirect("controller?command=go_to_error_page");
		}

	}

}
