
public class Book extends Product {
    protected String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }
    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
