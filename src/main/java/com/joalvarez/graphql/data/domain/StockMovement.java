package com.joalvarez.graphql.data.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "movements")
public class StockMovement {

	@EmbeddedId
	private StockMovementId id;
	private String movementType;
	private String description;
	private BigDecimal quantity;
	private LocalDateTime date;

	public StockMovementId getId() {
		return id;
	}

	public void setId(StockMovementId id) {
		this.id = id;
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
