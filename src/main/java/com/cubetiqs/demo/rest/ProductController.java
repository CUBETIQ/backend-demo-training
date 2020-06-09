package com.cubetiqs.demo.rest;

import com.cubetiqs.demo.domain.Product;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    private final List<Product> items = new ArrayList<>();

    @RequestMapping(method = {RequestMethod.GET})
    public List<Product> getAllProducts() {
        items.add(new Product(1L, "Apple", BigDecimal.valueOf(1.0), false));
        items.add(new Product(2L, "Apple", BigDecimal.valueOf(0.5), true));
        return items;
    }

    @GetMapping("/{id}")
    public Product getOneProduct(@PathVariable int id) {
        return items.get(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product item) {
        items.add(item);
        return item;
    }
}
