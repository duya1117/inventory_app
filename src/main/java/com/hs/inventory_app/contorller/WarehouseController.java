package com.hs.inventory_app.contorller;

import com.hs.inventory_app.dto.WarehouseDto;
import com.hs.inventory_app.model.Warehouse;
import com.hs.inventory_app.query.WarehouseSearchCondition;
import com.hs.inventory_app.service.WarehouseService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
@RequiredArgsConstructor
public class WarehouseController {
    private final WarehouseService warehouseService;

    @GetMapping
    public List<Warehouse> search(WarehouseSearchCondition condition) {
        return warehouseService.search(condition);
    }

    @GetMapping ("/{id}")
    public Warehouse findById(@PathVariable Long id) {
        return warehouseService.getById(id);
    }

    @PostMapping
    public Warehouse create(@Valid @RequestBody WarehouseDto dto) {
        return warehouseService.create(dto);
    }

    @PutMapping("/{id}")
    public Warehouse update(@PathVariable Long id, @Valid @RequestBody WarehouseDto dto){
        return warehouseService.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        warehouseService.delete(id);
    }
}
