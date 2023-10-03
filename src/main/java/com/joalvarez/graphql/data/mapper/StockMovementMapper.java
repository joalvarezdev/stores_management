package com.joalvarez.graphql.data.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joalvarez.baseframework.data.mapper.BaseMapper;
import com.joalvarez.graphql.data.domain.StockMovement;
import com.joalvarez.graphql.data.dto.StockMovementDTO;
import org.springframework.stereotype.Component;

@Component
public class StockMovementMapper extends BaseMapper<StockMovementDTO, StockMovement> {

	public StockMovementMapper(ObjectMapper mapper) {
		super(mapper);
	}

	@Override
	public StockMovementDTO toDTO(StockMovement entity) {
		StockMovementDTO dto = super.toDTO(entity);

		dto.setId(entity.getId().getId());
		dto.setProductId(entity.getId().getProduct().getCode());
		dto.setWarehouseId(entity.getId().getWarehouse().getId());
		dto.setRow(entity.getId().getRow());

		return dto;
	}


}
