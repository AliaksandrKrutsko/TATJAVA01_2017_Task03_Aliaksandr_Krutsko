package dao;


import bean.News;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface NewsDao {


    void addNews(News news) throws DaoException, IOException;

    void searchNews() throws DaoException, IOException;


}
