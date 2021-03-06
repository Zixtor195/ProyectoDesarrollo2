/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistasUsuario;

import GuiModuloPedidos.Pedidos;
import GuiModuloPersonal.MeseroPersonal;
import GuiReportes.GuiReporteGerente;
import GuiReportes.GuiReporteMesero;

/**
 *
 * @author Sala
 */
public class GuiMesero extends javax.swing.JPanel {

    /**
     * Creates new form GuiCajero
     */
    int id;
    String cargo;
    public GuiMesero(int id, String cargo) {
        initComponents();
        this.id = id;
        this.cargo = cargo;
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
        jbPedidos = new javax.swing.JButton();
        jbReportes = new javax.swing.JButton();
        jlPersonal = new javax.swing.JLabel();
        jlPedidos = new javax.swing.JLabel();
        jlReportes = new javax.swing.JLabel();
        jlTituloLenosCarbon = new javax.swing.JLabel();
        jlFondoCentradoLenosCarbon = new javax.swing.JLabel();
        jpFondoTituloLenosCarbon = new javax.swing.JPanel();
        jbSalir1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(940, 699));

        jPanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPrincipal.setPreferredSize(new java.awt.Dimension(940, 719));
        jPanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbPersonal.setBackground(new java.awt.Color(153, 51, 0));
        jbPersonal.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jbPersonal.setText("IR");
        jbPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPersonalMouseClicked(evt);
            }
        });
        jPanelPrincipal.add(jbPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 650, 90, -1));

        jbPedidos.setBackground(new java.awt.Color(153, 51, 0));
        jbPedidos.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jbPedidos.setText("IR");
        jbPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPedidosMouseClicked(evt);
            }
        });
        jPanelPrincipal.add(jbPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 650, 90, -1));

        jbReportes.setBackground(new java.awt.Color(153, 51, 0));
        jbReportes.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jbReportes.setText("IR");
        jbReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbReportesMouseClicked(evt);
            }
        });
        jPanelPrincipal.add(jbReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 650, 90, -1));

        jlPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/personal.jpg"))); // NOI18N
        jPanelPrincipal.add(jlPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, -1, -1));

        jlPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pedidos.jpg"))); // NOI18N
        jPanelPrincipal.add(jlPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 530, -1, -1));

        jlReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reportes.jpg"))); // NOI18N
        jPanelPrincipal.add(jlReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 530, -1, -1));

        jlTituloLenosCarbon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.jpg"))); // NOI18N
        jPanelPrincipal.add(jlTituloLenosCarbon, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, -1, 120));

        jlFondoCentradoLenosCarbon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/banner.jpg"))); // NOI18N
        jPanelPrincipal.add(jlFondoCentradoLenosCarbon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, 400));

        jpFondoTituloLenosCarbon.setBackground(new java.awt.Color(92, 23, 23));

        javax.swing.GroupLayout jpFondoTituloLenosCarbonLayout = new javax.swing.GroupLayout(jpFondoTituloLenosCarbon);
        jpFondoTituloLenosCarbon.setLayout(jpFondoTituloLenosCarbonLayout);
        jpFondoTituloLenosCarbonLayout.setHorizontalGroup(
            jpFondoTituloLenosCarbonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        jpFondoTituloLenosCarbonLayout.setVerticalGroup(
            jpFondoTituloLenosCarbonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanelPrincipal.add(jpFondoTituloLenosCarbon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 940, 30));

        jbSalir1.setBackground(new java.awt.Color(255, 102, 0));
        jbSalir1.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jbSalir1.setText("SALIR");
        jbSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalir1ActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(jbSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPersonalMouseClicked
        MeseroPersonal mp = new MeseroPersonal(id);
        mp.setVisible(true);
    }//GEN-LAST:event_jbPersonalMouseClicked

    private void jbPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPedidosMouseClicked
        Pedidos pm = new Pedidos(id, cargo);
        pm.setVisible(true);
    }//GEN-LAST:event_jbPedidosMouseClicked

    private void jbSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalir1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbSalir1ActionPerformed

    private void jbReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbReportesMouseClicked
        GuiReporteMesero rm = new GuiReporteMesero();
        rm.setVisible(true);
    }//GEN-LAST:event_jbReportesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JButton jbPedidos;
    private javax.swing.JButton jbPersonal;
    private javax.swing.JButton jbReportes;
    private javax.swing.JButton jbSalir1;
    private javax.swing.JLabel jlFondoCentradoLenosCarbon;
    private javax.swing.JLabel jlPedidos;
    private javax.swing.JLabel jlPersonal;
    private javax.swing.JLabel jlReportes;
    private javax.swing.JLabel jlTituloLenosCarbon;
    private javax.swing.JPanel jpFondoTituloLenosCarbon;
    // End of variables declaration//GEN-END:variables
}
