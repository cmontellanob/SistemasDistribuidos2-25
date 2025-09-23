/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pkg1examenparcial;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public interface IAsfi extends Remote {
    public ArrayList<Cuenta> ConsultarCuentas(String ci) throws RemoteException;

}
