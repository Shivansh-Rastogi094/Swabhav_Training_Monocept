package com.inventory.valuation;

import com.inventory.model.Product;
import com.inventory.model.StockBatch;
import java.util.List;

public class LIFOValuation implements ValuationStrategy {
    @Override
    public double calculateValue(List<Product> products) {
        double totalValue = 0;

        for (Product product : products) {
            int toSkip = product.getTotalRemoved();
            List<StockBatch> batches = product.getBatches();
            
            for (int i = batches.size() - 1; i >= 0; i--) {
                StockBatch batch = batches.get(i);
                if (toSkip >= batch.getQuantity()) {
                    toSkip -= batch.getQuantity();
                } else {
                    int remainingQuantity = batch.getQuantity() - toSkip;
                    totalValue += remainingQuantity * batch.getUnitCost();
                    toSkip = 0;
                }
            }
        }
        return totalValue;
    }
}
