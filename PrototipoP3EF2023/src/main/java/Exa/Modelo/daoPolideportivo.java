/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exa.Modelo;

import Exa.Modelo.*;
import Exa.Controlador.clsPolideportivo;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoPolideportivo {

    private static final String SQL_SELECT = "SELECT ID_SEDE, NOMBRE_SEDE, CAPACIDAD FROM sede_polideportivo";
    private static final String SQL_INSERT = "INSERT INTO sede_polideportivo(ID_SEDE, NOMBRE_SEDE, CAPACIDAD) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE sede_polideportivo SET NOMBRE_SEDE=?, CAPACIDAD=? WHERE ID_SEDE = ?";
    private static final String SQL_DELETE = "DELETE FROM sede_polideportivo WHERE ID_SEDE=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT ID_SEDE, NOMBRE_SEDE, CAPACIDAD FROM sede_polideportivo WHERE NOMBRE_SEDE = ?";
    private static final String SQL_SELECT_ID = "SELECT ID_SEDE, NOMBRE_SEDE, CAPACIDAD FROM sede_polideportivo WHERE ID_SEDE = ?";    

    public List<clsPolideportivo> consultaSede() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsPolideportivo> poli = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_SEDE");
                String nombre = rs.getString("NOMBRE_SEDE");
                int cap = rs.getInt("CAPACIDAD");
                clsPolideportivo polidep = new clsPolideportivo();
                polidep.setIdSede(id);
                polidep.setNombreSede(nombre);
                polidep.setCapacidadSede(cap);
                poli.add(polidep);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return poli;
    }

    public int ingresaSede(clsPolideportivo poli) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, poli.getNombreSede());
            stmt.setInt(2, poli.getCapacidadSede());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaSede(clsPolideportivo poli) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, poli.getNombreSede());
            stmt.setInt(2, poli.getCapacidadSede());
            stmt.setInt(3, poli.getIdSede());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarSede(clsPolideportivo poli) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, poli.getIdSede());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsPolideportivo consultaPoliPorNombre(clsPolideportivo poli) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + poli);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, poli.getNombreSede());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_SEDE");
                String nombre = rs.getString("NOMBRE_SEDE");
                int cap = rs.getInt("CAPACIDAD");

                //aplicacion = new clsAplicacion();
                poli.setIdSede(id);
                poli.setNombreSede(nombre);
                poli.setCapacidadSede(cap);
                System.out.println(" registro consultado: " + poli);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return poli;
    }
    public clsPolideportivo consultaPoliPorId(clsPolideportivo poli) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + poli);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, poli.getIdSede());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_SEDE");
                String nombre = rs.getString("NOMBRE_SEDE");
                int cap = rs.getInt("CAPACIDAD");

                //aplicacion = new clsAplicacion();
                poli.setIdSede(id);
                poli.setNombreSede(nombre);
                poli.setCapacidadSede(cap);
                System.out.println(" registro consultado: " + poli);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return poli;
    }    
}
