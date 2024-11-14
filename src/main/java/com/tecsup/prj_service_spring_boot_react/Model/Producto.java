package com.tecsup.prj_service_spring_boot_react.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "productos")
    private String producto;

    @Column(name = "stock")
    private int stock;

    @Column(name = "detalle")
    private String detalle;

    @Column(name = "precio")
    private double precio;


}
