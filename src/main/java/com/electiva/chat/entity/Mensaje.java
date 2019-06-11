/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.electiva.chat.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gino_junchaya
 */
@Entity
@Table(name = "mensaje")
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mensaje_id")
    private Integer mensajeId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "mensaje")
    private String mensaje;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "mensaje_fecha")
    @Temporal(TemporalType.DATE)
    private Date mensajeFecha;
    
    @JoinColumn(name = "mensaje_emisor", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario mensajeEmisor;
    
    @JoinColumn(name = "mensaje_receptor", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario mensajeReceptor;

    public Integer getMensajeId() {return mensajeId;}
    public void setMensajeId(Integer mensajeId) {this.mensajeId = mensajeId;}
    public String getMensaje() {return mensaje;}
    public void setMensaje(String mensaje) {this.mensaje = mensaje;}
    public Date getMensajeFecha() {return mensajeFecha;}
    public void setMensajeFecha(Date mensajeFecha) {this.mensajeFecha = mensajeFecha;}
    public Usuario getMensajeEmisor() {return mensajeEmisor;}
    public void setMensajeEmisor(Usuario mensajeEmisor) {this.mensajeEmisor = mensajeEmisor;}
    public Usuario getMensajeReceptor() {return mensajeReceptor;}
    public void setMensajeReceptor(Usuario mensajeReceptor) {this.mensajeReceptor = mensajeReceptor;}
    
}
