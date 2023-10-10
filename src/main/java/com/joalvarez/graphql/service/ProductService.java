package com.joalvarez.graphql.service;

import com.joalvarez.baseframework.service.BaseService;
import com.joalvarez.graphql.data.dao.ProductJPADAO;
import com.joalvarez.graphql.data.domain.Product;
import com.joalvarez.graphql.data.dto.ProductDTO;
import com.joalvarez.graphql.data.mapper.ProductMapper;
import com.joalvarez.graphql.exception.GenericException;
import com.joalvarez.graphql.exception.InternalCode;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService extends BaseService<ProductJPADAO, ProductMapper, ProductDTO, Product, String> {

	public ProductService(ProductJPADAO dao, ProductMapper mapper) {
		super(dao, mapper);
	}

	@Override
	public ProductDTO update(ProductDTO dto) {
		if (Objects.isNull(dto.getCode()) || !this.dao.existByCode(dto.getCode())) {
			throw new GenericException(
				HttpStatus.PRECONDITION_REQUIRED,
				InternalCode.ENTITY_NOT_FOUND,
				LogLevel.WARN,
				"Error has occurred in @ProductService.update(ProductDTO)"
			);
		}
		return super.update(dto);
	}

	@Override
	public ProductDTO get(String code) {
		if (!this.dao.existByCode(code)) {
			throw new GenericException(
				HttpStatus.BAD_REQUEST,
				InternalCode.ENTITY_NOT_FOUND,
				LogLevel.WARN,
				"Warn: Ocurred in @ProductService.get(String)"
			);
		}
		return super.get(code);
	}

	public ProductDTO findByCode(String code)	 {
		return this.dao.findByCode(code)
			.map(this.mapper::toDTO)
			.orElseThrow(() -> new GenericException(
				HttpStatus.BAD_REQUEST,
				InternalCode.ENTITY_NOT_FOUND,
				LogLevel.ERROR,
				"Error: the product do not exists"
			));
	}
}
