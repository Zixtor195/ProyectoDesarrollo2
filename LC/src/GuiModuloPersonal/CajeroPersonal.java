/*
    Universidad del Valle
    Asignatura: Desarrollo de Software II 750092M
    Tema: Proyecto final - Entrega 3
    Archivo: Personal.java
    Version: 1.0
    Fecha de creacion: 28 abril 2017
    Autores:   
                Monica Marcela Llano
                Sebastian Balante Salazar
                Cristian Camilo Jurado Arboleda
                Juan Felipe Orozco Escobar
    
    Responsabilidad: Interfaz Personal Restaurante Lenos y Carbon
       
    Colaboracion: PanelConsultar, PanelEliminar, PanelModificar, PanelResultadosConsulta
                    PanelRealizarModificacion, PanelRegistrarEmpleado
*/

package GuiModuloPersonal;

import ClasesTablas.Empleado;
import ControladorClasesTablas.EmpleadoJpaController;
import GuiMenu.ContenedorFondo;
import java.awt.Dimension;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
import javax.swing.table.DefaultTableModel;


public class CajeroPersonal extends javax.swing.JFrame {

    ContenedorFondo contenedorPrincipalFondo;
    /**
     * Creates new form Personal
     */
    
      int id_cajero = 0;
    public CajeroPersonal(int id) {
        contenedorPrincipalFondo = new ContenedorFondo("src/imagenes/fondoInterfaces.jpg");
        super.setContentPane(contenedorPrincipalFondo);
        initComponents();
        this.id_cajero = id;
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //setResizable(false);
    }

    private CajeroPersonal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbConsultarEmpleado = new javax.swing.JButton();
        jbModificarEmpleado = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1253, 679));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(236, 679));

        jbConsultarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/consultarPersonal.jpg"))); // NOI18N
        jbConsultarEmpleado.setPreferredSize(new java.awt.Dimension(150, 136));
        jbConsultarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbConsultarEmpleadoMouseClicked(evt);
            }
        });

        jbModificarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificarEmpleado.jpg"))); // NOI18N
        jbModificarEmpleado.setPreferredSize(new java.awt.Dimension(150, 136));
        jbModificarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbModificarEmpleadoMouseClicked(evt);
            }
        });

        jbSalir.setBackground(new java.awt.Color(153, 51, 0));
        jbSalir.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jbModificarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbConsultarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jbConsultarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jbModificarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(1017, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1011, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 679, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbConsultarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbConsultarEmpleadoMouseClicked

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        EmpleadoJpaController dao = new EmpleadoJpaController(emf);
        PanelResultadosConsulta rc = null;
        try {
            rc = new PanelResultadosConsulta(dao.findEmpleado(id_cajero));
        } catch (IOException ex) {
              Logger.getLogger(CajeroPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
        //rc.setSize(1100,720);
        rc.setSize(986,686);

        jPanel2.removeAll();
        jPanel2.add(rc);
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_jbConsultarEmpleadoMouseClicked

    private void jbModificarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbModificarEmpleadoMouseClicked

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        EmpleadoJpaController dao = new EmpleadoJpaController(emf);
        
        PanelRealizarModificacion rm = new PanelRealizarModificacion(dao.findEmpleado(id_cajero));
        //rm.setSize(1100,720);
        rm.setSize(986,686);

        jPanel2.removeAll();
        jPanel2.add(rm);
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_jbModificarEmpleadoMouseClicked

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbConsultarEmpleado;
    private javax.swing.JButton jbModificarEmpleado;
    private javax.swing.JButton jbSalir;
    // End of variables declaration//GEN-END:variables
}
