package sweets;

public class Jellybean extends Sweets {
    private String flavour; //strawberry, raspberry, apple, banana, cola, etc...

    public Jellybean() {
    }

    public Jellybean(String name, double weight, double price, String flavour) {
        super(name, weight, price);
        this.flavour = flavour;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Jelly bean [" + super.toString() + ", flavour = " + flavour + "]";
    }
}
