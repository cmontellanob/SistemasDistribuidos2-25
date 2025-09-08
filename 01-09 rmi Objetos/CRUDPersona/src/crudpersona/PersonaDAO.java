/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudpersona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class PersonaDAO {

    private Connection conexion;

    public PersonaDAO(String url, String usuario, String password) {
        try {
            this.conexion = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        
        }
    }

    public boolean insertar(Persona persona) {
        String sql = "INSERT INTO personas(nombres,apellidos,numero_documento,sexo) VALUES (?,?,?,?) ";
        boolean aux = false;
        try {
            PreparedStatement instruccion = conexion.prepareStatement(sql);
            instruccion.setString(1, persona.getNombres());
            instruccion.setString(2, persona.getApellidos());
            instruccion.setInt(3, persona.getNumero_documento());
            instruccion.setString(4,String.valueOf(persona.getSexo()));
            
            instruccion.execute();
            return true;

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
        return aux;
    }

    public List<Persona> listar() {
        List<Persona> auxiliar = new ArrayList<Persona>();

        String sql = "SELECT * FROM personas";

        try {
            Statement instruccion = conexion.createStatement();
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
//                Persona p = new Persona(resultado.getInt("id"), resultado.getString("nombre"),
//                        resultado.getString("apellidos"), resultado.getInt("edad"), resultado.getString("nro_carnet"));
                //auxiliar.add(p);
            }

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
          
        }
        return auxiliar;
    }

    public boolean editar(Persona persona) {
        String sql = "UPDATE personas SET nombres=?, apellidos=?, edad=?, numero_documento=? WHERE id=?";
        boolean aux = false;
        try {
            PreparedStatement instruccion = conexion.prepareStatement(sql);
            instruccion.setString(1, persona.getNombres());
            instruccion.setString(2, persona.getApellidos());
            instruccion.setString(3, String.valueOf(persona.getSexo()));
            instruccion.setInt(4, persona.getNumero_documento());
            instruccion.setInt(5, persona.getId());
            instruccion.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
        return aux;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM personas WHERE id=?";
        try {
            PreparedStatement instruccion = conexion.prepareStatement(sql);
            instruccion.setInt(1, id);
            instruccion.executeUpdate();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }
    public Persona obtenerPersona(int id) {
        String sql = "SELECT id, nombres, apellidos, sexo, numero_documento FROM personas WHERE id=?";
        try {
            PreparedStatement instruccion = conexion.prepareStatement(sql);
            instruccion.setInt(1, id);
            ResultSet resultado =  instruccion.executeQuery();
              Persona p = new Persona(resultado.getInt("id"), resultado.getString("nombres"),
                    resultado.getString("apellidos"),Sexo.valueOf(resultado.getString("sexo")),resultado.getInt("numero_documento"));

            return p;
            
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }
}
