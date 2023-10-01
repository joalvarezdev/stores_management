package com.joalvarez.graphql.controller.graphql;

import com.joalvarez.baseframework.data.dto.ResponseDTO;
import com.joalvarez.graphql.data.dto.ProductDTO;
import com.joalvarez.graphql.exception.InternalCode;
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
	public ProductDTO save(@Argument(name = "product") ProductDTO dto) {
		return this.service.save(dto);
	}

	@MutationMapping(name = "updateProduct")
	public ProductDTO update(@Argument(name = "product") ProductDTO dto) {
		return this.service.update(dto);
	}

	@MutationMapping(name = "deleteProduct")
	public ResponseDTO delete(@Argument(name = "productId")String id) {
		this.service.deleteById(id);
		return new ResponseDTO(InternalCode.OK.code(), InternalCode.OK.message(), List.of());
	}

}
