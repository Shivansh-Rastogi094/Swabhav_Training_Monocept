package com.inventory.valuation;

import com.inventory.model.Product;
import java.util.List;

public interface ValuationStrategy {
    double calculateValue(List<Product> products);
}
