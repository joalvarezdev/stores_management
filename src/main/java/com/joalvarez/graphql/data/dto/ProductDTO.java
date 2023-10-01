package com.joalvarez.graphql.data.dto;

import com.joalvarez.baseframework.data.dto.BaseDTO;

import java.math.BigDecimal;

public class ProductDTO implements BaseDTO {

	private String code;
	private String name;
	private BigDecimal price;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
