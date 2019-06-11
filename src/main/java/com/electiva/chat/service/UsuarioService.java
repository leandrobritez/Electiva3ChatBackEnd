/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.electiva.chat.service;

import com.electiva.chat.entity.Usuario;
import com.electiva.chat.model.Credenciales;
import com.electiva.chat.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gino_junchaya
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getContactos() throws Exception {
        List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
        if (usuarios != null) {
            usuarios.forEach((usuario) -> {
                usuario.setUsuarioContrasea(null);
            });
            return usuarios;
        } else {
            throw new Exception("Ha ocurrido un error al obtener los contactos");
        }
    }

    public Usuario login(Credenciales credenciales) throws Exception {
        Usuario usuario = (Usuario) usuarioRepository.findByUsuario(credenciales.getUsername());
        if (usuario == null) {
            throw new Exception("Usuario o contraseña inválidas");
        }
        if (usuario.getUsuarioContrasea().equals(credenciales.getPassword())) {
            usuario.setUsuarioContrasea(null);
            return usuario;
        } else {
            throw new Exception("Usuario o contraseña inválidas");
        }
    }

    public Usuario saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        return usuario;
    }
    
    public Usuario findByUsuarioId(Integer usuarioId) throws Exception{
        Usuario usuario = usuarioRepository.findByUsuarioId(usuarioId);
        if(usuario != null){
            return usuario;
        }
        else{
            throw new Exception("El usuario no ha sido encontrado");
        }
    }

}
