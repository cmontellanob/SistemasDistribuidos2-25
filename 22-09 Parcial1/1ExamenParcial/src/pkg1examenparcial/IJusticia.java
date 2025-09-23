/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pkg1examenparcial;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Dell
 */
public interface IJusticia extends Remote{
    public Respuesta ConsultarCuentas(String ci,String nombres,String apellidos) throws RemoteException;
}
