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
public class Persona implements Serializable {
    private int id;
    private String  nombres;
    private String  apellidos;
    private Sexo  sexo;
    private int numero_documento;

    public Persona(int id, String nombres, String apelldios, Sexo sexo, int numero_documento) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apelldios;
        this.sexo = sexo;
        this.numero_documento = numero_documento;
    }

    public Persona(String nombres, String apelldios, Sexo sexo, int numero_documento) {
        this.nombres = nombres;
        this.apellidos = apelldios;
        this.sexo = sexo;
        this.numero_documento = numero_documento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public int getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(int numero_documento) {
        this.numero_documento = numero_documento;
    }

  
    
    
    
            
    
}
