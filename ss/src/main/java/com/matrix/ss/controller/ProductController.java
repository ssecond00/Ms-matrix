package com.matrix.ss.controller;

import com.matrix.ss.negocio.ProductEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


public interface ProductController {

    @Operation(summary = "Obtiene todos los productos disponibles", description = "Obtiene todos los productos disponibles", tags = {
            "products" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),

            @ApiResponse(responseCode = "404"),

            @ApiResponse(responseCode = "500") })

    @GetMapping("/all")
    List<ProductEntity> getProductos();

    @Operation(summary = "Obtiene el producto asociado al id indicado", description = "Obtiene el producto asociado al id indicado", tags = {
            "products" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),

            @ApiResponse(responseCode = "404"),

            @ApiResponse(responseCode = "500") })

    @GetMapping("/getById/{id}")
    Optional<ProductEntity> getProductoById(int id);


    @Operation(summary = "Agrega un producto al catalogo", description = "Agrega un producto al catalogo", tags = {
            "products" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),

            @ApiResponse(responseCode = "404"),

            @ApiResponse(responseCode = "500") })

    @PostMapping("/cargar")
    List<ProductEntity> addProduct(final ProductEntity products);

    @Operation(summary = "Elimina un producto al catalogo dado un id asociado", description = "Elimina un producto al catalogo dado un id asociado", tags = {
            "products" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),

            @ApiResponse(responseCode = "404"),

            @ApiResponse(responseCode = "500") })
    @DeleteMapping("/DeleteById/{id}")
    ResponseEntity<?> deleteById(int id);
}
