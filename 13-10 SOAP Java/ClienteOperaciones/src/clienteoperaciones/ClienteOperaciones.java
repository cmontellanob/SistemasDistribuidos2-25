/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clienteoperaciones;

/**
 *
 * @author Dell
 */
public class ClienteOperaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print(sumar_1(3,5));
    }

    private static int sumar(int a, int b) {
        servicios.Basicas service = new servicios.Basicas();
        servicios.BasicasSoap port = service.getBasicasSoap();
        return port.sumar(a, b);
    }

    private static int sumar_1(int a, int b) {
        servicios.Basicas service = new servicios.Basicas();
        servicios.BasicasSoap port = service.getBasicasSoap12();
        return port.sumar(a, b);
    }
    
}
