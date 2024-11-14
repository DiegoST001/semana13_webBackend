package com.tecsup.prj_service_spring_boot_react.Repository;

import com.tecsup.prj_service_spring_boot_react.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRespository extends JpaRepository<Producto, Long> {
}
