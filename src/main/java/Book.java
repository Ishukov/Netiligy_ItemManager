public class Book extends Product {
    protected String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (getAuthor().contains(search)) {
            return true;
        }
        return false;
    }

    public String getAuthor() {
        return author;
    }
}
