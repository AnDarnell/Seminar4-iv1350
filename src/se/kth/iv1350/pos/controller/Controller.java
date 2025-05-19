package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.integration.ExternalInventorySystem;
import se.kth.iv1350.pos.integration.ItemNotFoundException;
import se.kth.iv1350.pos.integration.InventoryDatabaseException;
import se.kth.iv1350.pos.model.Item;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.model.RevenueObserver;
import se.kth.iv1350.pos.util.LogHandler;

import java.util.ArrayList;
import java.util.List;

/*
 * Huvudkontroller för försäljningssystemet.
 */
public class Controller {
    private ExternalInventorySystem inventory;
    private Sale sale;
    private final List<RevenueObserver> revenueObservers = new ArrayList<>();

    public Controller(ExternalInventorySystem inventory) {
        this.inventory = inventory;
        this.sale = new Sale();
    }

    public void registerItem(String itemId) {
        try {
            Item item = inventory.findItem(itemId);
            sale.addItem(item);
            System.out.println("Artikel tillagd: " + item);
        } catch (ItemNotFoundException e) {
            System.out.println("[INFO] Artikel finns inte: " + e.getItemId());
        } catch (InventoryDatabaseException e) {
            LogHandler.getInstance().log(e.getMessage());
            System.out.println("[FEL] Tekniskt fel: " + e.getMessage());
        }
    }

    public void completeSale() {
        double total = sale.getTotal();
        System.out.println("Att betala: " + total + " kr");
        notifyObservers(total);
    }

    public void addRevenueObserver(RevenueObserver obs) {
        revenueObservers.add(obs);
    }

    private void notifyObservers(double amount) {
        for (RevenueObserver obs : revenueObservers) {
            obs.newRevenue(amount);
        }
    }
}
