package com.maxi.ProyectoFinalEgg.repositorios;

import com.maxi.ProyectoFinalEgg.entidades.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepositorio extends JpaRepository<Carrito,String>{
    
}
