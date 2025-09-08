/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simplechat;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Principal {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca su nombre");
        String nombre;
        nombre = sc.next();
        new SimpleChat(nombre).start();
    }
}
