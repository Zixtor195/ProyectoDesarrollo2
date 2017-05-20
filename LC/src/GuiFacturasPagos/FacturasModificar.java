/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiFacturasPagos;

import ClasesTablas.Factura;
import ClasesTablas.ItemPedido;
import ClasesTablas.ItemsDeFactura;
import ClasesTablas.Pagos;
import ClasesTablas.Pedido;
import ControladorClasesTablas.FacturaJpaController;
import ControladorClasesTablas.ItemPedidoJpaController;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LLano
 */
public class FacturasModificar extends javax.swing.JPanel {

    /**
     * Creates new form FacturasModificar
     */
    public FacturasModificar() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
                "No.Factura", "Estado", "Hora_pago", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonmodificar.jpg"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(303, 303, 303))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        FacturasRealizarModificacion rm = new FacturasRealizarModificacion();
        rm.setSize(752, 1000);
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        FacturaJpaController daof = new FacturaJpaController(emf);        
        int a = Integer.parseInt(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(),0)));
        Factura factura = daof.findFactura(a);
        int Total = 0;
        
        Set<ItemsDeFactura> SetItems = factura.getItemsDeFacturaSet();  
        List<ItemsDeFactura> facturaDeItems = new ArrayList<>(SetItems);
                
        Object fila[][]=new Object[facturaDeItems.size()][3];        
        for (int i = 0; i < facturaDeItems.size(); i++) {         
            fila[i][0]=facturaDeItems.get(i).getCantidad();
            fila[i][1]=facturaDeItems.get(i).getItemsDeFacturaPK().getNombre();           
            fila[i][2]=facturaDeItems.get(i).getPrecio();
            Total = Total + (facturaDeItems.get(i).getCantidad() * 
                                facturaDeItems.get(i).getPrecio());
            }
        
        int iva = (int) Math.round((Total*0.19));
        int propina = factura.getValorTotal()-Total-iva;
        
        String columna[]=new String[]{"Cantidad","Producto","Precio"};                                  
        emf.close();                
        
        DefaultTableModel ModeloItems = new DefaultTableModel(fila,columna);
        rm.jTable1.setModel(ModeloItems);
        rm.jTextField2.setText(factura.getIdPedido().getIdPedido().toString());
        rm.jTextField1.setText(String.valueOf(Total));
        rm.jTextField3.setText(factura.getIdFactura().toString());  
        rm.jTextField6.setText(factura.getHoraPago()); 
        rm.jTextField7.setText(String.valueOf(iva));
        rm.jTextField4.setText(String.valueOf(propina));
        
        this.removeAll();
        this.revalidate();
        this.repaint();           
        this.add(rm);
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
