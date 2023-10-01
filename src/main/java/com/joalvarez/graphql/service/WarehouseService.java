package com.joalvarez.graphql.service;

import com.joalvarez.baseframework.service.BaseService;
import com.joalvarez.graphql.data.dao.WarehouseJPADAO;
import com.joalvarez.graphql.data.domain.Warehouse;
import com.joalvarez.graphql.data.dto.WarehouseDTO;
import com.joalvarez.graphql.data.mapper.WarehouseMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class WarehouseService extends BaseService<WarehouseJPADAO, WarehouseMapper, WarehouseDTO, Warehouse, UUID> {

	public WarehouseService(WarehouseJPADAO dao, WarehouseMapper mapper) {
		super(dao, mapper);
	}

	@Override
	public WarehouseDTO save(WarehouseDTO dto) {
		if (Objects.isNull(dto.getId())) {
			dto.setId(UUID.randomUUID());
		}
		return super.save(dto);
	}
}
