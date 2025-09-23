/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1examenparcial;

import java.io.Serializable;

/**
 *
 * @author Dell
 */
class Cuenta implements Serializable{
    Banco banco;
    String nrocuenta;
    String ci;
    String nombres;
    String apellidos;
    double saldo;

    public Cuenta(Banco banco, String nrocuenta, String ci, double saldo) {
        this.banco = banco;
        this.nrocuenta = nrocuenta;
        this.ci = ci;
        this.saldo = saldo;
    }

    public Cuenta(Banco banco, String nrocuenta, String ci, String nombres, String apellidos) {
        this.banco = banco;
        this.nrocuenta = nrocuenta;
        this.ci = ci;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "banco=" + banco + ", nrocuenta=" + nrocuenta + ", ci=" + ci + ", nombres=" + nombres + ", apellidos=" + apellidos + ", saldo=" + saldo + '}';
    }
    

    
}
