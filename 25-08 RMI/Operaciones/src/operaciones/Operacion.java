/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Dell
 */
public class Operacion extends UnicastRemoteObject implements IOperacion{

    public Operacion() throws RemoteException{
        super();
    }
    
    @Override
    public int suma(int a, int b) throws RemoteException {
        return(a + b);
    }

    @Override
    public int resta(int a, int b) throws RemoteException {
        return(a - b);
    }

    @Override
    public int multiplicaion(int a, int b) throws RemoteException {
        return(a * b);
    }

    @Override
    public int division(int a, int b) throws RemoteException {
        return a / b;
    }
    
}
