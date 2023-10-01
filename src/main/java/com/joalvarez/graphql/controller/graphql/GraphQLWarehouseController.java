package com.joalvarez.graphql.controller.graphql;

import com.joalvarez.baseframework.data.dto.ResponseDTO;
import com.joalvarez.graphql.data.dto.WarehouseDTO;
import com.joalvarez.graphql.exception.InternalCode;
import com.joalvarez.graphql.service.WarehouseService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

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
	public WarehouseDTO save(@Argument(name = "warehouse") WarehouseDTO dto) {
		return this.service.save(dto);
	}

	@MutationMapping(name = "updateWarehouse")
	public WarehouseDTO update(@Argument(name = "warehouse") WarehouseDTO dto) {
		return this.service.update(dto);
	}

	@MutationMapping(name = "deleteWarehouse")
	public ResponseDTO delete(@Argument(name = "warehouseId") String id) {
		this.service.deleteById(UUID.fromString(id));
		return new ResponseDTO(
			InternalCode.OK.code(),
			InternalCode.OK.message(),
			List.of()
		);
	}
}
