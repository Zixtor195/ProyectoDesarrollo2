/*
    Universidad del Valle
    Asignatura: Desarrollo de Software II 750092M
    Tema: Proyecto final - Entrega 3
    Archivo: Menu.java
    Version: 1.0
    Fecha de creacion: 28 abril 2017
    Autores:   
                Monica Marcela Llano
                Sebastian Balante Salazar
                Cristian Camilo Jurado Arboleda
                Juan Felipe Orozco Escobar
    
    Responsabilidad: Interfaz Personal Restaurante Lenos y Carbon
       
    Colaboracion: PanelConsultarItem, PanelEliminarItem, PanelModificarItem, PanelRegistrarItem
                    PanelRealizarModificacionItem, PanelResultadosConsultaItem
*/

package GuiModuloMenu;

import ClasesTablas.Item;
import ControladorClasesTablas.ItemJpaController;
import GuiMenu.ContenedorFondo;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;


public class Menu extends javax.swing.JFrame {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
    ContenedorFondo contenedorPrincipalFondo;
    
    public Menu() {
        contenedorPrincipalFondo = new ContenedorFondo("src/imagenes/fondoInterfaces.jpg");
        super.setContentPane(contenedorPrincipalFondo);
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //setResizable(false);
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
        jbRegistrarItem = new javax.swing.JButton();
        jbModificarItem = new javax.swing.JButton();
        jbConsultarItem = new javax.swing.JButton();
        jbEliminarItem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.black);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setOpaque(false);

        jbRegistrarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crearItem.jpg"))); // NOI18N
        jbRegistrarItem.setPreferredSize(new java.awt.Dimension(150, 136));
        jbRegistrarItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbRegistrarItemMouseClicked(evt);
            }
        });

        jbModificarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificarItem.jpg"))); // NOI18N
        jbModificarItem.setPreferredSize(new java.awt.Dimension(150, 136));
        jbModificarItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbModificarItemMouseClicked(evt);
            }
        });

        jbConsultarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/consultarItem.jpg"))); // NOI18N
        jbConsultarItem.setPreferredSize(new java.awt.Dimension(150, 136));
        jbConsultarItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbConsultarItemMouseClicked(evt);
            }
        });

        jbEliminarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminarItem.jpg"))); // NOI18N
        jbEliminarItem.setPreferredSize(new java.awt.Dimension(150, 136));
        jbEliminarItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEliminarItemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbEliminarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbConsultarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbRegistrarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jbRegistrarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jbModificarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbConsultarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbEliminarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
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
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRegistrarItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbRegistrarItemMouseClicked

        PanelRegistrarItem ri = new PanelRegistrarItem();
        ri.setSize(752,686);
        
        jPanel2.removeAll();
        jPanel2.add(ri);
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_jbRegistrarItemMouseClicked

    private void jbModificarItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbModificarItemMouseClicked

        PanelModificarItem mi = new PanelModificarItem();
        mi.setSize(752,686);
        jPanel2.removeAll();
        jPanel2.add(mi);
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_jbModificarItemMouseClicked

    private void jbConsultarItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbConsultarItemMouseClicked

        PanelConsultarItem ci = new PanelConsultarItem();
        ci.setSize(752,686);
        jPanel2.removeAll();
        jPanel2.add(ci);
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_jbConsultarItemMouseClicked

    private void jbEliminarItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEliminarItemMouseClicked

        PanelEliminarItem Ei = new PanelEliminarItem();
        Ei.setSize(752,686);
        jPanel2.removeAll();
        jPanel2.add(Ei);
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_jbEliminarItemMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbConsultarItem;
    private javax.swing.JButton jbEliminarItem;
    private javax.swing.JButton jbModificarItem;
    private javax.swing.JButton jbRegistrarItem;
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
}
