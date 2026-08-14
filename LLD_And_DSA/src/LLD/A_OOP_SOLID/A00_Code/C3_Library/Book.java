package LLD.A_OOP_SOLID.A00_Code.C3_Library;

public class Book {
    private String title;
    private String author;
    private int price;
    private String category;


    public void setBook(String title, String author, int price, String category) {
        this.author = author;
        this.title = title;
        if(price > 0){
            this.price = price;
        }
        this.category = category;
    }
    public int getPrice(){
        return price;
    }
    public String getAuthor(){
        return author;
    }
    public String getTitle(){
        return title;
    }
    public String getCategory(){
        return category;
    }

}
