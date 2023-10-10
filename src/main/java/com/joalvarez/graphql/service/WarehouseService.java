package com.joalvarez.graphql.service;

import com.joalvarez.baseframework.service.BaseService;
import com.joalvarez.graphql.data.dao.WarehouseJPADAO;
import com.joalvarez.graphql.data.domain.Warehouse;
import com.joalvarez.graphql.data.dto.WarehouseDTO;
import com.joalvarez.graphql.data.mapper.WarehouseMapper;
import com.joalvarez.graphql.exception.GenericException;
import com.joalvarez.graphql.exception.InternalCode;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
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

	@Override
	public WarehouseDTO update(WarehouseDTO dto) {
		if (Objects.isNull(dto.getId()) || !this.dao.existsById(dto.getId())) {
			throw new GenericException(
				HttpStatus.PRECONDITION_REQUIRED,
				InternalCode.ENTITY_NOT_FOUND,
				LogLevel.WARN,
				"Error has occurred in @WarehouseService.update(WarehouseDTO)"
			);
		}
		return super.update(dto);
	}

	public WarehouseDTO findById(UUID id) {
		return this.dao.findById(id)
			.map(this.mapper::toDTO)
			.orElseThrow(() -> new GenericException(
				HttpStatus.BAD_REQUEST,
				InternalCode.ENTITY_NOT_FOUND,
				LogLevel.ERROR,
				"Error: the warehouse do not exists"
			));
	}
}
