package by.htp.ex.controller.impl;

import java.io.IOException;

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

public class GoToEditNews implements Command {

	private static final Logger log = LogManager.getRootLogger();

	private final IntNewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");

		try {
			News news = newsService.findById(Integer.parseInt(id));

			int idNews = news.getIdNews();
			request.getSession(true).setAttribute("idNews", idNews);

			String title = news.getTitle();
			request.getSession(true).setAttribute("title", title);

			String briefNews = news.getBriefNews();
			request.getSession(true).setAttribute("briefNews", briefNews);

			String content = news.getContent();
			request.getSession(true).setAttribute("content", content);

			String newsDate = news.getNewsDate();
			request.getSession(true).setAttribute("newsDate", newsDate);

			request.getSession(true).setAttribute("editnews", "active");
			request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);

		} catch (ServiceException e) {

			log.error(e);
			response.sendRedirect("controller?command=go_to_error_page");
		}

	}

}
