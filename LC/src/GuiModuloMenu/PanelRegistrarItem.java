/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiModuloMenu;

import ClasesTablas.Item;
import ControladorClasesTablas.ItemJpaController;
import Fachada.Fachada;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Moni
 */
public class PanelRegistrarItem extends javax.swing.JPanel {

    /**
     * Creates new form RegistrarEmpleado
     */
    public PanelRegistrarItem() {
        initComponents();
        //this.jcbCategoria.setModel(defaultComboModel());
    }
    
    String ruta = ""; 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfID = new javax.swing.JTextField();
        jlID = new javax.swing.JLabel();
        jlNombreFoto = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jlPrecio = new javax.swing.JLabel();
        jtfPrecio = new javax.swing.JTextField();
        jcbCategoria = new javax.swing.JComboBox();
        jlCategoria = new javax.swing.JLabel();
        jlDescripcion = new javax.swing.JLabel();
        jspDescripcion = new javax.swing.JScrollPane();
        jtaDescripcion = new javax.swing.JTextArea();
        jlRegistrarItem = new javax.swing.JLabel();
        jlFoto = new javax.swing.JLabel();
        jbCargarFoto = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        jlID.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jlID.setText("ID:");

        jlNombreFoto.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jlNombreFoto.setText("Foto:");

        jlNombre.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jlNombre.setText("Nombre:");

        jlPrecio.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jlPrecio.setText("Precio:");

        jcbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona", "CARNE CERDO", "CARNE POLLO", "CARNE RES", "ESPECIAL L&C", "COMIDA MAR", "ENSALADAS", "SOPAS", "ADICIONES", "POSTRES", "ENTRADAS", "BEBIDAS", "BEBIDAS ALCOHOLICAS", "VINOS" }));

        jlCategoria.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jlCategoria.setText("Categoria:");

        jlDescripcion.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jlDescripcion.setText("Descripcion:");

        jtaDescripcion.setColumns(20);
        jtaDescripcion.setRows(5);
        jspDescripcion.setViewportView(jtaDescripcion);

        jlRegistrarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/button crear.png"))); // NOI18N
        jlRegistrarItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlRegistrarItemMouseClicked(evt);
            }
        });

        jlFoto.setText("               Foto");
        jlFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbCargarFoto.setText("CargarFoto");
        jbCargarFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCargarFotoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(jlRegistrarItem))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlPrecio)
                            .addComponent(jlNombre)
                            .addComponent(jlCategoria)
                            .addComponent(jlDescripcion)
                            .addComponent(jlID)
                            .addComponent(jlNombreFoto))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jbCargarFoto))
                            .addComponent(jspDescripcion)
                            .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbCargarFoto))
                    .addComponent(jlNombreFoto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlID)
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlNombre)
                                .addGap(58, 58, 58)
                                .addComponent(jlPrecio)))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlCategoria)
                            .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jspDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlDescripcion)))
                    .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlRegistrarItem)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlRegistrarItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlRegistrarItemMouseClicked

        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU"); // LCPU es el nombre de nuestra unidad de persistencia
        int idItem = Integer.parseInt(jtfID.getText());
        String nombre = jtfNombre.getText();
        int precio = Integer.parseInt(jtfPrecio.getText());
        String categoria = jcbCategoria.getSelectedItem().toString();
        String descripcion = jtaDescripcion.getText();
        String Estado = "Activo";
        String rut = ruta;
        
        Fachada fachada = new Fachada();
        String res = fachada.CrearItem(idItem, nombre, precio, categoria, descripcion, Estado, rut);
        
        if (res.equals("1")||res.equals("2")){
            jtfID.setText("");
            jtfNombre.setText("");
            jtfPrecio.setText("");
            jcbCategoria.setSelectedIndex(0);
            jtaDescripcion.setText("");
            jlFoto.removeAll();
        }
    }//GEN-LAST:event_jlRegistrarItemMouseClicked

    private void jbCargarFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCargarFotoMouseClicked

        JFileChooser myFileChooser = new JFileChooser();
        myFileChooser.showOpenDialog(this);

        ruta = myFileChooser.getSelectedFile().getAbsolutePath();
        if(!(ruta == null))
        {  

        ImageIcon fotografia = new ImageIcon(ruta);
        jlFoto.setIcon(fotografia);
        ruta = ruta.replace("\\", "/");
        ruta = ruta.substring(67,ruta.length());
        }
        else 
        {
          ruta = null;
        } 
    }//GEN-LAST:event_jbCargarFotoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbCargarFoto;
    private javax.swing.JComboBox jcbCategoria;
    private javax.swing.JLabel jlCategoria;
    private javax.swing.JLabel jlDescripcion;
    private javax.swing.JLabel jlFoto;
    private javax.swing.JLabel jlID;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlNombreFoto;
    private javax.swing.JLabel jlPrecio;
    private javax.swing.JLabel jlRegistrarItem;
    private javax.swing.JScrollPane jspDescripcion;
    private javax.swing.JTextArea jtaDescripcion;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfPrecio;
    // End of variables declaration//GEN-END:variables

    private DefaultComboBoxModel defaultComboModel(){
        
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        String[] lista = {"Adiciones y Postres","Bebiddas, Otras bebidas", "Cerdo y Pollo",
        "Cervezas, Conteles, Sin licor", "Ensalada, Sopas", "Entradas, Ceviches",
        "Vinos", "Res, Especiales L&C", "Pescado, Mariscos"};
        for (String i : lista) {
            dcm.addElement(i);
        }
        return dcm;
    }
    

}
