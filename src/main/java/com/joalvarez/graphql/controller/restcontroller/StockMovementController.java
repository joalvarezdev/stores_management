package com.joalvarez.graphql.controller.restcontroller;

import com.joalvarez.graphql.data.dto.StockMovementDTO;
import com.joalvarez.graphql.service.StockMovementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("movements")
public class StockMovementController {

	private final StockMovementService service;

	public StockMovementController(StockMovementService service) {
		this.service = service;
	}

	@GetMapping("{product_id}")
	public ResponseEntity<List<StockMovementDTO>> getMovementByProductId(@RequestParam(name = "product_id") String id) {
		return ResponseEntity.ok(this.service.getAllMovementsByProductId(id));
	}

	@GetMapping("{warehouse_id}/{product_id}")
	public ResponseEntity<List<StockMovementDTO>> getMovementByProductIdWarehouseId(
		@RequestParam(name = "warehouse_id") UUID warehouseId,
		@RequestParam(name = "product_id") String productId
	) {
		return ResponseEntity.ok(this.service.findByWarehouseAndProductId(warehouseId, productId));
	}
}
