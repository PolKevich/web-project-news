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

public class DoEditNews implements Command {

	private static final Logger log = LogManager.getRootLogger();

	private final IntNewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			int id = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String briefNews = request.getParameter("briefNews");
			String content = request.getParameter("content");
			String newsData = request.getParameter("newsDate");

			News news = new News(id, title, briefNews, content, newsData);

			newsService.update(news);
			request.getSession(true).removeAttribute("editnews");
			response.sendRedirect("controller?command=go_to_news_list");

		} catch (ServiceException e) {

			log.error(e);
			response.sendRedirect("controller?command=go_to_error_page");
		}

	}

}
