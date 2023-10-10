package com.joalvarez.graphql.data.repository;

import com.joalvarez.baseframework.data.repository.GenericRepository;
import com.joalvarez.graphql.data.domain.Warehouse;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WarehouseRepository extends GenericRepository<Warehouse, UUID> {

	boolean existsById(UUID id);
	Optional<Warehouse> findById(UUID id);
}
