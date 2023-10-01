package com.joalvarez.graphql.controller.restcontroller;

import com.joalvarez.graphql.data.dto.ProductDTO;
import com.joalvarez.graphql.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

	private final ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAll() {
		return ResponseEntity.ok(this.service.getAll());
	}

}
