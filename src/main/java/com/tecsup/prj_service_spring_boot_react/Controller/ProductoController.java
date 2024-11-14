package com.tecsup.prj_service_spring_boot_react.Controller;
import com.tecsup.prj_service_spring_boot_react.Exception.ResourceNotFoundException;
import com.tecsup.prj_service_spring_boot_react.Model.Producto;
import com.tecsup.prj_service_spring_boot_react.Repository.ProductoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")

public class ProductoController {

    @Autowired
    private ProductoRespository productoRespository;

    @GetMapping("productos")
    public List<Producto> ListarProductos(){
        return productoRespository.findAll();
    }

    @PostMapping("/productos")
    public Producto guardarProducto(@RequestBody Producto producto){
        return productoRespository.save(producto);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> ListarProductoPorId(@PathVariable long id){
        Producto producto = productoRespository.findById(id).orElseThrow(()->new ResourceNotFoundException("El producto no existe"+ id));
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/productos/{id}")
        public ResponseEntity<Producto> ActualizarProducto(@PathVariable long id, @RequestBody Producto produtoRequest){
        Producto producto = productoRespository.findById(id).orElseThrow(()->new ResourceNotFoundException("El el producto no existe"+ id));

        producto.setProducto(produtoRequest.getProducto());
        producto.setStock(produtoRequest.getStock());
        producto.setDetalle(produtoRequest.getDetalle());
        producto.setPrecio(produtoRequest.getPrecio());

        Producto productoActualizado= productoRespository.save(producto);
        return ResponseEntity.ok(productoActualizado);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>> EliminarProducto(@PathVariable long id){
        Producto producto = productoRespository.findById(id).orElseThrow(()->new ResourceNotFoundException("El producto no existe"+ id));

        productoRespository.delete(producto);
        Map<String, Boolean> response = new HashMap<>();
        response.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}


