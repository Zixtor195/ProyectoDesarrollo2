/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiModuloMenu;

import ClasesTablas.Item;
import ControladorClasesTablas.ItemJpaController;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Moni
 */
public class PanelResultadosConsultaItem extends javax.swing.JPanel {

    /**
     * Creates new form RegistrarEmpleado
     */
    public PanelResultadosConsultaItem() {
        initComponents();
        this.jcbCategoria.setModel(defaultComboModel());
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
        jlNombre = new javax.swing.JLabel();
        jlPrecio = new javax.swing.JLabel();
        jlCategoria = new javax.swing.JLabel();
        jlDescripcion = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();
        jtfPrecio = new javax.swing.JTextField();
        jcbCategoria = new javax.swing.JComboBox();
        jspDescripcion = new javax.swing.JScrollPane();
        jtaDescripcion = new javax.swing.JTextArea();
        jlNombreFoto = new javax.swing.JLabel();
        jlID = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jlAceptar = new javax.swing.JLabel();
        jlFoto = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(752, 662));

        jPanel1.setOpaque(false);

        jlNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlNombre.setText("Nombre:");

        jlPrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlPrecio.setText("Precio:");

        jlCategoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlCategoria.setText("Categoria:");

        jlDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlDescripcion.setText("Descripcion:");

        jtfID.setEditable(false);

        jtfPrecio.setEditable(false);

        jcbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona", "CARNE CERDO", "CARNE POLLO", "CARNE RES", "ESPECIAL L&C", "COMIDA MAR", "ENSALADAS", "SOPAS", "ADICIONES", "POSTRES", "ENTRADAS", "BEBIDAS", "BEBIDAS ALCOHOLICAS", "VINOS" }));
        jcbCategoria.setEnabled(false);

        jtaDescripcion.setEditable(false);
        jtaDescripcion.setColumns(20);
        jtaDescripcion.setRows(5);
        jspDescripcion.setViewportView(jtaDescripcion);

        jlNombreFoto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlNombreFoto.setText("Foto:");

        jlID.setText("ID:");

        jtfNombre.setEditable(false);

        jlAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boton aceptar.jpg"))); // NOI18N
        jlAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlAceptarMouseClicked(evt);
            }
        });

        jlFoto.setText("               Foto");
        jlFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlPrecio)
                            .addComponent(jlNombre)
                            .addComponent(jlCategoria)
                            .addComponent(jlDescripcion)
                            .addComponent(jlID))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jspDescripcion)
                            .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlNombreFoto)
                        .addGap(192, 192, 192)
                        .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jlAceptar)
                .addGap(208, 208, 208))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlNombreFoto)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlID)
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlNombre)
                                .addGap(58, 58, 58)
                                .addComponent(jlPrecio)))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlCategoria)
                            .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jspDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlDescripcion)))
                    .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jlAceptar)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAceptarMouseClicked
        
        this.removeAll();
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jlAceptarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    public javax.swing.JComboBox jcbCategoria;
    private javax.swing.JLabel jlAceptar;
    private javax.swing.JLabel jlCategoria;
    private javax.swing.JLabel jlDescripcion;
    public javax.swing.JLabel jlFoto;
    private javax.swing.JLabel jlID;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlNombreFoto;
    private javax.swing.JLabel jlPrecio;
    private javax.swing.JScrollPane jspDescripcion;
    public javax.swing.JTextArea jtaDescripcion;
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

