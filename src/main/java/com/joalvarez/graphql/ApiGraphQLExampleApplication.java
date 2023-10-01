package com.joalvarez.graphql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.joalvarez.baseframework.config.GlobalConfig;
import com.joalvarez.graphql.data.domain.Product;
import com.joalvarez.graphql.data.dto.ProductDTO;
import com.joalvarez.graphql.data.repository.ProductRepository;
import com.joalvarez.graphql.service.ProductService;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

@SpringBootApplication(scanBasePackages = GlobalConfig.BASE_PACKAGE)
public class ApiGraphQLExampleApplication {

	private ObjectMapper objectMapper;

	public static void main(String[] args) {
		SpringApplication.run(ApiGraphQLExampleApplication.class, args);
	}

/*
	@Bean
	CommandLineRunner init(ProductService service) {
		return args -> {
			for(int i = 0; i < 100000; i++) {
				ProductDTO dto = new ProductDTO();
				Faker f = new Faker(new Locale("es-AR"));

				dto.setCode(f.code().asin());
				dto.setName(f.commerce().productName());
				dto.setPrice(new BigDecimal(f.commerce().price().replace(",", ".")));

				service.save(dto);
			}
		};
	}
*/

	@Bean
	public MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(this.objectMapper);
		this.objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
		return converter;
	}

	@Bean
	public RestTemplate restTemplate(@Autowired MappingJackson2HttpMessageConverter converter) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(List.of(converter));
		return restTemplate;
	}

	@Autowired
	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

}