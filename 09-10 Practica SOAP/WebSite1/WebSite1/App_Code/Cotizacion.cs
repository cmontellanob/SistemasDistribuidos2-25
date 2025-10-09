using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Descripción breve de Clima
/// </summary>
public class Cotizacion
{
    public DateTime fecha;
    public decimal cotizacion;
    public decimal cotizacionOficial;
    public Cotizacion(DateTime fecha, decimal cotizacion, decimal cotizacionOficial)
    {
        this.fecha = fecha;
        this.cotizacion = cotizacion;
        this.cotizacionOficial = cotizacionOficial;
    }
    public Cotizacion()
    {

         
        //
        // TODO: Agregar aquí la lógica del constructor
        //
    }

}