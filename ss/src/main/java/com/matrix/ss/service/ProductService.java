package com.matrix.ss.service;

import com.matrix.ss.negocio.ProductEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    List<ProductEntity> getProductos();

    Optional<ProductEntity> getProductoById(int id);

    String addProduct(final ProductEntity products);

    ResponseEntity<?> deleteById(int id);
}
