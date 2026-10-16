
package ie.atu.cicd1.catalog.cicd1catalogservice.controller;

import ie.atu.cicd1.catalog.cicd1catalogservice.dto.CreateProductRequest;
import ie.atu.cicd1.catalog.cicd1catalogservice.model.Product;
import ie.atu.cicd1.catalog.cicd1catalogservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @PostMapping
    public Product create(@RequestBody CreateProductRequest request) {
        return productService.create(request);
    }

    @GetMapping("/min-price")
    public List<Product> getProductsByMinimumPrice(
            @RequestParam("price") BigDecimal price) {
        return productService.getProductsByMinimumPrice(price);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }
}
