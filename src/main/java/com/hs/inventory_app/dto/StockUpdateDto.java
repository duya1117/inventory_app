package com.hs.inventory_app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockUpdateDto {
    @NotNull(message = "수량을 입력해 주세요")
    @Min(value = 0, message = "수량은 0 이상이여야 합니다.")
    private Integer quantity;
}
