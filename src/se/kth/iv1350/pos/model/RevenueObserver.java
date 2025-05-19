package se.kth.iv1350.pos.model;

/*
 * Interface för klasser som vill observera och reagera på ny försäljning.
 */
public interface RevenueObserver {
    /*
     * Anropas när en ny försäljning har registrerats.
     */
    void newRevenue(double amount);
}
