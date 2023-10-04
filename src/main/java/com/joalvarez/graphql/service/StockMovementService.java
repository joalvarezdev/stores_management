package com.joalvarez.graphql.service;

import com.joalvarez.baseframework.service.BaseService;
import com.joalvarez.graphql.data.dao.StockMovementJPADAO;
import com.joalvarez.graphql.data.domain.StockMovement;
import com.joalvarez.graphql.data.dto.StockMovementDTO;
import com.joalvarez.graphql.data.mapper.StockMovementMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StockMovementService extends BaseService<StockMovementJPADAO, StockMovementMapper, StockMovementDTO, StockMovement, UUID> {

	public StockMovementService(StockMovementJPADAO dao, StockMovementMapper mapper) {
		super(dao, mapper);
	}

	public List<StockMovementDTO> getAllMovementsByProductId(String productId) {
		return this.dao.findAllByProductId(productId)
			.stream()
			.map(this.mapper::toDTO)
			.collect(Collectors.toList());
	}

	public List<StockMovementDTO> findByWarehouseAndProductId(UUID warehouseId, String productId) {
		return null;
	}
}
