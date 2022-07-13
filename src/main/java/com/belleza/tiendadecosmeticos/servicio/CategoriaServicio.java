package com.belleza.tiendadecosmeticos.servicio;

import com.belleza.tiendadecosmeticos.dto.ResponseInfoDTO;
import com.belleza.tiendadecosmeticos.exception.MyException;
import com.belleza.tiendadecosmeticos.modelo.Categoria;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoriaServicio {

    /*
     * Creacion de metodos a utilizar, en esta interface no va la logica.
     */
    ResponseEntity<List<Categoria>> listarCategorias() throws Exception;

    ResponseEntity<Categoria>  guardarCategorias(Categoria categoria) throws Exception;

    ResponseEntity<ResponseInfoDTO> eliminarCategoria(Long id) throws MyException;

    ResponseEntity<?> listarProductoPorCategoria(Long id) throws MyException;

}
