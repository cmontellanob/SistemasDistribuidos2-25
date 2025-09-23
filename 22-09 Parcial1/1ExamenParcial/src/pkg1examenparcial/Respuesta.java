/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1examenparcial;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Respuesta implements Serializable{
     boolean error;
     String mensaje;
     ArrayList<Cuenta> cuentasencontradas ;

    public boolean isError() {
        return error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public ArrayList<Cuenta> getCuentasencontradas() {
        return cuentasencontradas;
    }

    public Respuesta(boolean error, String mensaje, ArrayList<Cuenta> cuentasencontradas) {
        this.error = error;
        this.mensaje = mensaje;
        this.cuentasencontradas = cuentasencontradas;
    }

}
