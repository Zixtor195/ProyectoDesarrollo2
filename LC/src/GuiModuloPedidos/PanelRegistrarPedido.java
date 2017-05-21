/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiModuloPedidos;

import ClasesTablas.Empleado;
import ClasesTablas.Factura;
import ClasesTablas.Item;
import ClasesTablas.ItemPedido;
import ClasesTablas.Pedido;
import ControladorClasesTablas.EmpleadoJpaController;
import ControladorClasesTablas.FacturaJpaController;
import ControladorClasesTablas.ItemJpaController;
import ControladorClasesTablas.ItemPedidoJpaController;
import ControladorClasesTablas.PedidoJpaController;
import ControladorClasesTablas.exceptions.IllegalOrphanException;
import ControladorClasesTablas.exceptions.NonexistentEntityException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.EventListenerList;
import javax.swing.event.ListDataListener;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author Sebas
 */
public final class PanelRegistrarPedido extends javax.swing.JPanel {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
    Pedido pedido = new Pedido();
    
    public PanelRegistrarPedido() {
        initComponents();
        
        listitemp.setModel(new listaItemsModel());
        cbo_mesero.setModel(listadoMeserosModel());
        cbo_tipo.setModel(listadoTipoPedidoModel());
        btnagregarapedido.addActionListener(new agregar());
        btnaceptarpedido.addActionListener(new aceptarPedido());
        btnanular.addActionListener(new anular());
        btncancelar.addActionListener(new quitar());
        numeroRegistros();
        crearPedidoBd();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cbo_mesero = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        btnaceptarpedido = new javax.swing.JButton();
        btnanular = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listitemp = new javax.swing.JList();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtmesa = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btncancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        cbo_tipo = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        btnagregarapedido = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/comidas.jpg"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bebidas.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/postres.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbo_mesero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Mesero:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(cbo_mesero, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_mesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnaceptarpedido.setBackground(new java.awt.Color(153, 153, 255));
        btnaceptarpedido.setText("Aceptar Pedido");

        btnanular.setBackground(new java.awt.Color(255, 255, 51));
        btnanular.setText("Anular");

        listitemp.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listitemp);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("No. Mesa");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(txtmesa, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmesa, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Cantidad", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table);

        btncancelar.setText("Cancelar Producto");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setText("Detalles del Pedido");
        jLabel6.setToolTipText("");

        jLabel7.setText("Cantidad:");

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbo_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Tipo:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbo_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        txtcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadActionPerformed(evt);
            }
        });

        btnagregarapedido.setText("Adicionar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(btnagregarapedido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btncancelar))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnaceptarpedido)
                        .addGap(41, 41, 41)
                        .addComponent(btnanular)
                        .addGap(407, 407, 407)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcantidad)
                            .addComponent(btnagregarapedido)
                            .addComponent(btncancelar))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnaceptarpedido)
                    .addComponent(btnanular))
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaceptarpedido;
    private javax.swing.JButton btnagregarapedido;
    private javax.swing.JButton btnanular;
    private javax.swing.JButton btncancelar;
    private javax.swing.JComboBox cbo_mesero;
    private javax.swing.JComboBox cbo_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listitemp;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtmesa;
    // End of variables declaration//GEN-END:variables

    
    
    private class agregar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            //controlador item
            ItemJpaController ijc = new ItemJpaController(emf);
            List<Item> listaitem = ijc.findItemEntities();
            
            //controlador itempedido
            ItemPedidoJpaController tjc = new ItemPedidoJpaController(emf);
            ItemPedido ip = new ItemPedido();
            List<ItemPedido> listaitempedido = tjc.findItemPedidoEntities();

            if(!txtcantidad.getText().trim().equals("")&&!listitemp.isSelectionEmpty()&&!txtmesa.getText().trim().equals("")){
                ip.setCantidad(Integer.parseInt(txtcantidad.getText()));
                ip.setItem(listaitem.get(listitemp.getSelectedIndex()));
                ip.setPedido(pedido);
                try {
                    tjc.create(ip);
                    table.setModel(new tableModel());
                } catch (Exception ex) {
                    Logger.getLogger(PanelRegistrarPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Llene los campos requeridos");
            }
        }
    }
    
    public class aceptarPedido implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            crearLocalPedido();
            PedidoJpaController pjc = new PedidoJpaController(emf);
            ItemPedidoJpaController tjc = new ItemPedidoJpaController(emf);
            List<ItemPedido> listaitempedido = tjc.findItemPedidoEntities();
            pedido.setHoraUltimoItem(getHora());
            
            if(!listaitempedido.isEmpty()){
                for (ItemPedido itemp : listaitempedido) {
                    if(itemp.getPedido().getIdPedido().intValue() == pedido.getIdPedido().intValue()){
                        pedido.getItemPedidoSet().add(itemp);
                    }
                }
            }
            try {
                pjc.edit(pedido);
                JOptionPane.showMessageDialog(null, "Pedido realizado");
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(null, "No se pudo realizar el pedido");
            }
            
        }
    }
    
    private class quitar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            //controlador itempedido
            ItemPedidoJpaController tjc = new ItemPedidoJpaController(emf);
            ItemPedido ip = new ItemPedido();
            List<ItemPedido> listaitempedido = tjc.findItemPedidoEntities();
            
            if(table.getSelectedRow() != -1){
               ip = listaitempedido.get(table.getSelectedRow());
               
                try {
                    tjc.destroy(ip.getItemPedidoPK());
                    table.setModel(new tableModel());
                    
                } catch (Exception ex) {
                    Logger.getLogger(PanelRegistrarPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Seleccione un plato de su lista de pedidos");
            }
        }
    }
    
    public class anular implements ActionListener{
        PedidoJpaController pjc = new PedidoJpaController(emf);
        
        @Override
        public void actionPerformed(ActionEvent e) {
            cbo_mesero.setSelectedIndex(0);
            cbo_tipo.setSelectedIndex(0);
            txtcantidad.setText("");
            txtmesa.setText("");
            
            PedidoJpaController pjc = new PedidoJpaController(emf);
            ItemPedidoJpaController ijc = new ItemPedidoJpaController(emf);
            FacturaJpaController fjc = new FacturaJpaController(emf);
            
            List<Pedido> listapedido = pjc.findPedidoEntities();   
            List<ItemPedido> listapedidos = ijc.findItemPedidoEntities();
            List<Factura> listafactura = fjc.findFacturaEntities();
                
                for(ItemPedido item : listapedidos){
                    if(item.getPedido().getIdPedido().intValue() == pedido.getIdPedido().intValue()){
                        try {
                            ijc.destroy(item.getItemPedidoPK());
                        } catch (NonexistentEntityException ex) {
                            Logger.getLogger(PanelEliminarPedido.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
                for(Factura fact : listafactura){
                    if(fact.getIdPedido().equals(pedido)){
                        try {
                            fjc.destroy(fact.getIdFactura());
                        } catch (NonexistentEntityException ex) {
                            Logger.getLogger(PanelEliminarPedido.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalOrphanException ex) {
                            Logger.getLogger(PanelRegistrarPedido.class.getName()).log(Level.SEVERE, null, ex);
                        }
 
                    }
                }
            try {
                pjc.destroy(pedido.getIdPedido());
            } catch (IllegalOrphanException ex) {
                Logger.getLogger(PanelRegistrarPedido.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(PanelRegistrarPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }   
    }
    
    public void numeroRegistros(){
        PedidoJpaController pjc = new PedidoJpaController(emf);
        if(!pjc.findPedidoEntities().isEmpty()){
            pedido.setIdPedido(pjc.findPedidoEntities().get(pjc.findPedidoEntities().size()-1).getIdPedido());
        }
    }
    
    public void crearLocalPedido(){
        
        pedido.setIdEmpleado(getEmpleadoPedido());
        pedido.setTipo(cbo_tipo.getSelectedItem().toString());
        pedido.setNumMesa(Integer.parseInt(txtmesa.getText()));
        
    }
    
    public void crearPedidoBd(){
       
        PedidoJpaController pjc = new PedidoJpaController(emf);
        pedido.setIdPedidoAumentado();
        //System.out.println(pedido.getIdPedido());
        pedido.setHoraInicio(getHora());
        pedido.setTipo(cbo_tipo.getSelectedItem().toString());
        pedido.setEstado("Activo");
        pedido.setIdEmpleado(getEmpleadoPedido());
        try {
            pjc.create(pedido);
        } catch (Exception ex) {
            Logger.getLogger(PanelRegistrarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public LinkedList<ItemPedido> listaItempedido(){
        
        ItemPedidoJpaController ijc = new ItemPedidoJpaController(emf);
        List<ItemPedido> listaip = ijc.findItemPedidoEntities();
        LinkedList<ItemPedido> lista = new LinkedList<>();
        
        for(ItemPedido itemPedido : listaip) {
            
            if(itemPedido.getPedido().getIdPedido().intValue()== pedido.getIdPedido().intValue()){
                lista.add(itemPedido);
            }
        }
        return lista;
    }
    
    public Empleado getEmpleadoPedido(){
        Empleado empleado = null;
        EmpleadoJpaController ejc = new EmpleadoJpaController(emf);
        List<Empleado> listaEmpleado = ejc.findEmpleadoEntities();
        
        empleado = listaEmpleado.get(cbo_mesero.getSelectedIndex());
        System.out.println(cbo_mesero.getSelectedIndex());
        
        return empleado;
    }
    
    public String getHora() {
        
        Date hora = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        return sdf.format(hora);
    }
    
    private class listaItemsModel extends AbstractListModel {
        
        ItemJpaController ijc = new ItemJpaController(emf);       
        List<Item> listaItem = ijc.findItemEntities();
        
        @Override
        public int getSize() {
            return listaItem.size();
        }

        @Override
        public Object getElementAt(int index) {
            return listaItem.get(index).getNombre();
        }
        
    }
    
    private DefaultComboBoxModel listadoMeserosModel(){

        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        EmpleadoJpaController ejc = new EmpleadoJpaController(emf);
        List<Empleado> listaEmpleados = ejc.findEmpleadoEntities();       
        
        for(Empleado emp : listaEmpleados){
          combo.addElement(emp.getNombres());
        }
        return combo;
    }
    
    private DefaultComboBoxModel listadoTipoPedidoModel(){

        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        String[] opciones = {"Pedido Mesa", "Pedido Llevar"};
        for(int i=0;i<opciones.length;i++){
          combo.addElement(opciones[i]);
        }
        return combo;
    }
    
    private class tableModel extends AbstractTableModel{
        
        //ItemPedidoJpaController tjc = new ItemPedidoJpaController(emf);

        List<ItemPedido> listItems = listaItempedido();
        
        
        @Override
        public int getRowCount() {
            if(listItems.isEmpty()){
                return 0;
            }else{
                return listItems.size();
            }
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public String getColumnName(int column) {
            switch(column){
                case 0: return "Nombre"; 
                case 1: return "Cantidad";
                case 2: return "Precio";
            }
            return "";
        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            
            ItemPedido itemtable= listItems.get(rowIndex);
            switch(columnIndex){
                case 0: return itemtable.getItem().getNombre();
                case 1: return itemtable.getCantidad();
                case 2: return itemtable.getItem().getPrecio() * itemtable.getCantidad();
            }
            return "";
        }
        
    }
}
