/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GuiModuloPersonal;

import ClasesTablas.Empleado;
import ControladorClasesTablas.EmpleadoJpaController;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


public class PanelModificar extends javax.swing.JPanel {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
    EmpleadoJpaController ejc = new EmpleadoJpaController(emf);
    List<Empleado> listaempleado = ejc.findEmpleadoEntities();
    
    public PanelModificar() {
        initComponents();
        tabla.setModel(new tabelModel());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jlContinuar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setAutoscrolls(true);
        setOpaque(false);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellidos", "Tipo de Documento", "No.Identificacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        jlContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonContinuar.png"))); // NOI18N
        jlContinuar.setPreferredSize(new java.awt.Dimension(105, 28));
        jlContinuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlContinuarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(jlContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlContinuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlContinuarMouseClicked

        EmpleadoJpaController ejc = new EmpleadoJpaController(emf);
        //List<Empleado> listEmpelado = ejc.findEmpleadoEntities();
        Empleado empleado = null;
        
        if ((tabla.getSelectedRow() != -1) == true) {
            empleado = listaempleado.get(tabla.getSelectedRow());
            PanelRealizarModificacion rm = new PanelRealizarModificacion(empleado);
            rm.setSize(986,686);

            this.removeAll();
            this.revalidate();
            this.repaint();
            this.add(rm);
        } else {
            JOptionPane.showMessageDialog(null,"Por favor, seleccione el empleado a consultar");
        }
    }//GEN-LAST:event_jlContinuarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel jlContinuar;
    public javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

    
    private class tabelModel extends AbstractTableModel{
        
        @Override
        public int getRowCount() {
            
            for (int i = 0; i < listaempleado.size(); i++) {
                 
                if(!(listaempleado.get(i).getEstado().equalsIgnoreCase("Activo"))) {
                    listaempleado.remove(i);
                }
            }
            return listaempleado.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public String getColumnName(int column) {
            
            switch(column){
                case 0: return "Nombre"; 
                case 1: return "Apellido";
                case 2: return "Tipo Documento"; 
                case 3: return "No. Identificación";
            }
            return "";
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            
            Empleado empleado = listaempleado.get(rowIndex);
            
            switch(columnIndex){
                case 0: return empleado.getNombres(); 
                case 1: return empleado.getApellidos();
                case 2: return empleado.getTipoDocumento(); 
                case 3: return empleado.getIdEmpleado();
            }
            return "";
        }
    }
}
