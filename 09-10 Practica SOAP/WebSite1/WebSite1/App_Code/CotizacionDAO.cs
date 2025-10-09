using System;
using System.Activities.Statements;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using MySql.Data.MySqlClient;

/// <summary>
/// Descripción breve de CotizacionDAO
/// </summary>
public class CotizacionDAO
{
    private MySqlConnection conexion;
    
    public CotizacionDAO(string connectionString = "Server=localhost;Database=bd_Cotizacion;User ID=root;Password=;SslMode=none;")

    {
        //
        // TODO: Agregar aquí la lógica del constructor
        //
        conexion = new MySqlConnection(connectionString);
    }
    public List<Cotizacion> obtenerCotizacion()

    { 
        List<Cotizacion> lista = new List<Cotizacion>();
        conexion.Open();

        string query = "SELECT fecha, cotizacion,cotizacion_oficial FROM Cotizacions";
        MySqlCommand comando = new MySqlCommand(query, conexion);
        MySqlDataReader reader = comando.ExecuteReader();

        while (reader.Read())
        {
            DateTime fecha = reader.GetDateTime("fecha");
            decimal cotizacion = reader.GetDecimal("cotizacion");
            decimal cotizacionOficial = reader.GetDecimal("cotizacion_oficial");
            lista.Add(new Cotizacion(fecha, cotizacion, cotizacionOficial));

        }
        conexion.Close();
        return lista;

    }
    public bool agregarCotizacion(Cotizacion cotizacion)
    {
        try
        conexion.Open();
        string query = "INSERT INTO Cotizacions (fecha, cotizacion, cotizacion_oficial) VALUES (@fecha, @cotizacion, @cotizacion_oficial)";
        MySqlCommand comando = new MySqlCommand(query, conexion);
        comando.Parameters.AddWithValue("@fecha", cotizacion.fecha);
        comando.Parameters.AddWithValue("@cotizacion", cotizacion.cotizacion);
        comando.Parameters.AddWithValue("@cotizacion_oficial", cotizacion.cotizacionOficial);
        comando.ExecuteNonQuery();
        conexion.Close();
        return true;
        Catch
        {
            return false;
        }
        }
    public void eliminarCotizacion(DateTime fecha)
    {
        conexion.Open();
        string query = "DELETE FROM Cotizacions WHERE fecha = @fecha";
        MySqlCommand comando = new MySqlCommand(query, conexion);
        comando.Parameters.AddWithValue("@fecha", fecha);
        comando.ExecuteNonQuery();
        conexion.Close();
    }

    public void actualizarCotizacion(Cotizacion Cotizacion)
    {
        conexion.Open();
        string query = "UPDATE Cotizacions SET cotizacion = @cotizacion, cotizacion_oficial = @cotizacion_oficial WHERE fecha = @fecha";
        MySqlCommand comando = new MySqlCommand(query, conexion);
        comando.Parameters.AddWithValue("@fecha", Cotizacion.fecha);
        comando.Parameters.AddWithValue("@cotizacion", Cotizacion.cotizacion);
        comando.Parameters.AddWithValue("@cotizacion_oficial", Cotizacion.cotizacionOficial);
        comando.ExecuteNonQuery();
        conexion.Close();
    }

    public Cotizacion obtenerCotizacionPorFecha(DateTime fecha)
    {
        conexion.Open();
        string query = "SELECT fecha, cotizacion, cotizacion_oficial FROM Cotizacions WHERE fecha = @fecha";
        MySqlCommand comando = new MySqlCommand(query, conexion);
        comando.Parameters.AddWithValue("@fecha", fecha);
        MySqlDataReader reader = comando.ExecuteReader();
        Cotizacion Cotizacion = null;
        if (reader.Read())
        {
            DateTime fechaObtenida = reader.GetDateTime("fecha");
            decimal cotizacion = reader.GetDecimal("cotizacion");
            decimal cotizacionOficial = reader.GetDecimal("cotizacion_oficial");
            Cotizacion = new Cotizacion(fechaObtenida, cotizacion, cotizacionOficial);
        }
        conexion.Close();
        return Cotizacion;
    }

}