/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.electiva.chat.service;

import com.electiva.chat.entity.Mensaje;
import com.electiva.chat.entity.Usuario;
import com.electiva.chat.model.Message;
import com.electiva.chat.repository.MensajeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author leandrobritez
 */

@Service
public class MensajeService {
    
    @Autowired
    private MensajeRepository mensajeRepository;
    
    public List<Mensaje> getMensajesByUsuarioId(Integer usuarioId, Integer contactoId) throws Exception{
        List<Mensaje> mensajes = mensajeRepository.findMessages(usuarioId, contactoId);
        if(mensajes != null){return mensajes;}
        else{throw new Exception("Ha ocurrido un error al recuperar los mensajes");}
    }
    
    public Mensaje sendMessage(Message message){
        Mensaje mensaje = convertMessage(message);
        return mensajeRepository.save(mensaje);
    }
    
    private Mensaje convertMessage(Message message){
        Mensaje mensaje = new Mensaje();
        mensaje.setMensaje(message.getMensaje());
        mensaje.setMensajeFecha(message.getFecha());
        mensaje.setMensajeEmisor(new Usuario(message.getEmisorId()));
        mensaje.setMensajeReceptor(new Usuario(message.getReceptorId()));
        return mensaje;
    }
    
}
