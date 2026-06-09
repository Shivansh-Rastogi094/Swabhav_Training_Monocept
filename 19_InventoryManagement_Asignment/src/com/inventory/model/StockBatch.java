package com.inventory.model;

public class StockBatch {
    private int quantity;
    private double unitCost;

    public StockBatch(int quantity, double unitCost) {
        this.quantity = quantity;
        this.unitCost = unitCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    @Override
    public String toString() {
        return "StockBatch{" +
                "quantity=" + quantity +
                ", unitCost=" + unitCost +
                '}';
    }
}
