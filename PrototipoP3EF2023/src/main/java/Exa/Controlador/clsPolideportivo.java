/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exa.Controlador;
import Seguridad.Controlador.*;
import java.util.List;
import Seguridad.Modelo.daoAplicacion;
/**
 *
 * @author visitante
 */

public class clsPolideportivo {
    private int IdAplicacion;
    private String NombreAplicacion;
    private String EstatusAplicacion;
    

    public int getIdAplicacion() {
        return IdAplicacion;
    }

    public void setIdAplicacion(int IdAplicacion) {
        this.IdAplicacion = IdAplicacion;
    }

    public String getNombreAplicacion() {
        return NombreAplicacion;
    }

    public void setNombreAplicacion(String NombreAplicacion) {
        this.NombreAplicacion = NombreAplicacion;
    }

    public String getEstatusAplicacion() {
        return EstatusAplicacion;
    }

    public void setEstatusAplicacion(String EstatusAplicacion) {
        this.EstatusAplicacion = EstatusAplicacion;
    }

    public clsPolideportivo(int IdAplicacion, String NombreAplicacion, String EstatusAplicacion) {
        this.IdAplicacion = IdAplicacion;
        this.NombreAplicacion = NombreAplicacion;
        this.EstatusAplicacion = EstatusAplicacion;
    }

    public clsPolideportivo(int IdAplicacion, String NombreAplicacion) {
        this.IdAplicacion = IdAplicacion;
        this.NombreAplicacion = NombreAplicacion;
    }

    public clsPolideportivo(int IdAplicacion) {
        this.IdAplicacion = IdAplicacion;
    }

    public clsPolideportivo() {
    }
    //Metodos de acceso a la capa controlador
    public clsPolideportivo getBuscarInformacionAplicacionPorNombre(clsPolideportivo aplicacion)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.consultaAplicacionPorNombre(aplicacion);
    }
    public clsPolideportivo getBuscarInformacionAplicacionPorId(clsPolideportivo aplicacion)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.consultaAplicacionPorId(aplicacion);
    }    
    public List<clsPolideportivo> getListadoAplicaciones()
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        List<clsPolideportivo> listadoUsuarios = daoAplicacion.consultaAplicacion();
        return listadoUsuarios;
    }
    public int setBorrarAplicacion(clsPolideportivo aplicacion)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.borrarAplicacion(aplicacion);
    }          
    public int setIngresarAplicacion(clsPolideportivo aplicacion)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.ingresaAplicacion(aplicacion);
    }              
    public int setModificarAplicacion(clsPolideportivo aplicacion)
    {
        daoAplicacion daoAplicacion = new daoAplicacion();
        return daoAplicacion.actualizaAplicacion(aplicacion);
    }              
}
