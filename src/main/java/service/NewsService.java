package service;


import bean.News;
import dao.DaoException;


import java.io.IOException;

public interface NewsService {

    void addNews(News news) throws IOException, ServiceException;
    void searchNews() throws ServiceException, IOException, DaoException;




}

