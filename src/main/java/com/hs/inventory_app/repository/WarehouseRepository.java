package com.hs.inventory_app.repository;

import com.hs.inventory_app.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WarehouseRepository extends JpaRepository<Warehouse , Long>, QuerydslPredicateExecutor<Warehouse> {
}
