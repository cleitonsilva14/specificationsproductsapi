package io.dev.specificationsproductsapi.controller;


import io.dev.specificationsproductsapi.model.Product;
import io.dev.specificationsproductsapi.queryfilter.ProductQueryfilter;
import io.dev.specificationsproductsapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductRepository productRepository;

    /**
     * Se você estiver usando o Springdoc OpenAPI, basta adicionar a anotação @ParameterObject do Springdoc antes do seu
     * objeto de filtro no Controller. Isso diz ao Swagger para "espalhar" as propriedades do objeto como parâmetros
     * de query individuais.
     */
    @GetMapping
    public List<Product> findAll(@ParameterObject ProductQueryfilter productQueryfilter) {
        return productRepository.findAll(productQueryfilter.getSpecification());
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }


}
