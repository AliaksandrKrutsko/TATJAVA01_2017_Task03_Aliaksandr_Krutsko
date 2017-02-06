import bean.News;
import dao.DaoException;
import dao.DaoFactory;
import dao.NewsDao;
import dao.SQLNewsDao;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class DaoTest {

    @Test

    public void testAddNewsNotNull() throws IOException, DaoException {

        File temp = File.createTempFile("temp", ".tmp");

        System.out.println("Temp file : " + temp.getAbsolutePath());

        String a = new String("new name");
        String b = new String("new category");
        String c = new String("new content");

        News news = new News(a, b, c);
        SQLNewsDao dao = new SQLNewsDao();
        dao.addNews(news);

        Scanner scanner = new Scanner(temp);

        int i = 0;
        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            i++;
            if (("a" + ":" + "b" + ":" + "c").equals(line)) {
                assertTrue(("a" + ":" + "b" + ":" + "c").equals(line));
                break;

            }

        }


    }

    @Test(expected = DaoException.class)
    public void testAddNullNews() throws IOException, DaoException {
        
        String a = null;
        String b = null;
        String c = null;
        News news = new News(a, b, c);
        SQLNewsDao dao = new SQLNewsDao();
        dao.addNews(news);


    }


    @Test
    public void testFindByName() throws IOException, DaoException {

        String name = "pirates";
        System.setIn(new ByteArrayInputStream(name.getBytes()));


        SQLNewsDao dao = new SQLNewsDao();
        dao.searchNews();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());

            String input = System.console().readLine();

            assertTrue(input.contains(name));
        }


    }

    @Test
    public void testFindByCategory() throws IOException, DaoException {

        String category = "movie";
        System.setIn(new ByteArrayInputStream(category.getBytes()));

        SQLNewsDao dao = new SQLNewsDao();
        dao.searchNews();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());

            String input = System.console().readLine();

            assertTrue(input.contains(category));
        }


    }


    @Test
    public void testShouldNotFind() throws IOException, DaoException {

        String search = "some random junk";
        System.setIn(new ByteArrayInputStream(search.getBytes()));
        SQLNewsDao dao = new SQLNewsDao();

        dao.searchNews();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());

            String input = System.console().readLine();

            assertFalse(input.contains(search));
        }

    }


}



