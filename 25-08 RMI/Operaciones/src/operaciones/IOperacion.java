/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package operaciones;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Dell
 */
public interface IOperacion extends Remote{
    public int suma (int a, int b) throws RemoteException;;
    public int resta (int a, int b) throws RemoteException;;
    public int multiplicaion (int a, int b) throws RemoteException;;
    public int division (int a, int b) throws RemoteException;;
}
