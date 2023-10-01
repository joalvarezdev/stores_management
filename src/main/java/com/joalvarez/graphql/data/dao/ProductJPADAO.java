package com.joalvarez.graphql.data.dao;

import com.joalvarez.baseframework.data.dao.BaseJPADAO;
import com.joalvarez.graphql.data.domain.Product;
import com.joalvarez.graphql.data.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductJPADAO extends BaseJPADAO<ProductRepository, Product, String> {

	public ProductJPADAO(ProductRepository repository) {
		super(repository);
	}
}
