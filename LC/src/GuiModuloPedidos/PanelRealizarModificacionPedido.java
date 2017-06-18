/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiModuloPedidos;

import ClasesTablas.Empleado;
import ClasesTablas.Item;
import ClasesTablas.ItemPedido;
import ClasesTablas.Pedido;
import ControladorClasesTablas.EmpleadoJpaController;
import ControladorClasesTablas.ItemJpaController;
import ControladorClasesTablas.ItemPedidoJpaController;
import ControladorClasesTablas.PedidoJpaController;
import ControladorClasesTablas.exceptions.NonexistentEntityException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sebas
 */
public class PanelRealizarModificacionPedido extends javax.swing.JPanel implements ActionListener {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
    Pedido pedido = new Pedido();
    
    public PanelRealizarModificacionPedido(Pedido pedido) {
        initComponents();
        
        this.pedido = pedido;
        cbo_tipo.addActionListener(this);
        listaitemsp.setModel(new listaItemsModel());
        cbo_tipo.setModel(listadoTipoPedidoModel());
        table.setModel(new tableModelPedido());
        btnagregarapedido.addActionListener(new agregar());
        btnquitarpedido.addActionListener(new quitar());
        btnactualizar.addActionListener(new actualizar());
        asignacionCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnactualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaitemsp = new javax.swing.JList();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtmesa = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        cbo_tipo = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnagregarapedido = new javax.swing.JButton();
        btnquitarpedido = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

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

        btnactualizar.setBackground(new java.awt.Color(153, 153, 255));
        btnactualizar.setText("Actualizar");

        listaitemsp.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaitemsp);

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

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setText("Detalles del Pedido");
        jLabel6.setToolTipText("");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
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

        jLabel7.setText("Cantidad:");

        btnagregarapedido.setText("Adicionar");

        btnquitarpedido.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnagregarapedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnquitarpedido)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcantidad)
                            .addComponent(btnagregarapedido)
                            .addComponent(btnquitarpedido))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnactualizar)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnagregarapedido;
    private javax.swing.JButton btnquitarpedido;
    private javax.swing.JComboBox cbo_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listaitemsp;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtmesa;
    // End of variables declaration//GEN-END:variables

      @Override
    public void actionPerformed(ActionEvent ae) {
       
        if(ae.getSource() == cbo_tipo)
        {
            if(cbo_tipo.getSelectedIndex() == 1)
            {
              txtmesa.setEnabled(false);
              txtmesa.setText(null);
                   
            }    
        }    
        if (cbo_tipo.getSelectedIndex() == 0)
        {
          txtmesa.setEnabled(true);
          txtmesa.setText(pedido.getNumMesa().toString());
        }    
    }

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
            
            if(!txtcantidad.getText().trim().equals("")&&!listaitemsp.isSelectionEmpty()&& Integer.parseInt(txtcantidad.getText())>0){
               if(cbo_tipo.getSelectedIndex() ==0)
              {    
                  
               if(!txtmesa.getText().trim().equals("")) 
               {   
                ip.setCantidad(Integer.parseInt(txtcantidad.getText()));
                ip.setItem(listaitem.get(listaitemsp.getSelectedIndex()));
                ip.setPedido(pedido);
                try {
                    tjc.create(ip);
                    pedido.getItemPedidoSet().add(ip);
                    table.setModel(new tableModelPedido());
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ya realizo este pedido");
                }
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Ingrese un numero de Mesa");
               }
              }  
               
              else
               {
                ip.setCantidad(Integer.parseInt(txtcantidad.getText()));
                ip.setItem(listaitem.get(listaitemsp.getSelectedIndex()));
                ip.setPedido(pedido);
                try {
                    tjc.create(ip);
                    pedido.getItemPedidoSet().add(ip);
                    table.setModel(new tableModelPedido());
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ya realizo este pedido");
                }
               }     
            }
            else{
                JOptionPane.showMessageDialog(null, "Llene los campos requeridos");
            }
        }
    }
    
    private class quitar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            //controlador itempedido
            ItemPedidoJpaController tjc = new ItemPedidoJpaController(emf);
            ItemPedido ip = new ItemPedido();
            Set<ItemPedido> listpedidoitem = pedido.getItemPedidoSet();
            LinkedList<ItemPedido> listaitem = new LinkedList<ItemPedido>(listpedidoitem);
            List<ItemPedido> listaitempedido = listaItempedido();
            
            if(table.getSelectedRow() != -1){
                try {
                    ip = listaitempedido.get(table.getSelectedRow());
                    pedido.getItemPedidoSet().remove(ip);
                    tjc.destroy(ip.getItemPedidoPK());
                    table.setModel(new tableModelPedido());
                    
                } catch (Exception ex) {
                    Logger.getLogger(PanelRegistrarPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Seleccione un plato de su lista de pedidos");
            }
        }
    }
    
    private class actualizar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            //controlador itempedido
            PedidoJpaController pjc = new PedidoJpaController(emf);
            ItemPedido ip = new ItemPedido();
            
           
                
                pedido.setIdEmpleado(getEmpleadoPedido());
                pedido.setTipo(cbo_tipo.getSelectedItem().toString());
                
                
                if(cbo_tipo.getSelectedItem().toString().equalsIgnoreCase("Pedido Llevar"))
                {
                    
                    pedido.setNumMesa(null);
                }    
                
                if(cbo_tipo.getSelectedItem().toString().equalsIgnoreCase("Pedido Mesa"))
                {
                    pedido.setNumMesa(Integer.parseInt(txtmesa.getText()));
                }                 
                
                
                try {
                    pjc.edit(pedido);
                    JOptionPane.showMessageDialog(null, "Se ha modificado tu pedido");
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(PanelRealizarModificacionPedido.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(PanelRealizarModificacionPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
    public LinkedList<ItemPedido> listaItempedido(){
        
        ItemPedidoJpaController ijc = new ItemPedidoJpaController(emf);
        List<ItemPedido> listaip = ijc.findItemPedidoEntities();
        LinkedList<ItemPedido> lista = new LinkedList<>();
        
        for (ItemPedido itemPedido : listaip) {
            if(itemPedido.getPedido().getIdPedido().intValue()== pedido.getIdPedido().intValue()){
                lista.add(itemPedido);
            }
        }
        return lista;
    }
    
    public Empleado getEmpleadoPedido() {
        Empleado empleado = null;
        EmpleadoJpaController ejc = new EmpleadoJpaController(emf);
        List<Empleado> listaEmpleado = ejc.findEmpleadoEntities();

        empleado = pedido.getIdEmpleado();
        //System.out.println(cbo_mesero.getSelectedIndex());

        return empleado;
    }
    
    private void asignacionCampos(){
        
        if(pedido.getTipo().equalsIgnoreCase("Pedido Mesa"))
            
        {
            txtmesa.setText(pedido.getNumMesa().toString());
             
        }    
            
        if (pedido.getTipo().toString().equalsIgnoreCase("Pedido Llevar"))
        {
           txtmesa.setText("");
        }    
    
       
        cbo_tipo.setSelectedIndex(tipoPedidoseleccionado());
        
    }
    
    private int meseroPedidoseleccionado(){
        int a=0;
        if(pedido.getIdEmpleado().getIdEmpleado()==222){ a=1;}
        else if(pedido.getIdEmpleado().getIdEmpleado()==333){a=2;}
        return a;
    }
    
    private int tipoPedidoseleccionado(){
        int a=0;
        if(pedido.getTipo().equals("Pedido Llevar")||pedido.getTipo().equals("llevar")){ a=1;}
        return a;
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
    
    private class tableModelPedido extends AbstractTableModel{
        
//        Set<ItemPedido> listpedidoitem = pedido.getItemPedidoSet();
//        LinkedList<ItemPedido> listaitem = new LinkedList<ItemPedido>(listpedidoitem);
        LinkedList<ItemPedido> listai = listaItempedido();
        
        @Override
        public int getRowCount() {
            return listai.size();
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
            
            ItemPedido itemtable= listai.get(rowIndex);
            switch(columnIndex){
                case 0: return itemtable.getItem().getNombre();
                case 1: return itemtable.getCantidad();
                case 2: return itemtable.getItem().getPrecio() * itemtable.getCantidad();
            }
            return "";
        } 
    }
    
}
