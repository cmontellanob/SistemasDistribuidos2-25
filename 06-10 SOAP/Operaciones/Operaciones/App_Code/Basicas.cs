using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

/// <summary>
/// Descripción breve de Basicas
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
// [System.Web.Script.Services.ScriptService]
public class Basicas : System.Web.Services.WebService
{

    public Basicas()
    {

        //Elimine la marca de comentario de la línea siguiente si utiliza los componentes diseñados 
        //InitializeComponent(); 
    }

    [WebMethod]
    public int Sumar(int a, int b)
    {
        return a+b;
    }

    [WebMethod]
    public int Restar(int a, int b)
    {
        return a - b;
    }
    [WebMethod]
    public int Multiplicar(int a, int b)
    {
        return a * b;
    }
    [WebMethod]
    public int Division(int a, int b)
    {
        return a / b;
    }

}
