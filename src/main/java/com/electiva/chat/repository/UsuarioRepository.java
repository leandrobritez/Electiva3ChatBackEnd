/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.electiva.chat.repository;

import com.electiva.chat.entity.Usuario;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gino_junchaya
 */

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Serializable> {
    public Usuario findByUsuario(String usuario);
    public Usuario findByUsuarioId(Integer usuarioId);
}
