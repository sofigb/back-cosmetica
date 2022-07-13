package com.belleza.tiendadecosmeticos.servicio.Impl;

import com.belleza.tiendadecosmeticos.dto.ResponseInfoDTO;
import com.belleza.tiendadecosmeticos.exception.MyException;
import com.belleza.tiendadecosmeticos.modelo.Categoria;
import com.belleza.tiendadecosmeticos.repositorio.CategoriaRepositorio;
import com.belleza.tiendadecosmeticos.servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicioImpl implements CategoriaServicio {

    /*
     * Creamos una clase para implementar nuestros metodos antes creados,
     * le agregamos la etiqueta service y le decimos que este es un implementeacion de
     * nuestra interfas anterior creada, este nos importara todos los metodos, y aqui es
     * donde realizamos toda la logica.
     * */
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Override
    public ResponseEntity<List<Categoria>> listarCategorias() throws Exception {
        try {
            List<Categoria> categorias = categoriaRepositorio.findAll();
            if (categorias.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(categorias);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public ResponseEntity<Categoria> guardarCategorias(Categoria categoria) throws MyException {
        nombreUnico(categoria.getNombre());
        Categoria nuevaCatgoria = categoriaRepositorio.save(categoria);

        if (nuevaCatgoria == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoria);


    }

    @Override
    public ResponseEntity<ResponseInfoDTO> eliminarCategoria(Long id) throws MyException {
        try {
            categoriaRepositorio.deleteById(id);
            return ResponseEntity.ok().body(new ResponseInfoDTO("Se ha eliminado la categoria", HttpStatus.OK.value()));
        } catch (Exception e) {
            throw new MyException("No se ha podido eliminar la categoria seleccionada", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @Override
    public ResponseEntity<?> listarProductoPorCategoria(Long id) throws MyException {
        try {
             Categoria categoria = categoriaRepositorio.findById(id).orElseThrow();
            if (!categoria.getProductos().isEmpty()) {
                return new ResponseEntity<>(categoria.getProductos(), HttpStatus.OK);
            } else  {
                return ResponseEntity.ok().body(new ResponseInfoDTO("No existen producto asociada a dicha categoria", HttpStatus.OK.value()));
            } }  catch(Exception e){
                throw new MyException("No existe categoria con dicho ID", HttpStatus.NOT_FOUND);
            }


    }

    private void nombreUnico(String nombre) throws MyException {
        if (categoriaRepositorio.findAllNombre().contains(nombre.toLowerCase())) {
            throw new MyException("Ya existe una categoria con este nombre", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
