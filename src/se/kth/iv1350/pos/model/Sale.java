package se.kth.iv1350.pos.model;

import java.util.ArrayList;
import java.util.List;

/*
 * Representerar en pågående försäljning.
 */
public class Sale {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public double getTotal() {
        return items.stream()
                .mapToDouble(Item::getPriceWithVAT)
                .sum();
    }
}
