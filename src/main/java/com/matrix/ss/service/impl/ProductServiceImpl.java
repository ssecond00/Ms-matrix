package com.matrix.ss.service.impl;

import com.matrix.ss.negocio.ProductEntity;
import com.matrix.ss.repository.ProductsRepository;
import com.matrix.ss.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;


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
    public List<ProductEntity> addProduct(ProductEntity products) {
        productsRepository.save(products);
        Iterable<ProductEntity> productos =  productsRepository.findAll();
        List<ProductEntity> listaProductEntities = new ArrayList<ProductEntity>();
        productos.forEach(listaProductEntities::add);
        System.out.println(productsRepository.findBynombre("caca"));
        return listaProductEntities;
    }

    @Override
    public ResponseEntity<?> deleteById(int id) {
        productsRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
