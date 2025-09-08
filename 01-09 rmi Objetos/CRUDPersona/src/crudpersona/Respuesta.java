/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudpersona;

import java.io.Serializable;

/**
 *
 * @author Dell
 */
public class Respuesta implements Serializable {
    Boolean transaccion;
    String[] mensajes;
    Persona[] datos;

    public Respuesta(Boolean transaccion, String[] mensajes, Persona[] datos) {
        this.transaccion = transaccion;
        this.mensajes = mensajes;
        this.datos = datos;
    }

    public Boolean getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Boolean transaccion) {
        this.transaccion = transaccion;
    }

    public String[] getMensajes() {
        return mensajes;
    }

    public void setMensajes(String[] mensajes) {
        this.mensajes = mensajes;
    }

    public Persona[] getDatos() {
        return datos;
    }

    public void setDatos(Persona[] datos) {
        this.datos = datos;
    }

    
    
}
