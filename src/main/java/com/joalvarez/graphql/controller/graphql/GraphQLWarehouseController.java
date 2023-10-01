package com.joalvarez.graphql.controller.graphql;

import com.joalvarez.graphql.data.dto.WarehouseDTO;
import com.joalvarez.graphql.service.WarehouseService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLWarehouseController {

	private final WarehouseService service;

	public GraphQLWarehouseController(WarehouseService service) {
		this.service = service;
	}

	@QueryMapping(name = "findAllStorages")
	public List<WarehouseDTO> findAll() {
		return this.service.getAll();
	}

	@MutationMapping(name = "createWarehouse")
	public String save(@Argument(name = "warehouse") WarehouseDTO dto) {
		this.service.save(dto);
		return "Déposito creado correctamente";
	}
}
