package com.inventory.model;

public class NonPerishableProduct extends Product {
    private int warrantyPeriodMonths;

    public NonPerishableProduct(String id, String name, int reorderThreshold, int reorderQuantity, int warrantyPeriodMonths) {
        super(id, name, reorderThreshold, reorderQuantity);
        this.warrantyPeriodMonths = warrantyPeriodMonths;
    }

    public int getWarrantyPeriodMonths() {
        return warrantyPeriodMonths;
    }

    public void setWarrantyPeriodMonths(int warrantyPeriodMonths) {
        this.warrantyPeriodMonths = warrantyPeriodMonths;
    }

    @Override
    public String toString() {
        return "NonPerishableProduct{id='" + getId() + "', name='" + getName() + "', totalStock=" + getTotalStock() + ", warrantyPeriodMonths=" + warrantyPeriodMonths + "}";
    }
}
