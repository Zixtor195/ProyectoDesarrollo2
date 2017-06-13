/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistasUsuario;

import GuiFacturasPagos.FacturasPagos;
import GuiModuloPersonal.CajeroPersonal;
import GuiModuloPersonal.GerentePersonal;
import GuiReportes.GuiReporte;

/**
 *
 * @author Sala
 */
public class GuiCajero extends javax.swing.JPanel {

    /**
     * Creates new form GuiMesero
     */
    
    int id_cajero = 0; 
    public GuiCajero(int id) {
        initComponents();
        this.id_cajero = id;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jbPersonal = new javax.swing.JButton();
        jbReportes = new javax.swing.JButton();
        jbFacturasPagos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jbSalir = new javax.swing.JButton();

        jPanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbPersonal.setBackground(new java.awt.Color(153, 51, 0));
        jbPersonal.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jbPersonal.setText("IR");
        jbPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPersonalMouseClicked(evt);
            }
        });
        jPanelPrincipal.add(jbPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 630, 90, -1));

        jbReportes.setBackground(new java.awt.Color(153, 51, 0));
        jbReportes.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jbReportes.setText("IR");
        jbReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbReportesActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(jbReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 630, 90, -1));

        jbFacturasPagos.setBackground(new java.awt.Color(153, 51, 0));
        jbFacturasPagos.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jbFacturasPagos.setText("IR");
        jbFacturasPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFacturasPagosActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(jbFacturasPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 630, 90, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/personal.jpg"))); // NOI18N
        jPanelPrincipal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reportes.jpg"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanelPrincipal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 510, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/facuras y pagos.jpg"))); // NOI18N
        jPanelPrincipal.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 510, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.jpg"))); // NOI18N
        jPanelPrincipal.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, -1, 120));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/banner.jpg"))); // NOI18N
        jPanelPrincipal.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, 400));

        jPanel1.setBackground(new java.awt.Color(92, 23, 23));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanelPrincipal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 940, 30));

        jbSalir.setBackground(new java.awt.Color(255, 102, 0));
        jbSalir.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jbSalir.setText("SALIR");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(jbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPersonalMouseClicked
        CajeroPersonal personal = new CajeroPersonal(id_cajero);
        personal.setVisible(true);
    }//GEN-LAST:event_jbPersonalMouseClicked

    private void jbReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReportesActionPerformed
          GuiReporte r = new GuiReporte();
          r.setVisible(true);
    }//GEN-LAST:event_jbReportesActionPerformed

    private void jbFacturasPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFacturasPagosActionPerformed
        FacturasPagos o = new FacturasPagos();
        o.setVisible(true);
    }//GEN-LAST:event_jbFacturasPagosActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
            
    }//GEN-LAST:event_jLabel4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JButton jbFacturasPagos;
    private javax.swing.JButton jbPersonal;
    private javax.swing.JButton jbReportes;
    private javax.swing.JButton jbSalir;
    // End of variables declaration//GEN-END:variables
}
