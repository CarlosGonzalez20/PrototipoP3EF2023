/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exa.Controlador;
import Exa.Modelo.*;
import java.util.List;
import Seguridad.Modelo.daoAplicacion;
/**
 *
 * @author visitante
 */

public class clsPolideportivo {
    private int IdSede;
    private String NombreSede;
    private int CapacidadSede;

    public clsPolideportivo() {
    }

    public clsPolideportivo(int IdSede) {
        this.IdSede = IdSede;
    }

    public clsPolideportivo(int IdSede, String NombreSede) {
        this.IdSede = IdSede;
        this.NombreSede = NombreSede;
    }

    public clsPolideportivo(int IdSede, String NombreSede, int CapacidadSede) {
        this.IdSede = IdSede;
        this.NombreSede = NombreSede;
        this.CapacidadSede = CapacidadSede;
    }

    public int getIdSede() {
        return IdSede;
    }

    public void setIdSede(int IdSede) {
        this.IdSede = IdSede;
    }

    public String getNombreSede() {
        return NombreSede;
    }

    public void setNombreSede(String NombreSede) {
        this.NombreSede = NombreSede;
    }

    public int getCapacidadSede() {
        return CapacidadSede;
    }

    public void setCapacidadSede(int CapacidadSede) {
        this.CapacidadSede = CapacidadSede;
    }
  
    //Metodos de acceso a la capa controlador
    public clsPolideportivo getBuscarInformacionPoliPorNombre(clsPolideportivo poli)
    {
        daoPolideportivo daopolideportivo = new daoPolideportivo();
        return daopolideportivo.consultaPoliPorNombre(poli);
    }
    public clsPolideportivo getBuscarInformacionPoliPorId(clsPolideportivo poli)
    {
        daoPolideportivo daopoli = new daoPolideportivo();
        return daopoli.consultaPoliPorId(poli);
    }    
    public List<clsPolideportivo> getListadoSedes()
    {
        daoPolideportivo daopoli = new daoPolideportivo();
        List<clsPolideportivo> listadoSedes = daopoli.consultaSede();
        return listadoSedes;
    }
    public int setBorrarSede(clsPolideportivo poli)
    {
        daoPolideportivo daopoli = new daoPolideportivo();
        return daopoli.borrarSede(poli);
    }          
    public int setIngresarSede(clsPolideportivo poli)
    {
        daoPolideportivo daopoli = new daoPolideportivo();
        return daopoli.ingresaSede(poli);
    }              
    public int setModificarSede(clsPolideportivo poli)
    {
        daoPolideportivo daopoli = new daoPolideportivo();
        return daopoli.actualizaSede(poli);
    }              
}
