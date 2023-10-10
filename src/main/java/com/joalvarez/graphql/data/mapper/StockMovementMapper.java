package com.joalvarez.graphql.data.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joalvarez.baseframework.data.mapper.BaseMapper;
import com.joalvarez.graphql.data.domain.StockMovement;
import com.joalvarez.graphql.data.dto.ProductDTO;
import com.joalvarez.graphql.data.dto.RequestStockMovementDTO;
import com.joalvarez.graphql.data.dto.StockMovementDTO;
import com.joalvarez.graphql.data.dto.WarehouseDTO;
import org.springframework.stereotype.Component;

@Component
public class StockMovementMapper extends BaseMapper<StockMovementDTO, StockMovement> {

	public StockMovementMapper(ObjectMapper mapper) {
		super(mapper);
	}

	public StockMovementDTO requestToDto(RequestStockMovementDTO dto, ProductDTO productDTO, WarehouseDTO warehouseDTO) {
		StockMovementDTO entity = new StockMovementDTO();

		entity.setProduct(productDTO);
		entity.setWarehouse(warehouseDTO);
		entity.setRow(dto.getRow());
		entity.setMovementType(dto.getMovementType());
		entity.setDescription(dto.getDescription());
		entity.setQuantity(dto.getQuantity());
		entity.setDate(dto.getDate());

		return entity;
	}
}
