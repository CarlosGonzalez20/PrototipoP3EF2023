/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Cuentas_Corrientes.Vista;

import Cuentas_Corrientes.Controlador.clsCCorrientesProv;
import Seguridad.Modelo.Conexion;
import java.io.File;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author halld
 */
public class frmReportesCCProveedores extends javax.swing.JInternalFrame {

    //REALIZADO POR : DANIEL ALEXANDER HALL ALVAREZ;9959-21-1395
    public void llenadoDeTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID CCorrientes");
        modelo.addColumn("Tipo de Cuenta");
        modelo.addColumn("ID Tipo Proveedor");
        modelo.addColumn("Fecha");
        modelo.addColumn("Nombre de Proveedor");
        modelo.addColumn("No. Factura");
        modelo.addColumn("Factura");
        modelo.addColumn("Cancelacion");
        modelo.addColumn("Saldo");
        clsCCorrientesProv aplicacion = new clsCCorrientesProv();
        List<clsCCorrientesProv> listaAplicaciones = aplicacion.getListadoCC();
        tablaUsuarios.setModel(modelo);
        String[] dato = new String[9];
        for (int i = 0; i < listaAplicaciones.size(); i++) {
            dato[0] = Integer.toString(listaAplicaciones.get(i).getIdCCorrienteProv());
            dato[1] = listaAplicaciones.get(i).getTipoCCorrienteProv();
            dato[2] = Integer.toString(listaAplicaciones.get(i).getIdTipoCCorrienteProv());
            dato[3] = listaAplicaciones.get(i).getFechaCCorrienteProv();
            dato[4] = listaAplicaciones.get(i).getNombreCCorrienteProv();
            dato[5] = listaAplicaciones.get(i).getNofacturaCCorrienteProv();
            dato[6] = Double.toString(listaAplicaciones.get(i).getFacturaCCorrienteProv());
            dato[7] = Double.toString(listaAplicaciones.get(i).getCancelacionProv());
            dato[8] = Double.toString(listaAplicaciones.get(i).getSaldoCCorrienteProv());
            modelo.addRow(dato);
        }   
    }
   
    /**
     * Creates new form frmReportesCCProveedores
     */
    public frmReportesCCProveedores() {
        initComponents();
        llenadoDeTabla();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        label1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Reporte CC Proveedores");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        tablaUsuarios.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Vendedor", "ID Empleado", "Correo", "Telefono", "Direccion", "Porcentaje", "Comision"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        label1.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        label1.setText("Cuentas Corrientes Proveedores");

        jButton1.setText("Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(label1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(371, 371, 371)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(label1)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          // REALIZADO POR : DANIEL ALEXANDER HALL ALVAREZ;9959-21-1395
        Connection conn = null;        
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;

        try {
            conn = Conexion.getConnection();
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/main/java/seguridad/reportes/ReporteProveedores.jrxml");
	    print = JasperFillManager.fillReport(report, p, conn);
            JasperViewer view = new JasperViewer(print, false);
	    view.setTitle("Reporte CC Proveedores");
            view.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
