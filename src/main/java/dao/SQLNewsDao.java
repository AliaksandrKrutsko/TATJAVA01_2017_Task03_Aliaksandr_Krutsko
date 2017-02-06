package dao;

import bean.News;

import java.io.*;
import java.util.Scanner;

public class SQLNewsDao implements NewsDao {


    String filename = "newsBase.txt";
    String workingDirectory = System.getProperty("user.dir");
    String FilePath = workingDirectory + File.separator + filename;
    File file = new File(FilePath);


    public void addNews(News news) throws DaoException, IOException {

        String a = news.getName();
        String b = news.getCategory();
        String c = news.getContent();

        if (a == null || b == null || c == null) {
            throw new DaoException("no news");
        }

        FileWriter writer = new FileWriter(file, true);
        writer.write("\n" + a + ":" + b + ":" + c);
        writer.flush();
        writer.close();

    }


    @Override
    public void searchNews() throws DaoException, IOException {


        Scanner in = new Scanner(System.in);
        System.out.println("Please enter: ");
        String search = in.nextLine();
        if (search == null) {
            throw new DaoException("somehow you've got null");
        }

        String line;
        BufferedReader reader = new BufferedReader(new FileReader(file));


        while ((line = reader.readLine()) != null) {
            String[] part = line.split(":", 3);
            String name = new String(part[0]);
            String category = new String(part[1]);
            String content = new String(part[2]);
            News news = new News(name, category, content);

            if (news.getName().contains(search) || news.getCategory().contains(search)) {
                System.out.println("Name: " + name + " " + "Category: " + category + "\n" + content);
            }

        }


    }

}




