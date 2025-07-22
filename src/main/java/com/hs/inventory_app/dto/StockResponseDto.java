package com.hs.inventory_app.dto;

import com.hs.inventory_app.model.Stock;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StockResponseDto {
    private Long id;
    private Integer quantity;
    private Long productId;
    private String productName;
    private Long warehouseId;
    private String warehouseName;

    public static StockResponseDto fromEntity(Stock stock) {
        return new StockResponseDto(
                stock.getId(),
                stock.getQuantity(),
                stock.getProduct().getId(),
                stock.getProduct().getName(),
                stock.getWarehouse().getId(),
                stock.getWarehouse().getName()
        );
    }
}
