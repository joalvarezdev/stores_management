package com.joalvarez.graphql.data.dao;

import com.joalvarez.baseframework.data.dao.BaseJPADAO;
import com.joalvarez.graphql.data.domain.StockMovement;
import com.joalvarez.graphql.data.repository.StockMovementRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class StockMovementJPADAO extends BaseJPADAO<StockMovementRepository, StockMovement, UUID> {

	public StockMovementJPADAO(StockMovementRepository repository) {
		super(repository);
	}

	public List<StockMovement> findAllByProductId(String id) {
		return this.getRepository().findByProductCode(id);
	}

	public List<StockMovement> findAllByProductIdAndWarehouseId(String productId, UUID warehouseId) {
		return this.getRepository().findByWarehouseIdAndProductCode(warehouseId, productId);
	}
}
