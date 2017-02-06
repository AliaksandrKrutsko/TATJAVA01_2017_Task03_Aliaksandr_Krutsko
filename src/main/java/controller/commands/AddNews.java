package controller.commands;
import bean.News;

import controller.Command;
import service.NewsService;
import service.ServiceException;
import service.ServiceFactory;


import java.io.IOException;



public class AddNews implements Command {

    public String execute(String request) throws IOException {

        String name = null;
        String category = null;
        String content = null;
        News news = new News(name, category, content);
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        try {

            newsService.addNews(news);
            response = "your news was added";

        } catch (ServiceException e) {

            response = "something went wrong";
        }

        return response;
    }

}