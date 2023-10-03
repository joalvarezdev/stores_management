package com.joalvarez.graphql.data.repository;

import com.joalvarez.baseframework.data.repository.GenericRepository;
import com.joalvarez.graphql.data.domain.StockMovement;
import com.joalvarez.graphql.data.domain.StockMovementId;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockMovementRepository extends GenericRepository<StockMovement, StockMovementId> {

	List<StockMovement> findByIdProductCode(String id);
}
