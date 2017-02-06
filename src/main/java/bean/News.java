package bean;



public class News {

    String category;
    String name;
    String content;



    public News(String name, String category, String content) {

        this.category = category;
        this.name = name;
        this.content = content;

    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {

    }

    public void setCategory(String category) {

    }

    public void setContent(String content) {

    }

    public String getContent() {
        return content;
    }



}
