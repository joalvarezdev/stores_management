package com.joalvarez.graphql.service;

import com.joalvarez.baseframework.service.BaseService;
import com.joalvarez.graphql.data.dao.StockMovementJPADAO;
import com.joalvarez.graphql.data.domain.StockMovement;
import com.joalvarez.graphql.data.dto.ProductDTO;
import com.joalvarez.graphql.data.dto.RequestStockMovementDTO;
import com.joalvarez.graphql.data.dto.StockMovementDTO;
import com.joalvarez.graphql.data.dto.WarehouseDTO;
import com.joalvarez.graphql.data.mapper.StockMovementMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StockMovementService extends BaseService<StockMovementJPADAO, StockMovementMapper, StockMovementDTO, StockMovement, UUID> {

	private final ProductService productService;
	private final WarehouseService warehouseService;

	public StockMovementService(StockMovementJPADAO dao, StockMovementMapper mapper, ProductService productService,
								WarehouseService warehouseService) {
		super(dao, mapper);
		this.productService = productService;
		this.warehouseService = warehouseService;
	}

	public List<StockMovementDTO> getAllMovementsByProductId(String productId) {
		return this.dao.findAllByProductId(productId)
			.stream()
			.map(this.mapper::toDTO)
			.collect(Collectors.toList());
	}

	public List<StockMovementDTO> findByWarehouseAndProductId(UUID warehouseId, String productId) {
		return this.dao.findAllByProductIdAndWarehouseId(productId, warehouseId).stream()
			.map(this.mapper::toDTO)
			.toList();
	}

	public void saveEntities(List<RequestStockMovementDTO> dto) {
		dto.forEach(stockMovement -> {
			ProductDTO productDTO = this.productService.findByCode(stockMovement.getProductId());
			WarehouseDTO warehouseDTO = this.warehouseService.findById(stockMovement.getWarehouseId());

			StockMovement entity = this.mapper.fromDTO(this.mapper.requestToDto(stockMovement, productDTO, warehouseDTO));

			this.info(this.mapper.jsonFromObject(entity));
			this.dao.save(entity);
		});
	}
}
