package com.hs.inventory_app.service;

import com.hs.inventory_app.dto.WarehouseDto;
import com.hs.inventory_app.model.Warehouse;
import com.hs.inventory_app.query.WarehouseQueryRepository;
import com.hs.inventory_app.query.WarehouseSearchCondition;
import com.hs.inventory_app.repository.WarehouseRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;
    private final WarehouseQueryRepository queryRepository;

    public List<Warehouse> search(WarehouseSearchCondition condition) {
        return queryRepository.search(condition);
    }

    public Warehouse getById(Long id) {
        return warehouseRepository.findById(id).orElseThrow(() -> new NoSuchElementException("해당 창고가 없습니다."));
    }

    public Warehouse create(WarehouseDto dto) {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(dto.getName());
        warehouse.setLocation(dto.getLocation());

        return warehouseRepository.save(warehouse);
    }

    public Warehouse update(Long id, WarehouseDto dto) {
        Warehouse warehouse = getById(id);
/*        if (dto.getName() != null && )*/warehouse.setName(dto.getName());
        warehouse.setLocation(dto.getLocation());

        return warehouseRepository.save(warehouse);
    }

    public void delete(Long id) {
        warehouseRepository.deleteById(id);
    }
}
