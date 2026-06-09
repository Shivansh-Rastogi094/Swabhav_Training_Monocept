package com.inventory.service;

import com.inventory.exception.DuplicateResourceException;
import com.inventory.exception.InsufficientStockException;
import com.inventory.exception.ResourceNotFoundException;
import com.inventory.exception.ValidationException;
import com.inventory.model.Product;
import com.inventory.model.StockBatch;
import com.inventory.repository.ProductRepository;
import com.inventory.valuation.ValuationStrategy;

public class InventoryService {
    private final ProductRepository productRepository;
    private final ReorderService reorderService;

    public InventoryService(ProductRepository productRepository, ReorderService reorderService) {
        this.productRepository = productRepository;
        this.reorderService = reorderService;
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new ValidationException("Product cannot be null");
        }
        if (product.getId() == null || product.getId().trim().isEmpty()) {
            throw new ValidationException("Product ID cannot be empty");
        }
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new ValidationException("Product name cannot be empty");
        }
        if (product.getReorderThreshold() < 0 || product.getReorderQuantity() <= 0) {
            throw new ValidationException("Invalid reorder threshold or quantity");
        }
        if (productRepository.existsById(product.getId())) {
            throw new DuplicateResourceException("Product with ID " + product.getId() + " already exists");
        }
        if (productRepository.existsByName(product.getName())) {
            throw new DuplicateResourceException("Product with Name '" + product.getName() + "' already exists");
        }
        
        productRepository.save(product);
    }

    public void addStock(String productId, int quantity, double unitCost) {
        if (quantity <= 0) {
            throw new ValidationException("Stock quantity must be greater than 0");
        }
        if (unitCost < 0) {
            throw new ValidationException("Unit cost cannot be negative");
        }

        Product product = getProduct(productId);
        product.addBatch(new StockBatch(quantity, unitCost));
    }

    public void removeStock(String productId, int quantity) {
        if (quantity <= 0) {
            throw new ValidationException("Removal quantity must be greater than 0");
        }

        Product product = getProduct(productId);
        if (product.getTotalStock() < quantity) {
            throw new InsufficientStockException("Not enough stock for product '" + product.getName() + "'. Available: " + product.getTotalStock());
        }

        product.removeStock(quantity);
        System.out.println("Stock updated: Removed " + quantity + " units of '" + product.getName() + "'");
        System.out.println("Current stock for " + product.getName() + ": " + product.getTotalStock());

        reorderService.checkAndReorder(product);
    }

    public double calculateTotalValue(ValuationStrategy strategy) {
        return strategy.calculateValue(productRepository.findAll());
    }

    private Product getProduct(String productId) {
        if (productId == null || productId.trim().isEmpty()) {
            throw new ValidationException("Product ID cannot be empty");
        }
        Product product = productRepository.findById(productId);
        if (product == null) {
            throw new ResourceNotFoundException("Product with ID " + productId + " not found");
        }
        return product;
    }
}
