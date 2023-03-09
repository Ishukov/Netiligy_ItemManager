import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;
import static  org.mockito.Mockito.*;
public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(11, "book1", 100, "author1");
    Product book2 = new Book(12, "book2", 300, "author2");
    Product book3 = new Book(13, "book3", 200, "author3");
    Product smartphone1 = new Smartphone(21, "smartphone1", 2000, "brand1");
    Product smartphone2 = new Smartphone(22, "smartphone2", 5000, "brand2");

    @Test
    public void shouldSearchProduct(){
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("100");

        Assertions.assertArrayEquals(expected,actual);
    }
}
