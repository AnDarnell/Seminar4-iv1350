package se.kth.iv1350.pos.model;

/*
 * Representerar en vara i systemet.
 */
public class Item {
    private final String id;
    private final String description;
    private final double price;
    private final double vat;

    public Item(String id, String description, double price, double vat) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.vat = vat;
    }

    public double getPriceWithVAT() {
        return price * (1 + vat / 100);
    }

    @Override
    public String toString() {
        return description + " [" + id + "] - " + getPriceWithVAT() + " kr";
    }
}

