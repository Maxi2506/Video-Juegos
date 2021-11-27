package com.maxi.ProyectoFinalEgg.repositorios;

import com.maxi.ProyectoFinalEgg.entidades.Articulo;
import com.maxi.ProyectoFinalEgg.enumeracion.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepositorio extends JpaRepository<Articulo, String> {

    public List<Articulo> findAllByOrderByNombreAsc();

    @Query("SELECT a from Articulo a WHERE a.categoria LIKE :categoria AND a.alta = true")
    public List<Articulo> buscarPorCategoria(@Param("categoria") Categoria categoria);

    public List<Articulo> findByNombreContainingOrderByNombre(String nombre);

}
