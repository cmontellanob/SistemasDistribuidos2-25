/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package crudpersona;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Dell
 */
public interface IOperacionesBd extends Remote {
    
    public Respuesta insertar(Persona persona) throws RemoteException;
    public Respuesta actualizar(Persona persona) throws RemoteException;
    public Respuesta seleccionar(int id ) throws RemoteException;
    public Respuesta eliminar(int id) throws RemoteException;
    
    
    
    
}
