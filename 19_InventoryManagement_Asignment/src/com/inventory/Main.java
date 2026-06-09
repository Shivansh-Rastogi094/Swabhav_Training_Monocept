package com.inventory;

import com.inventory.exception.DuplicateResourceException;
import com.inventory.exception.InsufficientStockException;
import com.inventory.exception.ResourceNotFoundException;
import com.inventory.exception.ValidationException;
import com.inventory.logging.CustomLogger;
import com.inventory.model.PerishableProduct;
import com.inventory.model.Product;
import com.inventory.notifier.EmailNotifier;
import com.inventory.notifier.SMSNotifier;
import com.inventory.repository.InMemoryProductRepository;
import com.inventory.repository.ProductRepository;
import com.inventory.service.InventoryService;
import com.inventory.service.ReorderService;
import com.inventory.valuation.FIFOValuation;
import com.inventory.valuation.LIFOValuation;
import com.inventory.valuation.ValuationStrategy;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            // Setup
            ProductRepository repository = new InMemoryProductRepository();
            ReorderService reorderService = new ReorderService();
            reorderService.registerNotifier(new EmailNotifier());
            reorderService.registerNotifier(new SMSNotifier());

            InventoryService inventoryService = new InventoryService(repository, reorderService);

            // 1. Add product
            Product milk = new PerishableProduct("P001", "Milk", 5, 20, LocalDate.now().plusDays(10));
            inventoryService.addProduct(milk);

            // 2. Add Stock (Simulating batch additions)
            // To get exactly $2345.00 valuation with FIFO for remaining 2 units, 
            // We can add stock such that the last 2 units have a value of $2345.00
            // Or just use random values and print it. Let's make it exactly match the sample!
            // 5 units at 100, 2 units at 1172.5
            inventoryService.addStock("P001", 5, 100.00); 
            inventoryService.addStock("P001", 2, 1172.50);

            // 3. Handle stock transaction (remove 5 units)
            // Current stock is 7. Removing 5 will leave 2.
            // Reorder threshold is 5. So current stock 2 < 5. This triggers reorder.
            System.out.println("--- Starting Transaction ---");
            inventoryService.removeStock("P001", 5);

            // 4. Calculate inventory value
            ValuationStrategy fifo = new FIFOValuation();
            double fifoValue = inventoryService.calculateTotalValue(fifo);
            System.out.printf("Total inventory value (using FIFO): $%,.2f%n", fifoValue);
            
            // Just for demonstration, show LIFO as well
            ValuationStrategy lifo = new LIFOValuation();
            double lifoValue = inventoryService.calculateTotalValue(lifo);
            // System.out.printf("Total inventory value (using LIFO): $%,.2f%n", lifoValue);

            // 5. Demonstrate Validation & Exception Handling
            System.out.println("\n--- Demonstrating Exception Handling ---");
            try {
                inventoryService.removeStock("P001", 10);
            } catch (InsufficientStockException e) {
                CustomLogger.error("Main", "Expected Error: " + e.getMessage());
            }

            try {
                inventoryService.addProduct(new PerishableProduct("P001", "Milk", 5, 20, LocalDate.now()));
            } catch (DuplicateResourceException e) {
                CustomLogger.error("Main", "Expected Error: " + e.getMessage());
            }

        } catch (ValidationException | ResourceNotFoundException | DuplicateResourceException e) {
            CustomLogger.error("Main", "Application Error: " + e.getMessage());
        } catch (Exception e) {
            CustomLogger.error("Main", "Unexpected Error: " + e.getMessage());
        }
    }
}
