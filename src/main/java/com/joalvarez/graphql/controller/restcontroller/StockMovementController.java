package com.joalvarez.graphql.controller.restcontroller;

import com.joalvarez.baseframework.data.dto.ResponseDTO;
import com.joalvarez.graphql.data.dto.RequestStockMovementDTO;
import com.joalvarez.graphql.data.dto.StockMovementDTO;
import com.joalvarez.graphql.exception.InternalCode;
import com.joalvarez.graphql.service.StockMovementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping
	public ResponseEntity<ResponseDTO> save(@RequestBody List<RequestStockMovementDTO> dto) {
		this.service.saveEntities(dto);
		return ResponseEntity.ok(new ResponseDTO(InternalCode.OK));
	}
}
