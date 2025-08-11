/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crudpersonas;

import java.util.Scanner;
import java.util.List;

/**
 *
 * @author DELL
 */
public class CrudPersonas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO("jdbc:mysql://localhost:3306/bd_personas", "root", "");
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU CRUD PERSONAS ---");
            System.out.println("1. Insertar persona");
            System.out.println("2. Listar personas");
            System.out.println("3. Editar persona");
            System.out.println("4. Eliminar persona");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellidos: ");
                    String apellidos = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nro Carnet: ");
                    String nroCarnet = sc.nextLine();
                    Persona nueva = new Persona(0, nombre, apellidos, edad, nroCarnet);
                    personaDao.insertar(nueva);
                    System.out.println("Persona insertada.");
                    break;
                case 2:
                    List<Persona> personas = personaDao.listar();
                    for (Persona p : personas) {
                        System.out.println(p.getId() + " - " + p.getNombre() + " " + p.getApellidos() + ", Edad: " + p.getEdad() + ", Carnet: " + p.getNumerocarnet());
                    }
                    break;
                case 3:
                    System.out.print("ID de la persona a editar: ");
                    int idEditar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Nuevos apellidos: ");
                    String nuevosApellidos = sc.nextLine();
                    System.out.print("Nueva edad: ");
                    int nuevaEdad = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo nro carnet: ");
                    String nuevoCarnet = sc.nextLine();
                    Persona editada = new Persona(idEditar, nuevoNombre, nuevosApellidos, nuevaEdad, nuevoCarnet);
                    personaDao.editar(editada);
                    System.out.println("Persona actualizada.");
                    break;
                case 4:
                    System.out.print("ID de la persona a eliminar: ");
                    int idEliminar = sc.nextInt();
                    sc.nextLine();
                    personaDao.eliminar(idEliminar);
                    System.out.println("Persona eliminada.");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
