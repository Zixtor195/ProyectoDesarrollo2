/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiModuloPedidos;


import ClasesTablas.Factura;
import ClasesTablas.ItemPedido;
import ClasesTablas.Pedido;
import ControladorClasesTablas.FacturaJpaController;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Moni
 */
public class PanelEliminarPedido extends javax.swing.JPanel {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
    PedidoJpaController pjc = new PedidoJpaController(emf);
    List<Pedido> listapedido = pjc.findPedidoEntities();
    
    int id;
    String cargo;
    public PanelEliminarPedido(int id, String cargo) {
        this.id = id;
        this.cargo = cargo;
        initComponents();
        
        table.setModel(new tableModel());
        lbleliminar.addMouseListener(new Eliminar());
    }

    public void removerMeseros(int id, String cargo) {
        if (cargo.equalsIgnoreCase("Mesero") || cargo.equalsIgnoreCase("mesero")) {
            for (int i = 0; i < listapedido.size(); i++) {
                if (listapedido.get(i).getIdEmpleado().getIdEmpleado() != id) {
                    listapedido.remove(i);
                }
            }
        }
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
        lbleliminar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setAutoscrolls(true);
        setOpaque(false);

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

        lbleliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botoneliminar.jpg"))); // NOI18N
        lbleliminar.setPreferredSize(new java.awt.Dimension(115, 38));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
            .addGroup(layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(lbleliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbleliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lbleliminar;
    public javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    
     private class Eliminar implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            
            ItemPedidoJpaController ijc = new ItemPedidoJpaController(emf);
            FacturaJpaController fjc = new FacturaJpaController(emf);
            
            
            if(table.getSelectedRow()!=-1){
                
                Pedido pedido = listapedido.get(table.getSelectedRow());
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
                            Logger.getLogger(PanelEliminarPedido.class.getName()).log(Level.SEVERE, null, ex);
                        }
 
                    }
                }
                
                //pedido.getItemPedidoSet().r;
                try {
                    pjc.destroy(pedido.getIdPedido());
                    table.setModel(new tableModel());
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(PanelEliminarPedido.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalOrphanException ex) {
                    Logger.getLogger(PanelEliminarPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
                table.setModel(new tableModel());
            }else{
                JOptionPane.showMessageDialog(null,"Por favor seleccione un pedido para eliminarlo");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
    
    
     private class tableModel extends AbstractTableModel{
        
        @Override
        public int getRowCount() {
            removerMeseros(id,cargo);
            return listapedido.size();
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
