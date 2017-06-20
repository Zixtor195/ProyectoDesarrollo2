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
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
import javax.swing.table.DefaultTableModel;


public class GerentePersonal extends javax.swing.JFrame {

    ContenedorFondo contenedorPrincipalFondo;
    /**
     * Creates new form Personal
     */
    
    public GerentePersonal() {
        contenedorPrincipalFondo = new ContenedorFondo("src/imagenes/fondoInterfaces.jpg");
        super.setContentPane(contenedorPrincipalFondo);
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
        jbRegistrarEmpleado = new javax.swing.JButton();
        jbModificarEmpleado = new javax.swing.JButton();
        jbConsultarEmpleado = new javax.swing.JButton();
        jbEliminarEmpleado = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setOpaque(false);

        jbRegistrarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Crearpersonal.jpg"))); // NOI18N
        jbRegistrarEmpleado.setPreferredSize(new java.awt.Dimension(150, 136));
        jbRegistrarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbRegistrarEmpleadoMouseClicked(evt);
            }
        });

        jbModificarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificarEmpleado.jpg"))); // NOI18N
        jbModificarEmpleado.setPreferredSize(new java.awt.Dimension(150, 136));
        jbModificarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbModificarEmpleadoMouseClicked(evt);
            }
        });

        jbConsultarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/consultarPersonal.jpg"))); // NOI18N
        jbConsultarEmpleado.setPreferredSize(new java.awt.Dimension(150, 136));
        jbConsultarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbConsultarEmpleadoMouseClicked(evt);
            }
        });

        jbEliminarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminarEmpleado.jpg"))); // NOI18N
        jbEliminarEmpleado.setPreferredSize(new java.awt.Dimension(150, 136));
        jbEliminarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEliminarEmpleadoMouseClicked(evt);
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
                        .addComponent(jbEliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbConsultarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbModificarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbRegistrarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jbRegistrarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbModificarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbConsultarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbEliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSalir)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(1017, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1017, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRegistrarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbRegistrarEmpleadoMouseClicked

        PanelRegistrarEmpleado re = new PanelRegistrarEmpleado();
        re.setSize(1302,986);

        jPanel2.removeAll();
        jPanel2.add(re);
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_jbRegistrarEmpleadoMouseClicked

    private void jbModificarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbModificarEmpleadoMouseClicked

        PanelModificar me = new PanelModificar();
        me.setSize(1009,686); 

        jPanel2.removeAll();
        jPanel2.add(me);
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_jbModificarEmpleadoMouseClicked

    private void jbConsultarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbConsultarEmpleadoMouseClicked

        PanelConsultar ce = new PanelConsultar();
        ce.setSize(1009,686);
        
        jPanel2.removeAll();
        jPanel2.add(ce);
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_jbConsultarEmpleadoMouseClicked

    private void jbEliminarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEliminarEmpleadoMouseClicked

        PanelEliminar Eemp = new PanelEliminar();
        Eemp.setSize(1009,686);
     
        jPanel2.removeAll();
        jPanel2.add(Eemp);
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_jbEliminarEmpleadoMouseClicked

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbConsultarEmpleado;
    private javax.swing.JButton jbEliminarEmpleado;
    private javax.swing.JButton jbModificarEmpleado;
    private javax.swing.JButton jbRegistrarEmpleado;
    private javax.swing.JButton jbSalir;
    // End of variables declaration//GEN-END:variables
}
