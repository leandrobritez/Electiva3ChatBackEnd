/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.electiva.chat.model;

import java.util.Date;

/**
 *
 * @author leandrobritez
 */

public class Message {
    
    private String mensaje;
    private Integer emisorId;
    private Integer receptorId;
    private Date fecha;

    public String getMensaje() {return mensaje;}
    public void setMensaje(String mensaje) {this.mensaje = mensaje;}
    public Integer getEmisorId() {return emisorId;}
    public void setEmisorId(Integer emisorId) {this.emisorId = emisorId;}
    public Integer getReceptorId() {return receptorId;}
    public void setReceptorId(Integer receptorId) {this.receptorId = receptorId;}
    public Date getFecha() {return fecha;}
    public void setFecha(Date fecha) {this.fecha = fecha;}
    
}