package com.joalvarez.graphql.service;

import com.joalvarez.baseframework.service.BaseService;
import com.joalvarez.graphql.data.dao.ProductJPADAO;
import com.joalvarez.graphql.data.domain.Product;
import com.joalvarez.graphql.data.dto.ProductDTO;
import com.joalvarez.graphql.data.mapper.ProductMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService<ProductJPADAO, ProductMapper, ProductDTO, Product, String> {

	public ProductService(ProductJPADAO dao, ProductMapper mapper) {
		super(dao, mapper);
	}
}
