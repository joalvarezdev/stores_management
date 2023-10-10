package com.joalvarez.graphql.data.repository;

import com.joalvarez.baseframework.data.repository.GenericRepository;
import com.joalvarez.graphql.data.domain.StockMovement;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StockMovementRepository extends GenericRepository<StockMovement, UUID> {

	List<StockMovement> findByProductCode(String id);
	List<StockMovement> findByWarehouseIdAndProductCode(UUID warehouseId, String productCode);
}
