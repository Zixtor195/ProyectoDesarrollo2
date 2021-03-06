/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiModuloMenu;


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
public class PanelRealizarModificacionItem extends javax.swing.JPanel {

    /**
     * Creates new form RegistrarEmpleado
     */
    public PanelRealizarModificacionItem() {
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

        jlFoto = new javax.swing.JLabel();
        jbCambiarFoto = new javax.swing.JButton();
        jlNombreFoto = new javax.swing.JLabel();
        jlID = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();
        jlNombre = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jlPrecio = new javax.swing.JLabel();
        jtfPrecio = new javax.swing.JTextField();
        jlCategoria = new javax.swing.JLabel();
        jcbCategoria = new javax.swing.JComboBox();
        jspDescripcion = new javax.swing.JScrollPane();
        jtaDescripcion1 = new javax.swing.JTextArea();
        jlDescripcion = new javax.swing.JLabel();
        jlModificar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(650, 666));

        jlFoto.setText("               Foto");
        jlFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbCambiarFoto.setText("Cambiar foto");
        jbCambiarFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCambiarFotoMouseClicked(evt);
            }
        });

        jlNombreFoto.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jlNombreFoto.setText("Foto:");

        jlID.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jlID.setText("ID:");

        jtfID.setEditable(false);

        jlNombre.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jlNombre.setText("Nombre:");

        jlPrecio.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jlPrecio.setText("Precio:");

        jlCategoria.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jlCategoria.setText("Categoria:");

        jcbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona", "CARNE CERDO", "CARNE POLLO", "CARNE RES", "ESPECIAL L&C", "COMIDA MAR", "ENSALADAS", "SOPAS", "ADICIONES", "POSTRES", "ENTRADAS", "BEBIDAS", "BEBIDAS ALCOHOLICAS", "VINOS" }));

        jtaDescripcion1.setColumns(20);
        jtaDescripcion1.setRows(5);
        jspDescripcion.setViewportView(jtaDescripcion1);

        jlDescripcion.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jlDescripcion.setText("Descripcion:");

        jlModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonmodificar.jpg"))); // NOI18N
        jlModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlModificarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlNombreFoto)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jbCambiarFoto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(187, 187, 187)
                                .addComponent(jlModificar)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlPrecio)
                            .addComponent(jlNombre)
                            .addComponent(jlCategoria)
                            .addComponent(jlDescripcion)
                            .addComponent(jlID))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jspDescripcion)
                            .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jlNombreFoto))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbCambiarFoto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jlModificar)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbCambiarFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCambiarFotoMouseClicked

        JFileChooser myFileChooser = new JFileChooser();
        myFileChooser.showOpenDialog(this);

        ruta = myFileChooser.getSelectedFile().getAbsolutePath();
            if(!(ruta == null)) {

            ImageIcon fotografia = new ImageIcon(ruta);
            jlFoto.setIcon(fotografia);
            ruta = ruta.replace("\\", "/");
            ruta = ruta.substring(67,ruta.length());
        } else {
            ruta = null;
        }
    }//GEN-LAST:event_jbCambiarFotoMouseClicked

    private void jlModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlModificarMouseClicked
         
        if(jtfNombre.getText().isEmpty() || jtfPrecio.getText().isEmpty() || jcbCategoria.getSelectedItem().toString().equalsIgnoreCase("Selecciona") 
                || jtaDescripcion1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos mal ingresados");
        }else{
            int idItem = Integer.parseInt(jtfID.getText());
            String nombre = jtfNombre.getText();
            int precio = Integer.parseInt(jtfPrecio.getText());
            String categoria = jcbCategoria.getSelectedItem().toString();
            String descripcion = jtaDescripcion1.getText();
            String Estado = "Activo";
            String rut = ruta;   

            Fachada fachada = new Fachada();
            String res = fachada.ModificarItem(idItem, nombre, precio, categoria, descripcion, Estado, rut);
            
            // res = "1" significa que se logro crear el item exitosamente
            if (res.equals("1")){
                jtfID.setText("");
                jtfNombre.setText("");
                jtfPrecio.setText("");
                jcbCategoria.setSelectedIndex(0);
                jtaDescripcion1.setText("");
                jlFoto.setIcon(null);
            }
        }
    }//GEN-LAST:event_jlModificarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbCambiarFoto;
    public javax.swing.JComboBox jcbCategoria;
    private javax.swing.JLabel jlCategoria;
    private javax.swing.JLabel jlDescripcion;
    public javax.swing.JLabel jlFoto;
    private javax.swing.JLabel jlID;
    private javax.swing.JLabel jlModificar;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlNombreFoto;
    private javax.swing.JLabel jlPrecio;
    private javax.swing.JScrollPane jspDescripcion;
    public javax.swing.JTextArea jtaDescripcion1;
    public javax.swing.JTextField jtfID;
    public javax.swing.JTextField jtfNombre;
    public javax.swing.JTextField jtfPrecio;
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
