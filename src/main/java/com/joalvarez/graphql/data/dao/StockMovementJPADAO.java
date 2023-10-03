package com.joalvarez.graphql.data.dao;

import com.joalvarez.baseframework.data.dao.BaseJPADAO;
import com.joalvarez.graphql.data.domain.StockMovement;
import com.joalvarez.graphql.data.domain.StockMovementId;
import com.joalvarez.graphql.data.repository.StockMovementRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StockMovementJPADAO extends BaseJPADAO<StockMovementRepository, StockMovement, StockMovementId> {

	public StockMovementJPADAO(StockMovementRepository repository) {
		super(repository);
	}

	public List<StockMovement> findAllByProductId(String id) {
		return this.getRepository().findByIdProductCode(id);
	}
}
