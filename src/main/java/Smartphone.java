
public class Smartphone extends Product {
    protected String brand;

    public Smartphone(int id, String name, int price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }
    @Override
    public String toString() {
        return "Smartphone{" +
                "brand='" + brand + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
