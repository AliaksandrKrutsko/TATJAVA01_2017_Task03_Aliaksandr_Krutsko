package service;

import bean.News;
import dao.DaoException;
import dao.DaoFactory;
import dao.NewsDao;

import java.io.IOException;
import java.util.Scanner;


public class NewsServiceImpl implements NewsService {

    public void addNews(News news) throws IOException, ServiceException {

        String name = news.getName();
        String category = news.getCategory();
        String content = news.getContent();
        if (name == null || category == null || content == null) {
            throw new ServiceException("no news");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String a = scanner.nextLine();
        System.out.println("Enter category: ");
        String b = scanner.nextLine();
        System.out.println("Enter content: ");
        String c = scanner.nextLine();
        news = new News(a, b, c);

        try {
            DaoFactory daoObjectFactory = DaoFactory.getInstance();
            NewsDao newsDao = daoObjectFactory.getNewsDao();
            newsDao.addNews(news);
        }
        catch (DaoException e){
            throw new ServiceException(e);
        }


    }

    @Override
    public void searchNews() throws ServiceException, IOException {


        try {

            DaoFactory daoObjectFactory = DaoFactory.getInstance();
            NewsDao newsDao = daoObjectFactory.getNewsDao();
            newsDao.searchNews();
        }
        catch (DaoException e) {
            throw new ServiceException(e);
        }

    }
}