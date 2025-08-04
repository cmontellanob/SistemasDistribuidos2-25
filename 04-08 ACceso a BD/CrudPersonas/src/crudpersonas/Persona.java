/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudpersonas;

/**
 *
 * @author DELL
 */
public class Persona {
    int id;
    String nombre;
    String apellidos;
    int edad;
    String numerocarnet;

    public Persona(int id, String nombre, String apellidos, int edad, String numerocarnet) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.numerocarnet = numerocarnet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNumerocarnet() {
        return numerocarnet;
    }

    public void setNumerocarnet(String numerocarnet) {
        this.numerocarnet = numerocarnet;
    }


    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", numerocarnet=" + numerocarnet + '}';
    }
    
    
}
