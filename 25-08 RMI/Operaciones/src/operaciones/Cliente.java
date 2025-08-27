/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Cliente {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            IOperacion operacion;

            operacion = (IOperacion) Naming.lookup("rmi://localhost/Operaciones"); // instanciar un objeto 

            int op = 0;
            int a = 0;
            int b = 0;

            while (op != 5) {

                System.out.println("1.Sumar");
                System.out.println("2.Restar");
                System.out.println("3.Multiplicar");
                System.out.println("4.Dividir");
                System.out.println("5. Salir");
                System.out.print("Elegir una opcion");
                op = sc.nextInt();

                System.out.println("Introduir el primer valor:");
                a = sc.nextInt();
                System.out.println("Introducir segundo valor:");
                b = sc.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("La suma es:" + operacion.suma(a, b));
                        break;
                    case 2:
                        System.out.println("La resta es:" + operacion.resta(a, b));
                        break;
                    case 3:
                        System.out.println("La multiplicacion es:" + operacion.multiplicaion(a, b));
                        break;
                    case 4:
                        System.out.println("La division es:" + operacion.division(a, b));
                        break;

                }
            }

        } catch (NotBoundException ex) {
            System.getLogger(Cliente.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (MalformedURLException ex) {
            System.getLogger(Cliente.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (RemoteException ex) {
            System.getLogger(Cliente.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

}
