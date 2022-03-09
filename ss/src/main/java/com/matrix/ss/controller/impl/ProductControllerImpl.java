package com.matrix.ss.controller.impl;

import com.matrix.ss.controller.ProductController;
import com.matrix.ss.negocio.ProductEntity;
import com.matrix.ss.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.*;


@Data
@RestController
@RequestMapping("/products")
public class ProductControllerImpl implements ProductController {

    @Autowired
    ProductService productService;
    private static final Logger LOGGER = LoggerFactory.getLogger(com.matrix.ss.service.impl.ProductServiceImpl.class);



    public List<ProductEntity> getProductos(){
        return productService.getProductos();
    }

    public Optional<ProductEntity> getProductoById(@PathVariable int id){

        if (productService.getProductoById(id)!= null){
            return productService.getProductoById(id);
        }else{
            return null;
        }
    }

    public String addProduct(@RequestBody final ProductEntity product){
        LOGGER.info("ProductControllerImpl: Se carga el siguiente producto: {}",product.toString());
        String response = productService.addProduct(product);
        return "Se cargo el producto "+response+" correctamente";
    }

    public ResponseEntity<?> deleteById(@PathVariable int id){
        return productService.deleteById(id);
    }







}
