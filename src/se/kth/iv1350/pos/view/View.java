// === FILE: view/View.java ===
package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.InventoryDatabaseException;

/**
 * Simulerar användargränssnittet.
 */
public class View {
    private final Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    /*
     * Testkör ett simulerat försäljningsflöde.
     */
    public void runFakeExecution() {
        System.out.println("Startar kassasystem...");

        try {
            controller.registerItem("banana");
            controller.registerItem("crash999");    // (Simulerar systemfel)
            controller.registerItem("unknownItem"); // (Simulerar affärsfel)
            controller.registerItem("bread");
        } catch (InventoryDatabaseException e) {
            System.out.println("[FEL] Tekniskt fel: " + e.getMessage());
        }

        controller.completeSale();
    }
}
