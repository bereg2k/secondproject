package sweets;

public class Chocolate extends Sweets {
    private String chocType; //dark, white or milk

    public Chocolate() {
    }

    public Chocolate(String name, double weight, double price, String chocType) {
        super(name, weight, price);
        this.chocType = chocType;
    }


    public String getChocType() {
        return chocType;
    }

    public void setChocType(String chocType) {
        this.chocType = chocType;
    }

    @Override
    public String toString() {
        return "Chocolate [" + super.toString() + ", type = " + chocType + "]";
    }
}
