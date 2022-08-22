package by.htp.ex.controller.impl;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.dao.NewsDAOException;
import by.htp.ex.service.IntNewsService;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoAddNews implements Command {
	
	private static final Logger log = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IntNewsService newsService = ServiceProvider.getInstance().getNewsService();
		
		String title = request.getParameter("title");
		String briefNews = request.getParameter("briefNews");
		String content = request.getParameter("content");
		String newsData = request.getParameter("newsData");
		
		News news = new News(title, briefNews, content, newsData);
			
		System.out.println(title + " " + briefNews + " " + content + " " + newsData);
		
		try {
			
			if(newsService.save(news)) {
				
				request.getSession(true).removeAttribute("news");
				response.sendRedirect("controller?command=go_to_news_list");				
			}

		} catch (NewsDAOException e) {
			log.error(e);
			response.sendRedirect("controller?command=go_to_error_page");
		}
	}

}
