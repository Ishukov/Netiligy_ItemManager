public class ProductRepository {
    private Product[] products = new Product[0];

    public ProductRepository() {
    }

    public void addProduct(Product newProduct) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = newProduct;
        products = tmp;
    }

    public Product[] allProduct() {
        Product[] all = getProducts();
        return all;
    }

    public void removeById(int id) {
        Product[] tmp = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {
            if (product.id != id) {
                tmp[index] = product;
                index++;
            }
            products = tmp;
        }
    }

    public Product[] getProducts() {
        return products;
    }
}
