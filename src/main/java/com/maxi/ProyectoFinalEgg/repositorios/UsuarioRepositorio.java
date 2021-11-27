package com.maxi.ProyectoFinalEgg.repositorios;

import com.maxi.ProyectoFinalEgg.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

    @Query("SELECT a from Usuario a WHERE a.correo LIKE :correo AND a.alta = true")
    public Usuario buscarPorEmail(@Param("correo") String correo);

}
