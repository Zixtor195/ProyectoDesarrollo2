/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiModuloPersonal;

import ClasesTablas.Empleado;
import ControladorClasesTablas.EmpleadoJpaController;
import ControladorClasesTablas.exceptions.IllegalOrphanException;
import ControladorClasesTablas.exceptions.NonexistentEntityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Moni
 */
public class PanelEliminar extends javax.swing.JPanel {

    /**
     * Creates new form JPanellModificar
     */
    public PanelEliminar() {
        initComponents();
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
        jtEliminar = new javax.swing.JTable();
        jlEliminar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setAutoscrolls(true);

        jtEliminar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtEliminar);

        jlEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botoneliminar.jpg"))); // NOI18N
        jlEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlEliminarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlEliminar)
                        .addGap(378, 378, 378))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jlEliminar)
                .addGap(36, 36, 36))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarMouseClicked
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        EmpleadoJpaController dao = new EmpleadoJpaController(emf);
        int a = Integer.parseInt(String.valueOf(jtEliminar.getValueAt(jtEliminar.getSelectedRow(),3)));
        
        Empleado persona = dao.findEmpleado(a);
        try {
            dao.destroy(persona.getIdEmpleado());
            JOptionPane.showMessageDialog(null, "Empleado eliminado exitosamente.");
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(PanelEliminar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PanelEliminar.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            emf.close();
        }
    }//GEN-LAST:event_jlEliminarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlEliminar;
    public javax.swing.JTable jtEliminar;
    // End of variables declaration//GEN-END:variables
}
