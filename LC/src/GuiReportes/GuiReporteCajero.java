/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiReportes;


import GuiMenu.ContenedorFondo;
import Reportes.IngresosDia;
import Reportes.Reporte;
import Reportes.ReporteMasVendidos;
import Reportes.ReporteMenosVendidos;
import Reportes.ReporteSemanal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Moni
 */
public class GuiReporteCajero extends javax.swing.JFrame {

    ContenedorFondo contenedorPrincipalFondo;
    
    public GuiReporteCajero() {
        contenedorPrincipalFondo = new ContenedorFondo("src/imagenes/fondoInterfaces.jpg");
        super.setContentPane(contenedorPrincipalFondo);
        initComponents();
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
        jbMasVendidosTop10 = new javax.swing.JButton();
        jbMenosVendidosTop11 = new javax.swing.JButton();
        jbDineroCaja = new javax.swing.JButton();
        jbIngresosSemanales = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        jbDineroCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/descarga - copia.jpg"))); // NOI18N
        jbDineroCaja.setPreferredSize(new java.awt.Dimension(180, 230));
        jbDineroCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbDineroCajaMouseClicked(evt);
            }
        });

        jbIngresosSemanales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ingresos semana.jpg"))); // NOI18N
        jbIngresosSemanales.setPreferredSize(new java.awt.Dimension(180, 230));
        jbIngresosSemanales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbIngresosSemanalesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 356, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jlTituloReporteGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(347, 347, 347))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addComponent(jlTituloReporteTablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbDineroCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbMasVendidosTop10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(jbMenosVendidosTop11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60)
                        .addComponent(jbIngresosSemanales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbSalir1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlTituloReporteGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jbMenosVendidosTop11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbMasVendidosTop10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbIngresosSemanales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jlTituloReporteTablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jbDineroCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalir1ActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jbSalir1ActionPerformed

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

    private void jbDineroCajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbDineroCajaMouseClicked

        try {
           IngresosDia d = new IngresosDia();
           d.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GuiReporteCajero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbDineroCajaMouseClicked

    private void jbIngresosSemanalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbIngresosSemanalesMouseClicked

        try {
            ReporteSemanal rs = new ReporteSemanal();
            rs.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GuiReporteGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbIngresosSemanalesMouseClicked

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbDineroCaja;
    private javax.swing.JButton jbIngresosSemanales;
    private javax.swing.JButton jbMasVendidosTop10;
    private javax.swing.JButton jbMenosVendidosTop11;
    private javax.swing.JButton jbSalir1;
    private javax.swing.JLabel jlTituloReporteGrafico;
    private javax.swing.JLabel jlTituloReporteTablas;
    // End of variables declaration//GEN-END:variables
}
