package com.matrix.ss.negocio;



import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class ProductEntity {

    public ProductEntity(int id, String nombre, float precio, int cantidad){
        this.id=id;
        this.cantidad=cantidad;
        this.nombre=nombre;
        this.precio=precio;
    }

    public ProductEntity(){
        super();
    }


    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private float precio;

    @Column(name = "cantidad")
    private int cantidad;
}
