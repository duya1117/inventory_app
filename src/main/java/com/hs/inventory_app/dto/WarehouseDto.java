package com.hs.inventory_app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarehouseDto {
    @NotBlank(message = "창고명을 입력해주세요")
    private String name;

    @Size(max = 200, message = "위치 정보는 최대 200자까지 허용됩니")
    private String location;
}
