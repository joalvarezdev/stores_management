package com.joalvarez.graphql.data.repository;

import com.joalvarez.baseframework.data.repository.GenericRepository;
import com.joalvarez.graphql.data.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends GenericRepository<Product, String> {

	boolean existsByCode(String code);
	Optional<Product> findByCode(String code);
}
