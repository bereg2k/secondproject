package sweets;

public class Lollipop extends Sweets {
    private String size; //S, M, L or XL

    public Lollipop() {
    }

    public Lollipop(String name, double weight, double price, String size) {
        super(name, weight, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Lollipop [" + super.toString() + ", size = " + size + "]";
    }
}
