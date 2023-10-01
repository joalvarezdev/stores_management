package com.joalvarez.graphql.data.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joalvarez.baseframework.data.mapper.BaseMapper;
import com.joalvarez.graphql.data.domain.Warehouse;
import com.joalvarez.graphql.data.dto.WarehouseDTO;
import org.springframework.stereotype.Component;

@Component
public class WarehouseMapper extends BaseMapper<WarehouseDTO, Warehouse> {
	public WarehouseMapper(ObjectMapper mapper) {
		super(mapper);
	}
}
