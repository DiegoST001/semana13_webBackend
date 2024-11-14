package com.tecsup.prj_service_spring_boot_react.Repository;

import com.tecsup.prj_service_spring_boot_react.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
