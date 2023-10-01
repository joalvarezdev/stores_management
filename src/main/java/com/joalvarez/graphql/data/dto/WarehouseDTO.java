package com.joalvarez.graphql.data.dto;

import com.joalvarez.baseframework.data.dto.BaseDTO;

import java.util.UUID;

public class WarehouseDTO implements BaseDTO {

	private UUID id;
	private String name;
	private String description;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
