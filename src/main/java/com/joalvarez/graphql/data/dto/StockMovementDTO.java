package com.joalvarez.graphql.data.dto;

import com.joalvarez.baseframework.data.dto.BaseDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class StockMovementDTO implements BaseDTO {

	private UUID id;
	private String productId;
	private UUID warehouseId;
	private Integer row;
	private String movementType;
	private String description;
	private BigDecimal quantity;
	private LocalDateTime date;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public UUID getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(UUID warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public String getMovementType() {
		return movementType;
	}

	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
