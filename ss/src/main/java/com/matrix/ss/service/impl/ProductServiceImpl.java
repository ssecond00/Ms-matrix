package com.matrix.ss.service.impl;

import com.matrix.ss.negocio.ProductEntity;
import com.matrix.ss.repository.ProductsRepository;
import com.matrix.ss.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(com.matrix.ss.service.impl.ProductServiceImpl.class);


    public ProductServiceImpl(ProductsRepository productsRepository, ProductsRepository productsRepository1) {
        this.productsRepository = productsRepository;
    }

    @Override
    public List<ProductEntity> getProductos() {
        Iterable<ProductEntity> productos =  productsRepository.findAll();
        List<ProductEntity> listaProductEntities = new ArrayList<ProductEntity>();
        productos.forEach(listaProductEntities::add);
        return listaProductEntities;
    }

    @Override
    public Optional<ProductEntity> getProductoById(int id) {
        Optional<ProductEntity> p = productsRepository.findById(id);
        if (p != null){
            return p;
        }else{
            return null;
        }
    }

    @Override
    public String addProduct(ProductEntity product) {
        LOGGER.info("ProductService: Se carga el siguiente producto: {}",product.toString());
        productsRepository.save(product);
        LOGGER.info("ProductService: se cargo en la base el producto: {}",product.toString());
        return product.getNombre();
    }

    @Override
    public ResponseEntity<?> deleteById(int id) {
        productsRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
