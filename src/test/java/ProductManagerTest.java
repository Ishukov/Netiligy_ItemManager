import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(11, "someBook", 100, "author1");
    Product book2 = new Book(12, "book2", 300, "author2");
    Product book3 = new Book(13, "someBook", 200, "author3");
    Product smartphone1 = new Smartphone(21, "smartphone1", 5000, "brand1");
    Product smartphone2 = new Smartphone(22, "smartphone2", 2000, "brand2");

    @Test
    public void shouldSearchBook() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("book2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphone() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);

        Product[] expected = {smartphone2};
        Product[] actual = manager.searchBy("smartphone2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSomeProduct() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);

        Product[] expected = {book1, book3};
        Product[] actual = manager.searchBy("someBook");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookByAuthor() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);

        Product[] expected = {book3};
        Product[] actual = manager.searchBy("author3");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByBrand() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);

        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("brand1");

        Assertions.assertArrayEquals(expected, actual);
    }
}