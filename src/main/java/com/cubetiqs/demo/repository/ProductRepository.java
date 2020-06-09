package com.cubetiqs.demo.repository;

import com.cubetiqs.demo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
