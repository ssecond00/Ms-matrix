package com.matrix.ss.service;

import com.matrix.ss.negocio.ProductEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductEntity> getProductos();

    Optional<ProductEntity> getProductoById(int id);

    List<ProductEntity> addProduct(final ProductEntity products);

    ResponseEntity<?> deleteById(int id);
}
