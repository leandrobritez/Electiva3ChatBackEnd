/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.electiva.chat.controller;

import com.electiva.chat.entity.Mensaje;
import com.electiva.chat.model.Message;
import com.electiva.chat.service.MensajeService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gino_junchaya
 */

@RestController
@RequestMapping("/mensaje")
@CrossOrigin(origins = "*")
public class MensajeController {
    
    @Autowired
    private MensajeService mensajeService;
    
    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMensajesByUsuario(@RequestParam("usuario_id") Integer usuarioId,
            @RequestParam("contacto_id") Integer contactoId){
        try {
            List<Mensaje> mensajes = mensajeService.getMensajesByUsuarioId(usuarioId, contactoId);
            return new ResponseEntity<>(mensajes, HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(MensajeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @MessageMapping("/mensaje")
    @SendTo("/topic/mensaje")
    public ResponseEntity<?> sendMessage(@RequestBody Message message){
        try{
            Mensaje mensaje = mensajeService.sendMessage(message);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        }
        catch(Exception ex){
            Logger.getLogger(MensajeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
