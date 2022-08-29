package by.htp.ex.controller.impl;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.service.IntNewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToNewsList implements Command {

	private static final Logger log = LogManager.getRootLogger();

	private final IntNewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<News> newsList;

		try {
			newsList = newsService.list();
			request.getSession(true).removeAttribute("news");
			request.getSession(true).removeAttribute("editnews");
			request.setAttribute("news", newsList);
			request.setAttribute("presentation", "newsList");

			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);

		} catch (ServiceException e) {
			log.error(e);
			response.sendRedirect("controller?command=go_to_error_page");
		}

	}

}
