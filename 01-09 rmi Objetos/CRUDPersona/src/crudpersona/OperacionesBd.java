/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudpersona;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Dell
 */
public class OperacionesBd extends UnicastRemoteObject implements IOperacionesBd {

    private PersonaDAO personaDAO = new PersonaDAO("jdbc:mysql://localhost:3306/personas_bd", "root", "");

    public OperacionesBd() throws RemoteException {
        super();
    }

    @Override
    public Respuesta insertar(Persona persona) throws RemoteException {
        boolean exito = this.personaDAO.insertar(persona);
        String[] mensajes = new String[1];
        mensajes[0] = "Transaccion realizada correctamente";

        return new Respuesta(exito, mensajes, null);
    }

    @Override
    public Respuesta actualizar(Persona persona) throws RemoteException {
        boolean exito = this.personaDAO.editar(persona);
        String[] mensajes = new String[1];
        mensajes[0] = "Transac realizada correctamente";

        return new Respuesta(exito, mensajes, null); //nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Respuesta seleccionar(int id) throws RemoteException {
         Persona  = this.personaDAO.obtenerPersona(id);
        String[] mensajes = new String[1];
        mensajes[0] = "Transac realizada correctamente";

        return new Respuesta(exito, mensajes, null);
    }

    @Override
    public Respuesta eliminar(int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
