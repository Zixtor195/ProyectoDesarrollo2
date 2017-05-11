/*
    Universidad del Valle
    Asignatura: Desarrollo de Software II 750092M
    Tema: Proyecto final - Entrega 3
    Archivo: GuiPrincipal.java
    Version: 1.0
    Fecha de creacion: 28 abril 2017
    Autores:   
                Monica Marcela Llano
                Sebastian Balante Salazar
                Cristian Camilo Jurado Arboleda
                Juan Felipe Orozco Escobar
    
    Responsabilidad: Interfaz principal Restaurante Lenos y Carbon
       
    Colaboracion: GuiModuloMenu, GuiModuloPersonal, GuiModuloPedidos
                    GuiModuloFacturasReportes, GuiModuloReportes
*/

package GuiPrincipal;

import GuiFacturasPagos.FacturasPagos;
import GuiModuloPersonal.Personal;
import GuiModuloMenu.Menu;
import GuiModuloPedidos.Pedidos;


public class GuiPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form GuisPrincipal
     */
    public GuiPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
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
        jbMenu = new javax.swing.JButton();
        jbPersonal = new javax.swing.JButton();
        jbPedidos = new javax.swing.JButton();
        jbReportes = new javax.swing.JButton();
        jbFacturasPagos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbMenu.setBackground(new java.awt.Color(255, 153, 51));
        jbMenu.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jbMenu.setText("IR");
        jbMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbMenuMouseClicked(evt);
            }
        });
        jPanelPrincipal.add(jbMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, 90, -1));

        jbPersonal.setBackground(new java.awt.Color(255, 153, 51));
        jbPersonal.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jbPersonal.setText("IR");
        jbPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPersonalMouseClicked(evt);
            }
        });
        jPanelPrincipal.add(jbPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 650, 90, -1));

        jbPedidos.setBackground(new java.awt.Color(255, 153, 51));
        jbPedidos.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jbPedidos.setText("IR");
        jbPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPedidosMouseClicked(evt);
            }
        });
        jPanelPrincipal.add(jbPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 650, 90, -1));

        jbReportes.setBackground(new java.awt.Color(255, 153, 51));
        jbReportes.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jbReportes.setText("IR");
        jbReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbReportesActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(jbReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 650, 90, -1));

        jbFacturasPagos.setBackground(new java.awt.Color(255, 153, 51));
        jbFacturasPagos.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jbFacturasPagos.setText("IR");
        jbFacturasPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFacturasPagosActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(jbFacturasPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 650, 90, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu.jpg"))); // NOI18N
        jPanelPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/personal.jpg"))); // NOI18N
        jPanelPrincipal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 540, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pedidos.jpg"))); // NOI18N
        jPanelPrincipal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 540, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reportes.jpg"))); // NOI18N
        jPanelPrincipal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 540, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/facuras y pagos.jpg"))); // NOI18N
        jPanelPrincipal.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 540, -1, -1));

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

        jButton6.setBackground(new java.awt.Color(255, 153, 51));
        jButton6.setText("IR");
        jPanelPrincipal.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 650, 90, -1));

        jbSalir.setBackground(new java.awt.Color(255, 102, 0));
        jbSalir.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jbSalir.setText("SALIR");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(jbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 686, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbReportesActionPerformed

    private void jbMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbMenuMouseClicked
        Menu menu = new Menu();
        menu.setVisible(true);
    }//GEN-LAST:event_jbMenuMouseClicked

    private void jbPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPersonalMouseClicked
        Personal personal = new Personal();
        personal.setVisible(true);
    }//GEN-LAST:event_jbPersonalMouseClicked

    private void jbPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPedidosMouseClicked
        Pedidos o = new Pedidos();
        o.setVisible(true);
    }//GEN-LAST:event_jbPedidosMouseClicked

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbFacturasPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFacturasPagosActionPerformed
       FacturasPagos o = new FacturasPagos();
       o.setVisible(true);
    }//GEN-LAST:event_jbFacturasPagosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JButton jbFacturasPagos;
    private javax.swing.JButton jbMenu;
    private javax.swing.JButton jbPedidos;
    private javax.swing.JButton jbPersonal;
    private javax.swing.JButton jbReportes;
    private javax.swing.JButton jbSalir;
    // End of variables declaration//GEN-END:variables
}
