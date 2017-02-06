package dao;


public final class DaoFactory {

    private static final DaoFactory instance = new DaoFactory();

    private final NewsDao news = new SQLNewsDao();

    public static DaoFactory getInstance(){
        return instance;
    }

    public NewsDao getNewsDao() {
        return news;
    }

}
