package com.inventory.model;

import java.time.LocalDate;

public class PerishableProduct extends Product {
    private LocalDate expiryDate;

    public PerishableProduct(String id, String name, int reorderThreshold, int reorderQuantity, LocalDate expiryDate) {
        super(id, name, reorderThreshold, reorderQuantity);
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "PerishableProduct{id='" + getId() + "', name='" + getName() + "', totalStock=" + getTotalStock() + ", expiryDate=" + expiryDate + "}";
    }
}
