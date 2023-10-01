package com.joalvarez.graphql.controller.graphql;

import com.joalvarez.graphql.data.dto.ProductDTO;
import com.joalvarez.graphql.service.ProductService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLProductController {

	private final ProductService service;

	public GraphQLProductController(ProductService service) {
		this.service = service;
	}

	@QueryMapping(name = "findProductByCode")
	public ProductDTO findByCode(@Argument(name = "productCode") String code) {
		return this.service.get(code);
	}

	@QueryMapping(name = "findAllProducts")
	public List<ProductDTO> findAll() {
		return this.service.getAll();
	}

	@MutationMapping(name = "createProduct")
	public String save(@Argument(name = "product") ProductDTO dto) {
		this.service.save(dto);
		return "Producto creado correctamente";
	}
}
