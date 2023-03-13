public class ProductRepository {
    private Product[] products = new Product[0];

    public ProductRepository() {
    }

    public void addProduct(Product newProduct) {
        if (findById(newProduct.id) == null) {
            Product[] tmp = new Product[products.length + 1];
            for (int i = 0; i < products.length; i++) {
                tmp[i] = products[i];
            }
            tmp[tmp.length - 1] = newProduct;
            products = tmp;
            return;
        }
        throw new AlreadyExistsException(
                "Element with id: " + newProduct.id + " already exists"
        );
    }

    public Product[] allProduct() {
        Product[] all = getProducts();
        return all;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.id == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) != null) {
            Product[] tmp = new Product[products.length - 1];
            int index = 0;
            for (Product product : products) {
                if (product.id != id) {
                    tmp[index] = product;
                    index++;
                }
                products = tmp;
            }
            return;
        }
        throw new NotFoundException(
                "Element with id:" + id + "not found"
        );
    }

    public Product[] getProducts() {
        return products;
    }
}
