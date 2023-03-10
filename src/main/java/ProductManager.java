public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProduct(Product newProduct) {
        repository.addProduct(newProduct);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        int index = 0;
        for (Product product : repository.allProduct()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                if (result.length == 0) {
                    tmp[index] = product;
                } else {
                    for (int i = 0; i < tmp.length - 1; i++) {
                        tmp[i] = result[i];
                    }
                    tmp[tmp.length - 1] = product;
                }
                result = tmp;
            }
        }
        return result;
    }

    private boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}







