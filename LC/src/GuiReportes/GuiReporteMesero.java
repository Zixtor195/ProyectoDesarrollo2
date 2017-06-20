/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiReportes;


import GuiMenu.ContenedorFondo;
import Reportes.MeserosMes;
import Reportes.Reporte;
import Reportes.ReporteMasVendidos;
import Reportes.ReporteMenosVendidos;
import Reportes.ReportePromedioAtencion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Moni
 */
public class GuiReporteMesero extends javax.swing.JFrame {

    ContenedorFondo contenedorPrincipalFondo;
    
    public GuiReporteMesero() {
        contenedorPrincipalFondo = new ContenedorFondo("src/imagenes/fondoInterfaces.jpg");
        super.setContentPane(contenedorPrincipalFondo);
        initComponents();
        this.setLocationRelativeTo(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    Reporte r = new Reporte();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlTituloReporteGrafico = new javax.swing.JLabel();
        jlTituloReporteTablas = new javax.swing.JLabel();
        jbSalir1 = new javax.swing.JButton();
        jbTiempoPromedioPedidos = new javax.swing.JButton();
        jbMeseroDelMes = new javax.swing.JButton();
        jbMasVendidosTop10 = new javax.swing.JButton();
        jbMenosVendidosTop11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(7, 7));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        jlTituloReporteGrafico.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlTituloReporteGrafico.setText("<html><u>Reportes Periodicos Tipo Grafico:</html></u>");

        jlTituloReporteTablas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlTituloReporteTablas.setText("<html><u>Reportes Graficos Tipo Tabla:</html></u>");

        jbSalir1.setBackground(new java.awt.Color(153, 51, 0));
        jbSalir1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jbSalir1.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir1.setText("Salir");
        jbSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalir1ActionPerformed(evt);
            }
        });

        jbTiempoPromedioPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tiempoPedido.jpg"))); // NOI18N
        jbTiempoPromedioPedidos.setPreferredSize(new java.awt.Dimension(180, 230));
        jbTiempoPromedioPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbTiempoPromedioPedidosMouseClicked(evt);
            }
        });

        jbMeseroDelMes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/descarga.jpg"))); // NOI18N
        jbMeseroDelMes.setPreferredSize(new java.awt.Dimension(180, 230));
        jbMeseroDelMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbMeseroDelMesMouseClicked(evt);
            }
        });

        jbMasVendidosTop10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mas vendidos.jpg"))); // NOI18N
        jbMasVendidosTop10.setPreferredSize(new java.awt.Dimension(180, 230));
        jbMasVendidosTop10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbMasVendidosTop10MouseClicked(evt);
            }
        });

        jbMenosVendidosTop11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menos vendidos.jpg"))); // NOI18N
        jbMenosVendidosTop11.setPreferredSize(new java.awt.Dimension(180, 230));
        jbMenosVendidosTop11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbMenosVendidosTop11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlTituloReporteGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(347, 347, 347))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addComponent(jlTituloReporteTablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbMeseroDelMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbMasVendidosTop10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(jbMenosVendidosTop11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60)
                        .addComponent(jbTiempoPromedioPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbSalir1)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlTituloReporteGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jbMenosVendidosTop11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbMasVendidosTop10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbTiempoPromedioPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jlTituloReporteTablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jbMeseroDelMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalir1ActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jbSalir1ActionPerformed

    private void jbTiempoPromedioPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbTiempoPromedioPedidosMouseClicked

        try {
            ReportePromedioAtencion rpa = new ReportePromedioAtencion();
            rpa.setVisible(true);
            } catch (SQLException ex) {
            Logger.getLogger(GuiReporteGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbTiempoPromedioPedidosMouseClicked

    private void jbMeseroDelMesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbMeseroDelMesMouseClicked

        try {
            MeserosMes m = new MeserosMes();
            m.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GuiReporteMesero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbMeseroDelMesMouseClicked

    private void jbMasVendidosTop10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbMasVendidosTop10MouseClicked

        try {
            ReporteMasVendidos r = new ReporteMasVendidos();
            r.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GuiReporteGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbMasVendidosTop10MouseClicked

    private void jbMenosVendidosTop11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbMenosVendidosTop11MouseClicked

        try {
            ReporteMenosVendidos r = new ReporteMenosVendidos();
            r.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GuiReporteGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbMenosVendidosTop11MouseClicked

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbMasVendidosTop10;
    private javax.swing.JButton jbMenosVendidosTop11;
    private javax.swing.JButton jbMeseroDelMes;
    private javax.swing.JButton jbSalir1;
    private javax.swing.JButton jbTiempoPromedioPedidos;
    private javax.swing.JLabel jlTituloReporteGrafico;
    private javax.swing.JLabel jlTituloReporteTablas;
    // End of variables declaration//GEN-END:variables
}
