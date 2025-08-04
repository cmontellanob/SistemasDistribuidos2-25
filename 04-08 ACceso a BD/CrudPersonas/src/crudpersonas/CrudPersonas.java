/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crudpersonas;

/**
 *
 * @author DELL
 */
public class CrudPersonas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonaDAO personaDao=new PersonaDAO("jdbc:mysql://localhost:3306/bd_personas", "root", "");
        Persona p=new Persona (0,"Juean","Perez",30,"123456");
        personaDao.insertar(p);
        // TODO code application logic here
    }
    
}
