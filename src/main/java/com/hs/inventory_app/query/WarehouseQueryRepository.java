package com.hs.inventory_app.query;

import com.hs.inventory_app.model.QWarehouse;
import com.hs.inventory_app.model.Warehouse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class WarehouseQueryRepository {
    private final JPAQueryFactory queryFactory;

    public List<Warehouse> search(WarehouseSearchCondition condition) {
        QWarehouse warehouse = QWarehouse.warehouse;
        BooleanBuilder builder = new BooleanBuilder();

        if (condition.getName() != null && !condition.getName().isBlank()) {
            builder.and(warehouse.name.containsIgnoreCase(condition.getName()));
        }
        if (condition.getLocation() != null && !condition.getLocation().isBlank()) {
            builder.and(warehouse.location.containsIgnoreCase(condition.getLocation()));
        }

        return queryFactory.selectFrom(warehouse).where(builder).orderBy(warehouse.name.asc()).fetch();
    }
}
