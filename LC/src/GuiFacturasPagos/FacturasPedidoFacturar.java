/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiFacturasPagos;

import ClasesTablas.ItemPedido;
import ClasesTablas.Pedido;
import ControladorClasesTablas.ItemPedidoJpaController;
import ControladorClasesTablas.PedidoJpaController;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LLano
 */
public class FacturasPedidoFacturar extends javax.swing.JPanel {

    /**
     * Creates new form FacturasPedidoFacturar
     */
    public FacturasPedidoFacturar() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbFacturar = new javax.swing.JButton();

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
                "id", "Mesero", "Hora", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jbFacturar.setText("Facturar");
        jbFacturar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbFacturarMouseClicked(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbFacturar)
                        .addGap(334, 334, 334))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbFacturar)
                .addContainerGap(148, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbFacturarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbFacturarMouseClicked
        
        FacturarPedidos rm = new FacturarPedidos();
        rm.setSize(900, 1000); 
           
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        PedidoJpaController dao = new PedidoJpaController(emf);
        ItemPedidoJpaController daoi = new ItemPedidoJpaController(emf);
        int a = Integer.parseInt(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(),0)));
        Pedido pedido = dao.findPedido(a);
        int totalPrecio = 0;
        
        List<ItemPedido> Ip = daoi.findItemPedidoEntities();
        List<ItemPedido> PedidoItems = new ArrayList<ItemPedido>(); 
                
        for (int i = 0; i < Ip.size(); i++) {
            if (Ip.get(i).getPedido().getIdPedido() == a){                
            PedidoItems.add(Ip.get(i));
                    }
        }
        
        Object fila[][]=new Object[PedidoItems.size()][3];        
        for (int i = 0; i < PedidoItems.size(); i++) {         
            fila[i][0]=PedidoItems.get(i).getCantidad();
            fila[i][1]=PedidoItems.get(i).getItem().getNombre();           
            fila[i][2]=PedidoItems.get(i).getItem().getPrecio();
            
            totalPrecio = totalPrecio + (PedidoItems.get(i).getCantidad() * 
                                         PedidoItems.get(i).getItem().getPrecio());
            }

        int iva = (int) Math.round((totalPrecio*0.19));
        int total = iva + totalPrecio;
        
        String columna[]=new String[]{"Cantidad","Producto","Precio"};        
        emf.close();
        
        DefaultTableModel Modelo = new DefaultTableModel(fila,columna);
        rm.jTable1.setModel(Modelo);
        rm.jtfIVA.setText(String.valueOf(iva));
        rm.jtfTotal.setText(String.valueOf(totalPrecio));
        rm.jtfIDPedido.setText(String.valueOf(a));
        
        this.removeAll();
        this.revalidate();
        this.repaint();                 
        this.add(rm);
    }//GEN-LAST:event_jbFacturarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JButton jbFacturar;
    // End of variables declaration//GEN-END:variables
}
