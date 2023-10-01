package com.joalvarez.graphql.data.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joalvarez.baseframework.data.mapper.BaseMapper;
import com.joalvarez.graphql.data.domain.Product;
import com.joalvarez.graphql.data.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper extends BaseMapper<ProductDTO, Product> {

	public ProductMapper(ObjectMapper mapper) {
		super(mapper);
	}
}
