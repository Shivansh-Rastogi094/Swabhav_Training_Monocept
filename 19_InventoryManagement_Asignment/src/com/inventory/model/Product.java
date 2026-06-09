package com.inventory.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Product {
    private String id;
    private String name;
    private int reorderThreshold;
    private int reorderQuantity;
    private List<StockBatch> batches;

    private int totalRemoved;

    public Product(String id, String name, int reorderThreshold, int reorderQuantity) {
        this.id = id;
        this.name = name;
        this.reorderThreshold = reorderThreshold;
        this.reorderQuantity = reorderQuantity;
        this.batches = new ArrayList<>();
        this.totalRemoved = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReorderThreshold() {
        return reorderThreshold;
    }

    public void setReorderThreshold(int reorderThreshold) {
        this.reorderThreshold = reorderThreshold;
    }

    public int getReorderQuantity() {
        return reorderQuantity;
    }

    public void setReorderQuantity(int reorderQuantity) {
        this.reorderQuantity = reorderQuantity;
    }

    public List<StockBatch> getBatches() {
        return batches;
    }

    public void addBatch(StockBatch batch) {
        this.batches.add(batch);
    }

    public void removeStock(int quantity) {
        this.totalRemoved += quantity;
    }

    public int getTotalAdded() {
        return batches.stream().mapToInt(StockBatch::getQuantity).sum();
    }

    public int getTotalStock() {
        return getTotalAdded() - totalRemoved;
    }

    public int getTotalRemoved() {
        return totalRemoved;
    }
}
