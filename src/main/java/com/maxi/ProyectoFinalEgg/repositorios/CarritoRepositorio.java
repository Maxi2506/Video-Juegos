package com.maxi.ProyectoFinalEgg.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.maxi.ProyectoFinalEgg.entidades.Carrito;

@Repository
public interface CarritoRepositorio extends JpaRepository<Carrito, String>{
    
}
