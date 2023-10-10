package com.joalvarez.graphql.data.dao;

import com.joalvarez.baseframework.data.dao.BaseJPADAO;
import com.joalvarez.graphql.data.domain.Product;
import com.joalvarez.graphql.data.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductJPADAO extends BaseJPADAO<ProductRepository, Product, String> {

	public ProductJPADAO(ProductRepository repository) {
		super(repository);
	}

	public boolean existByCode(String code) {
		return this.getRepository().existsByCode(code);
	}

	public Optional<Product> findByCode(String code) {
		return this.getRepository().findByCode(code);
	}
}
