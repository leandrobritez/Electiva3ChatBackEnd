/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.electiva.chat.repository;

import com.electiva.chat.entity.Mensaje;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gino_junchaya
 */

@Repository
public interface MensajeRepository extends CrudRepository<Mensaje, Serializable>{
        
    @Query("SELECT M FROM Mensaje M WHERE (M.mensajeEmisor.usuarioId = :r AND M.mensajeReceptor.usuarioId = :q) OR (M.mensajeEmisor.usuarioId = :q AND M.mensajeReceptor.usuarioId = :r)")
    public List<Mensaje> findMessages(@Param("r") Integer usuarioId, @Param("q") Integer contactoId);
    
}
