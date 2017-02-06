package controller.commands;


import controller.Command;
import dao.DaoException;
import service.NewsService;
import service.ServiceException;
import service.ServiceFactory;

import java.io.IOException;

public class SearchNews implements Command {


    @Override
    public String execute(String request) throws IOException {

        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        try {

            newsService.searchNews();
            response = "news found";

        } catch (ServiceException e) {

            response = "something went wrong";
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return response;
    }

}
