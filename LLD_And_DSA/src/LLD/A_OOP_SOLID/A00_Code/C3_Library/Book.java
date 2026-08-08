package LLD.A_OOP_SOLID.A00_Code.C3_Library;

public class Book {
    String title;
    String author;
    int price;
    String category;

    Book() {
        this("Unknown", "Unknown", 0, "Unknown");
    }

    Book(String title, String author, int price, String category) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.category = category;
    }
}
