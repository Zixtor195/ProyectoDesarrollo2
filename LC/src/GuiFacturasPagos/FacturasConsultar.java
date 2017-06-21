/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiFacturasPagos;

import ClasesTablas.Factura;
import ClasesTablas.ItemsDeFactura;
import ClasesTablas.Pagos;
import ControladorClasesTablas.FacturaJpaController;
import Fachada.Fachada;
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
public class FacturasConsultar extends javax.swing.JPanel {

    /**
     * Creates new form FacturasModificar
     */
    public FacturasConsultar() {
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
        jlConsultar = new javax.swing.JLabel();

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
                "No.Factura", "Estado", "Hora_pago", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jlConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonConsultar.png"))); // NOI18N
        jlConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlConsultarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlConsultar)
                        .addGap(303, 303, 303))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlConsultar)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlConsultarMouseClicked
             
        FacturarResultadosConsulta rm = new FacturarResultadosConsulta();
        rm.setSize(752, 1000);  
                    
        int idFactura = Integer.parseInt(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(),0)));
        
        Fachada fachada = new Fachada();
        Factura factura = fachada.ConsultarFactura(idFactura);  
        
        Set<ItemsDeFactura> SetItems = factura.getItemsDeFacturaSet();  
        List<ItemsDeFactura> facturaDeItems = new ArrayList<>(SetItems);
                
        Object fila[][]=new Object[facturaDeItems.size()][3];        
        for (int i = 0; i < facturaDeItems.size(); i++) {         
            fila[i][0]=facturaDeItems.get(i).getCantidad();
            fila[i][1]=facturaDeItems.get(i).getItemsDeFacturaPK().getNombre();           
            fila[i][2]=facturaDeItems.get(i).getPrecio();                  
            }
        
        String columna[]=new String[]{"Cantidad","Producto","Precio"};        
       
        
        Set<Pagos> SetPagos = factura.getPagosSet();  
        List<Pagos> PagosFactura = new ArrayList<>(SetPagos);
        
        Object fila2[][]=new Object[PagosFactura.size()][4];        
        for (int i = 0; i < PagosFactura.size(); i++) {         
            fila2[i][0]=PagosFactura.get(i).getPagosPK().getIdPago();
            fila2[i][1]=PagosFactura.get(i).getTipo();           
            fila2[i][2]=PagosFactura.get(i).getValor();
            fila2[i][3]=PagosFactura.get(i).getCedulaCliente();
        }
        
        String columna2[] = new String[]{"Id","Tipo","Valor","Cedula Cliente"};        
        
        DefaultTableModel ModeloItems = new DefaultTableModel(fila,columna);
        DefaultTableModel ModeloPagos = new DefaultTableModel(fila2,columna2);
        rm.jTable1.setModel(ModeloItems);
        rm.jTable2.setModel(ModeloPagos);
        rm.jtfValorTotal.setText(String.valueOf(factura.getValorTotal()));
        rm.jtfNoFactura.setText(factura.getIdFactura().toString());                         
        
        this.removeAll();
        this.revalidate();
        this.repaint();
        
        this.add(rm);
    }//GEN-LAST:event_jlConsultarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JLabel jlConsultar;
    // End of variables declaration//GEN-END:variables
}
