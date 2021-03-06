/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiFacturasPagos;

import ClasesTablas.Factura;
import ClasesTablas.ItemsDeFactura;
import ControladorClasesTablas.FacturaJpaController;
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
public class FacturasAPagar extends javax.swing.JPanel {

    /**
     * Creates new form FacturasModificar
     */
    public FacturasAPagar() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jcbFormaPago = new javax.swing.JComboBox<>();
        jlContinuar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

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
                "No.Factura", "Cedula Cliente", "Hora_pago", "Total"
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Forma de pago", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jcbFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Mixto", "Tarjeta" }));

        jlContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonContinuar.png"))); // NOI18N
        jlContinuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlContinuarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlContinuar)
                    .addComponent(jcbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlContinuar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlContinuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlContinuarMouseClicked
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        FacturaJpaController daof = new FacturaJpaController (emf);
        
        
        if (jcbFormaPago.getSelectedItem().toString().equalsIgnoreCase("Efectivo")
            ||jcbFormaPago.getSelectedItem().toString().equalsIgnoreCase("Tarjeta")) {
            PanelPagoEfectivo rm = new PanelPagoEfectivo();
            rm.setSize(800, 1000);
            
            int idFactura = Integer.parseInt(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(),0)));
            Factura factura = daof.findFactura(idFactura);
            
            Set<ItemsDeFactura> setItems = factura.getItemsDeFacturaSet();
            List<ItemsDeFactura> listItems = new ArrayList<>(setItems);
            
            Object fila[][]=new Object[listItems.size()][3];        
            for (int i = 0; i < listItems.size(); i++) {         
                fila[i][0]=listItems.get(i).getCantidad();
                fila[i][1]=listItems.get(i).getItemsDeFacturaPK().getNombre();
                fila[i][2]=listItems.get(i).getPrecio();                   
            }
            
            String columna[]=new String[]{"Cantidad","Producto","Precio"};        
            emf.close();
        
            DefaultTableModel Modelo = new DefaultTableModel(fila,columna);
            rm.jTable1.setModel(Modelo);            
            rm.jtfIDFactura.setText(String.valueOf(idFactura));
            rm.jtfTipoPago.setText(jcbFormaPago.getSelectedItem().toString());
            rm.jtfTotalPagar.setText(String.valueOf(factura.getValorTotal()));
            this.removeAll();
            this.revalidate();
            this.repaint();

            this.add(rm);

        } else {
            PanelPagoMixto rm = new PanelPagoMixto();
            rm.setSize(752, 1000);
            
            int idFactura = Integer.parseInt(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(),0)));
            Factura factura = daof.findFactura(idFactura);
            
            Set<ItemsDeFactura> setItems = factura.getItemsDeFacturaSet();
            List<ItemsDeFactura> listItems = new ArrayList<>(setItems);
            
            Object fila[][]=new Object[listItems.size()][3];        
            for (int i = 0; i < listItems.size(); i++) {         
                fila[i][0]=listItems.get(i).getCantidad();
                fila[i][1]=listItems.get(i).getItemsDeFacturaPK().getNombre();
                fila[i][2]=listItems.get(i).getPrecio();                   
            }
            
            String columna[]=new String[]{"Cantidad","Producto","Precio"};        
            emf.close();
        
            DefaultTableModel Modelo = new DefaultTableModel(fila,columna);
            rm.jTable1.setModel(Modelo); 
            rm.jtfTotalPagar.setText(String.valueOf(factura.getValorTotal()));
            rm.jtfCantidadRestante.setText(String.valueOf(factura.getValorTotal()));
            rm.jtfIDFactura.setText(String.valueOf(idFactura));
            this.removeAll();
            this.revalidate();
            this.repaint();

            this.add(rm);
        }
    }//GEN-LAST:event_jlContinuarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcbFormaPago;
    private javax.swing.JLabel jlContinuar;
    // End of variables declaration//GEN-END:variables
}
