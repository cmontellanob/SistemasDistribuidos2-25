/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package holamundo;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class HolaMundo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Hola Mundo");
        // TODO code application logic here
        
        System.out.print("Introduzca un numero a");
        int a=sc.nextInt();
        System.out.print("Introduzca un numero b");
        int b=sc.nextInt();
        
        int c=a+b;
        
        System.out.println("La suma es");
        System.out.println(c);
        
        
    }
    
}
