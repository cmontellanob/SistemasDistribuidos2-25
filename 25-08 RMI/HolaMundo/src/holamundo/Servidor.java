/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package holamundo;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;



/**
 *
 * @author Dell
 */
public class Servidor {
    
     public static void main(String[] args){
         {
             try {
                 Hola hola=new Hola();
                 LocateRegistry.createRegistry(1099); //levantar el servidor de registro;
                 Naming.bind("Hola",hola);
                 
             } catch (RemoteException ex) {
                 System.getLogger(Servidor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
             } catch (AlreadyBoundException ex) {
                 System.getLogger(Servidor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
             } catch (MalformedURLException ex) {
                 System.getLogger(Servidor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
             }
             
         }
         
        
    }
}
