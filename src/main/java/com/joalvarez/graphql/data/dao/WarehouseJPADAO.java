package com.joalvarez.graphql.data.dao;

import com.joalvarez.baseframework.data.dao.BaseJPADAO;
import com.joalvarez.graphql.data.domain.Warehouse;
import com.joalvarez.graphql.data.repository.WarehouseRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class WarehouseJPADAO extends BaseJPADAO<WarehouseRepository, Warehouse, UUID> {

	public WarehouseJPADAO(WarehouseRepository repository) {
		super(repository);
	}

	public boolean existsById(UUID id) {
		return this.getRepository().existsById(id);
	}

	public Optional<Warehouse> findById(UUID id) {
		return this.getRepository().findById(id);
	}
}
