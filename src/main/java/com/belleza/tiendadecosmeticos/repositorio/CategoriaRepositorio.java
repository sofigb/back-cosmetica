package com.belleza.tiendadecosmeticos.repositorio;

import com.belleza.tiendadecosmeticos.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/*
* Esta interface es la que nos ayuda con lo relacionado a la base de datos,
* la extencion mas completa es JpaRepository ya que esta contiene CrudRepository y demas
* funciones que nos ayudan a un desarrollo mas optimizado.
* Siempre va llevar dentro el nombre de nuestra entidad y el tamaño de nuestra
* llave primaria.
* */
@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

    @Query(value = "SELECT LOWER(nombre) FROM Categoria")
    List<String> findAllNombre();
}
