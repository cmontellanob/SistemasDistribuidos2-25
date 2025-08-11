/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudpersonas;

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

    public void insertar(Persona persona) {
        String sql = "INSERT INTO personas(nombre,apellidos,edad,nro_carnet) VALUES (?,?,?,?) ";

        try {
            PreparedStatement instruccion = conexion.prepareStatement(sql);
            instruccion.setString(1, persona.getNombre());
            instruccion.setString(2, persona.getApellidos());
            instruccion.setInt(3, persona.getEdad());
            instruccion.setString(4, persona.getNumerocarnet());

            instruccion.execute();

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
          
        }

    }

    public List<Persona> listar() {
        List<Persona> auxiliar = new ArrayList<Persona>();

        String sql = "SELECT * FROM personas";

        try {
            Statement instruccion = conexion.createStatement();
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                Persona p = new Persona(resultado.getInt("id"), resultado.getString("nombre"),
                        resultado.getString("apellidos"), resultado.getInt("edad"), resultado.getString("nro_carnet"));
                auxiliar.add(p);
            }

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
          
        }
        return auxiliar;
    }

    public void editar(Persona persona) {
        String sql = "UPDATE personas SET nombres=?, apellidos=?, edad=?, nro_carnet=? WHERE id=?";
        try {
            PreparedStatement instruccion = conexion.prepareStatement(sql);
            instruccion.setString(1, persona.getNombre());
            instruccion.setString(2, persona.getApellidos());
            instruccion.setInt(3, persona.getEdad());
            instruccion.setString(4, persona.getNumerocarnet());
            instruccion.setInt(5, persona.getId());
            instruccion.executeUpdate();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
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
}
