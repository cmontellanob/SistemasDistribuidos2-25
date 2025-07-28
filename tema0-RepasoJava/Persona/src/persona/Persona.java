/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

/**
 *
 * @author Dell
 */
public class Persona {
    String nombres;
    String apellidos;
    String numeroDocumento;
    Sexo sexo;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Persona(String nombres, String apellidos, String numeroDocumento, Sexo sexo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numeroDocumento = numeroDocumento;
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return  "Nombres: " + nombres + ", Apellidos : " + apellidos + ", numero Documento :" + numeroDocumento + ", sexo: " + sexo + '}';
    }
    
    
    
}
