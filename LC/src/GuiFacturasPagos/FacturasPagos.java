/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiFacturasPagos;

import ClasesTablas.Factura;
import ClasesTablas.Pedido;
import ControladorClasesTablas.FacturaJpaController;
import ControladorClasesTablas.PedidoJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Moni
 */
public class FacturasPagos extends javax.swing.JFrame {

    /**
     * Creates new form Personal
     */
    public FacturasPagos() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelModificar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.black);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/CrearFactura.jpg"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/consultarFactura.jpg"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        labelModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificarFactura.jpg"))); // NOI18N
        labelModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelModificarMouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminarFactura.jpg"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pagos.jpg"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(labelModificar)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(labelModificar)
                .addGap(46, 46, 46)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(25, 25, 25))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 968, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        FacturasPedidoFacturar rm = new FacturasPedidoFacturar();
        rm.setSize(752, 686);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        PedidoJpaController dao = new PedidoJpaController(emf);
        List<Pedido> Pedidos = dao.findPedidoEntities();
        
        for (int i = 0; i < Pedidos.size(); i++) {
            String estado = Pedidos.get(i).getEstado();
            if (estado.equalsIgnoreCase("Inactivo")||estado.equalsIgnoreCase("Facturado")){
                Pedidos.remove(i);
            }
        }
        
        Object fila[][]=new Object[Pedidos.size()][4];        
        for (int i = 0; i < Pedidos.size(); i++) {
            fila[i][0]=Pedidos.get(i).getIdPedido();
            fila[i][1]=Pedidos.get(i).getIdEmpleado().getNombres();            
            fila[i][2]=Pedidos.get(i).getHoraInicio();
            fila[i][3]=Pedidos.get(i).getTipo();
        }
        
        String columna[]=new String[]{"ID","Mesero","Hora","Tipo"};        
        emf.close();
        
        DefaultTableModel Modelo = new DefaultTableModel(fila,columna);
        rm.jTable1.setModel(Modelo);
        
        jPanel2.removeAll();
        jPanel2.revalidate();
        jPanel2.repaint();
        jPanel2.add(rm);
        
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        
        FacturasConsultar fc = new FacturasConsultar();
        fc.setSize(752, 686);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        FacturaJpaController dao = new FacturaJpaController(emf);
        List<Factura> Facturas = dao.findFacturaEntities();
        
        for (int i = 0; i < Facturas.size(); i++) {
            if (Facturas.get(i).getEstado().equalsIgnoreCase("Inactivo")){
                Facturas.remove(i);
            }
        }
        
        Object fila[][]=new Object[Facturas.size()][4];        
        for (int i = 0; i < Facturas.size(); i++) {
            fila[i][0]=Facturas.get(i).getIdFactura();
            fila[i][1]=Facturas.get(i).getEstado();            
            fila[i][2]=Facturas.get(i).getHoraPago();
            fila[i][3]=Facturas.get(i).getValorTotal();
        }
        
        String columna[]=new String[]{"N°Factura","Estado","Hora Pago","Total"};        
        emf.close();
        
        DefaultTableModel Modelo = new DefaultTableModel(fila,columna);
        fc.jTable1.setModel(Modelo);
        
        jPanel2.removeAll();
        jPanel2.revalidate();
        jPanel2.repaint();
        jPanel2.add(fc);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void labelModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelModificarMouseClicked
        FacturasModificar fm = new FacturasModificar();
        fm.setSize(752, 686);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        FacturaJpaController dao = new FacturaJpaController(emf);
        List<Factura> Facturas = dao.findFacturaEntities();
        
        for (int i = 0; i < Facturas.size(); i++) {
            if (Facturas.get(i).getEstado().equalsIgnoreCase("Inactivo")){
                Facturas.remove(i);
            }
        }
        
        Object fila[][]=new Object[Facturas.size()][4];        
        for (int i = 0; i < Facturas.size(); i++) {
            fila[i][0]=Facturas.get(i).getIdFactura();
            fila[i][1]=Facturas.get(i).getEstado();            
            fila[i][2]=Facturas.get(i).getHoraPago();
            fila[i][3]=Facturas.get(i).getValorTotal();
        }
        
        String columna[]=new String[]{"N°Factura","Estado","Hora Pago","Total"};        
        emf.close();
        
        DefaultTableModel Modelo = new DefaultTableModel(fila,columna);
        fm.jTable1.setModel(Modelo);
        
        jPanel2.removeAll();
        jPanel2.revalidate();
        jPanel2.repaint();
        jPanel2.add(fm);
    }//GEN-LAST:event_labelModificarMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
         FacturasEliminar fe = new FacturasEliminar();
        fe.setSize(752, 686);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        FacturaJpaController dao = new FacturaJpaController(emf);
        List<Factura> Facturas = dao.findFacturaEntities();
        
        for (int i = 0; i < Facturas.size(); i++) {
            if (Facturas.get(i).getEstado().equalsIgnoreCase("Inactivo")){
                Facturas.remove(i);
            }
        }
        
        Object fila[][]=new Object[Facturas.size()][4];        
        for (int i = 0; i < Facturas.size(); i++) {
            fila[i][0]=Facturas.get(i).getIdFactura();
            fila[i][1]=Facturas.get(i).getEstado();            
            fila[i][2]=Facturas.get(i).getHoraPago();
            fila[i][3]=Facturas.get(i).getValorTotal();
        }
        
        String columna[]=new String[]{"N°Factura","Estado","Hora Pago","Total"};        
        emf.close();
        
        DefaultTableModel Modelo = new DefaultTableModel(fila,columna);
        fe.jTable1.setModel(Modelo);
        
        jPanel2.removeAll();
        jPanel2.revalidate();
        jPanel2.repaint();
        jPanel2.add(fe);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        FacturasAPagar fm = new FacturasAPagar();
        fm.setSize(752, 686);
        
       /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        FacturaJpaController dao = new FacturaJpaController(emf);
        List<Factura> Facturas = dao.findFacturaEntities();
        
        Object fila[][]=new Object[Facturas.size()][4];        
        for (int i = 0; i < Facturas.size(); i++) {
            fila[i][0]=dao.findFacturaEntities().get(i).getIdFactura();
            fila[i][1]=dao.findFacturaEntities().get(i).getCedulaCliente();            
            fila[i][2]=dao.findFacturaEntities().get(i).getHoraPago();
            fila[i][3]=dao.findFacturaEntities().get(i).getValorTotal();
        }
        
        String columna[]=new String[]{"N°Factura","Cedula Cliente","Hora Pago","Total"};        
        emf.close();
        
        DefaultTableModel Modelo = new DefaultTableModel(fila,columna);
        fm.jTable1.setModel(Modelo);
        
       */ 
        jPanel2.removeAll();
        jPanel2.revalidate();
        jPanel2.repaint();
        jPanel2.add(fm);
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(FacturasPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturasPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturasPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturasPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturasPagos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelModificar;
    // End of variables declaration//GEN-END:variables
}
