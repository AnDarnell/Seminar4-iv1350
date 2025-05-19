package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.model.RevenueObserver;

public class TotalRevenueView implements RevenueObserver {
    @Override
    public void newRevenue(double totalRevenue) {
        System.out.println("[Observer] Total försäljning hittills: " + totalRevenue + " kr");
    }
}
