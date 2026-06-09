package com.inventory.service;

import com.inventory.logging.CustomLogger;
import com.inventory.model.Product;
import com.inventory.notifier.Notifier;

import java.util.ArrayList;
import java.util.List;

public class ReorderService {
    private final List<Notifier> notifiers = new ArrayList<>();

    public void registerNotifier(Notifier notifier) {
        notifiers.add(notifier);
    }

    public void checkAndReorder(Product product) {
        if (product.getTotalStock() < product.getReorderThreshold()) {
            CustomLogger.info("ReorderService", "Reorder threshold reached for '" + product.getName() + "'. Triggering reorder...");
            CustomLogger.info("ReorderService", "Reorder placed for " + product.getReorderQuantity() + " units of '" + product.getName() + "'");
            
            String message = "Low stock alert for '" + product.getName() + "'";
            for (Notifier notifier : notifiers) {
                notifier.sendNotification(message);
            }
        }
    }
}
