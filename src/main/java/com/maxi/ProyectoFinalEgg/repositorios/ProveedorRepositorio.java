package com.maxi.ProyectoFinalEgg.repositorios;

import com.maxi.ProyectoFinalEgg.entidades.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, String>{
    
}
