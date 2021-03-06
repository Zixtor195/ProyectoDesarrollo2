/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiModuloMenu;

import ClasesTablas.Factura;
import ClasesTablas.Item;
import ControladorClasesTablas.FacturaJpaController;
import ControladorClasesTablas.ItemJpaController;
import ControladorClasesTablas.exceptions.IllegalOrphanException;
import ControladorClasesTablas.exceptions.NonexistentEntityException;
import Fachada.Fachada;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 *
 */
public class PanelEliminarItem extends javax.swing.JPanel {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
    
    public PanelEliminarItem() {
        initComponents();
        this.jtEliminarItem.setModel(new defaultModelItem());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlEliminarItem = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEliminarItem = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setAutoscrolls(true);
        setOpaque(false);

        jlEliminarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botoneliminar.jpg"))); // NOI18N
        jlEliminarItem.setPreferredSize(new java.awt.Dimension(110, 38));
        jlEliminarItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlEliminarItemMouseClicked(evt);
            }
        });

        jtEliminarItem.setModel(new javax.swing.table.DefaultTableModel(
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
                "Nombre", "Precio", "Categoria", "No.Identificacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtEliminarItem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jlEliminarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlEliminarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlEliminarItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlEliminarItemMouseClicked
        
        if (this.jtEliminarItem.getSelectedRow() != -1) {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
            ItemJpaController dao = new ItemJpaController(emf);

            int idItem = Integer.parseInt(String.valueOf(jtEliminarItem.getValueAt(jtEliminarItem.getSelectedRow(), 0)));

            Item item = dao.findItem(idItem);
            item.setEstado("Inactivo");
            Fachada fachada = new Fachada();
            fachada.EliminarItem(item, emf);
            this.jtEliminarItem.setModel(new defaultModelItem());
            JOptionPane.showMessageDialog(null, "Item eliminado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un item primero por favor");
        }
    }//GEN-LAST:event_jlEliminarItemMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlEliminarItem;
    public javax.swing.JTable jtEliminarItem;
    // End of variables declaration//GEN-END:variables

    public LinkedList<Item> listaItems(){
        LinkedList<Item> listaItems = new LinkedList<>();
        ItemJpaController ijc = new ItemJpaController(emf);
        List<Item> lista = ijc.findItemEntities();
        
        for (Item item : lista) {
            if(item.getEstado().equals("Activo")){
                listaItems.add(item);
            }
        }
        return listaItems;
    }
    
    public class defaultModelItem extends AbstractTableModel{
        
        
        List<Item> listaitem = listaItems();
        
        
        @Override
        public int getRowCount() {
            return listaitem.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public String getColumnName(int column) {
            switch(column){
                case 0: 
                    return "Id"; 
                case 1: 
                    return "Nombre";
                case 2: 
                    return "Precio";
                case 3: 
                    return "Categoria";
                case 4: 
                    return "Descripcion"; 
            }
            return "";
        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            
            Item item = listaitem.get(rowIndex);
            
            switch(columnIndex){
                case 0: return item.getIdItem();
                case 1: return item.getNombre();
                case 2: return item.getPrecio();
                case 3: return item.getCategoria();
                case 4: return item.getDescripcion();
            }
            return "";
        }
    }

}
