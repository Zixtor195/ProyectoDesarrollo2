/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiModuloPedidos;

import ClasesTablas.Pedido;
import ControladorClasesTablas.PedidoJpaController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;




/**
 *
 * @author Sebas
 */
public class PanelConsultarPedido extends javax.swing.JPanel {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
    Pedido pedido = new Pedido();
    PedidoJpaController pjc = new PedidoJpaController(emf);
    List<Pedido> listapedido = pjc.findPedidoEntities();
    
    
    int id_empleado;
    String cargo;
    public PanelConsultarPedido(int id, String cargo)
            
    {
        initComponents();
        this.id_empleado = id;
        this.cargo = cargo;
        table.setModel(new tableModel());
        
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
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setAutoscrolls(true);

        table.setModel(new javax.swing.table.DefaultTableModel(
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
                "id", "Mesero", "Hora", "No.Mesa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonContinuar.png"))); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(jLabel1)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(178, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        
        if (this.table.getSelectedRow() != -1) {
            pedido = listapedido.get(table.getSelectedRow());

            PanelResulConsultaPedido rm = new PanelResulConsultaPedido(pedido);
            rm.setSize(936, 749);

            this.removeAll();
            this.revalidate();
            this.repaint();
            this.add(rm);
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un pedido primero, por favor");
        }
        
    }//GEN-LAST:event_jLabel1MouseClicked

    public void removerMeseros(int id, String cargo) {
      if(cargo.equalsIgnoreCase("Mesero") || cargo.equalsIgnoreCase("mesero"))
      {    
        for (int i = 0; i < listapedido.size(); i++) {
            if (listapedido.get(i).getIdEmpleado().getIdEmpleado() != id) {
                listapedido.remove(i);

            }

        }

    }
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jLabel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    
    private class tableModel extends AbstractTableModel{
         
        
        
        @Override
        public int getRowCount() {
            removerMeseros(id_empleado,cargo);
            if(listapedido.isEmpty()){
                return 0;
            }else{
                return listapedido.size();
            }
            
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public String getColumnName(int column) {
            switch(column){
                case 0: return "ID"; 
                case 1: return "Mesero";
                case 2: return "Hora";
                case 3: return "No. Mesa";
            }
            return "";
        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            
            Pedido pedid = listapedido.get(rowIndex);
            switch(columnIndex){
                case 0: return pedid.getIdPedido();
                case 1: return pedid.getIdEmpleado().getNombres();
                case 2: 
                    Date date = pedid.getHoraInicio();
                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                    return sdf.format(date);
                case 3: return pedid.getNumMesa();
            }
            return "";
        }
        
    }
    
}

