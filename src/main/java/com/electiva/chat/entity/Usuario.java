/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.electiva.chat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gino_junchaya
 */

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuario_id")
    @JsonProperty("usuario_id")
    private Integer usuarioId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "usuario")
    @JsonProperty("usuario")
    private String usuario;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "usuario_nombre")
    @JsonProperty("usuario_nombre")    
    private String usuarioNombre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "usuario_apellido")
    @JsonProperty("usuario_apellido")    
    private String usuarioApellido;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "usuario_contrasea")
    @JsonProperty("usuario_contrasea")    
    private String usuarioContrasea;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mensajeEmisor", fetch = FetchType.LAZY)
    private List<Mensaje> mensajeList;

    public Usuario() {}
    public Usuario(Integer usuarioId) {this.usuarioId = usuarioId;}
    public Integer getUsuarioId() {return usuarioId;}
    public void setUsuarioId(Integer usuarioId) {this.usuarioId = usuarioId;}
    public String getUsuario() {return usuario;}
    public void setUsuario(String usuario) {this.usuario = usuario;}
    public String getUsuarioNombre() {return usuarioNombre;}
    public void setUsuarioNombre(String usuarioNombre) {this.usuarioNombre = usuarioNombre;}
    public String getUsuarioApellido() {return usuarioApellido;}
    public void setUsuarioApellido(String usuarioApellido) {this.usuarioApellido = usuarioApellido;}
    public String getUsuarioContrasea() {return usuarioContrasea;}
    public void setUsuarioContrasea(String usuarioContrasea) {this.usuarioContrasea = usuarioContrasea;}
    public List<Mensaje> getMensajeList() {return mensajeList;}
    public void setMensajeList(List<Mensaje> mensajeList) {this.mensajeList = mensajeList;}

}
