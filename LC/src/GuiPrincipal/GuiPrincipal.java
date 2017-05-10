/*
    Universidad del Valle
    Asignatura: Desarrollo de Software II 750092M
    Tema: Entrega 4 proyecto
    Archivo: GuiPrincipal.java
    Version: 1.0
    Fecha de creacion: 25 abril 2017
    Autores:   
                Monica Marcela Llano
                Sebastian Balante Salazar
                Cristian Camilo Jurado Arboleda
                Juan Felipe Orozco Escobar               

    Responsabilidad: Interfaz principal Restaurante Lenos y Carbon

    Colaboracion: GuiModuloPersonal, GuiModuloPedidos, GuiModuloMenu
*/

package GuiPrincipal;

import GuiModuloPersonal.Personal;
import GuiModuloMenu.Menu;


public class GuiPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form GuisPrincipal
     */
    public GuiPrincipal() {
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

        jPanelPrincipal = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jButton1.setText("IR");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanelPrincipal.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, 90, -1));

        jButton2.setBackground(new java.awt.Color(255, 153, 51));
        jButton2.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jButton2.setText("IR");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanelPrincipal.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 650, 90, -1));

        jButton3.setBackground(new java.awt.Color(255, 153, 51));
        jButton3.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jButton3.setText("IR");
        jPanelPrincipal.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 650, 90, -1));

        jButton4.setBackground(new java.awt.Color(255, 153, 51));
        jButton4.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jButton4.setText("IR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 650, 90, -1));

        jButton5.setBackground(new java.awt.Color(255, 153, 51));
        jButton5.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jButton5.setText("IR");
        jPanelPrincipal.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 650, 90, -1));

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

        jButton7.setBackground(new java.awt.Color(102, 0, 0));
        jButton7.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jButton7.setText("SALIR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 850, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanelPrincipal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 940, 30));

        jButton6.setBackground(new java.awt.Color(255, 153, 51));
        jButton6.setText("IR");
        jPanelPrincipal.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 650, 90, -1));

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        Menu menu = new Menu();
        menu.setVisible(true);
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        Personal personal = new Personal();
        personal.setVisible(true);
    }//GEN-LAST:event_jButton2MouseClicked

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelPrincipal;
    // End of variables declaration//GEN-END:variables
}
