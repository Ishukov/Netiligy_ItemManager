import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    Product book1 = new Book(11, "book1", 300, "author1");
    Product book2 = new Book(12, "book2", 100, "author2");
    Product book3 = new Book(13, "book3", 200, "author3");
    Product smartphone1 = new Smartphone(21, "smartphone1", 2000, "brand1");
    Product smartphone2 = new Smartphone(22, "smartphone2", 5000, "brand2");
    Product smartphone3 = new Smartphone(12, "smartphone3", 4000, "brand3");


    @Test
    public void shouldEmptyRepository() {
        ProductRepository repository = new ProductRepository();

        Product[] expected = new Product[0];
        Product[] actual = repository.allProduct();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddProduct() {
        ProductRepository repository = new ProductRepository();
        repository.addProduct(book2);
        repository.addProduct(smartphone3);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repository.allProduct();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddProductWithRepairingId() {
        ProductRepository repository = new ProductRepository();
        repository.addProduct(book1);
        repository.addProduct(book2);
        repository.addProduct(book3);
        repository.addProduct(smartphone1);
        repository.addProduct(smartphone2);


        Assertions.assertThrows(AlreadyExistsException.class, () -> repository.addProduct(smartphone3));
    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repository = new ProductRepository();
        repository.addProduct(book1);
        repository.addProduct(book2);
        repository.addProduct(book3);
        repository.addProduct(smartphone1);
        repository.addProduct(smartphone2);
        repository.removeById(13);

        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Product[] actual = repository.allProduct();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByNonexistentId() {
        ProductRepository repository = new ProductRepository();
        repository.addProduct(book1);
        repository.addProduct(book2);
        repository.addProduct(book3);
        repository.addProduct(smartphone1);
        repository.addProduct(smartphone2);

        Assertions.assertThrows(NotFoundException.class, () -> repository.removeById(3));
    }
}
