import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }


    public void addProduct(Product newProduct) {
        repository.addProduct(newProduct);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[1];
        int index = 0;
        for (Product product : repository.allProduct()) {
            if (matches(product, text)) {
                result[index] = product;
                index++;
                }
            }
        return result;
    }

    private boolean matches(Product product, String search) {
        return product.toString().contains(search);
    }

}







