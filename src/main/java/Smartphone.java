public class Smartphone extends Product {
    protected String brand;

    public Smartphone(int id, String name, int price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (getBrand().contains(search)) {
            return true;
        }
        return false;
    }

    public String getBrand() {
        return brand;
    }
}
