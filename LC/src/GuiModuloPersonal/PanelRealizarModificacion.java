/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiModuloPersonal;


import ClasesTablas.Empleado;
import ClasesTablas.TurnosSemanales;
import ControladorClasesTablas.EmpleadoJpaController;
import ControladorClasesTablas.TurnosSemanalesJpaController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.AbstractTableModel;


/**
 *
 * 
 */
public final class PanelRealizarModificacion extends javax.swing.JPanel {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
    private Empleado empleado = new Empleado();
    
    public PanelRealizarModificacion(Empleado empleado) {
        initComponents();
        
        this.empleado = empleado;
        cargardatos();
        btn_agregar.addActionListener(new agregar());
        btn_borrar.addActionListener(new quitar());
        btnmodificar.addActionListener(new actualizar());
        table.setModel(new tabelModelHorario());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        foto1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtnombre = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        cb_tipodocumento = new javax.swing.JComboBox();
        txtnodocumento = new javax.swing.JTextField();
        cb_cargo = new javax.swing.JComboBox();
        txttel = new javax.swing.JTextField();
        txtcelular = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb_dia = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_borrar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnmodificar = new javax.swing.JButton();
        txtpass = new javax.swing.JPasswordField();
        spinner_hora_inicio = new javax.swing.JSpinner();
        spinner_hora_fin = new javax.swing.JSpinner();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Foto:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Nombre:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Apellidos:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Tipo de Documento:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("No. Identificacion:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Dirrecciòn:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Cargo:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Tel:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Celular:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Contraseña:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Email:");

        foto1.setText("               Foto");
        foto1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Empleado");

        jButton3.setText("CargarFoto");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        txtapellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidosActionPerformed(evt);
            }
        });

        cb_tipodocumento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cedula", "Cedula Extranjera", "Tarjeta de Identidad" }));

        txtnodocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnodocumentoActionPerformed(evt);
            }
        });

        cb_cargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gerente", "Secretaria", "Cajero", "Mesero" }));

        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Turnos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione un dia:");

        cb_dia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Hora Inicio:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Hora Fin:");

        btn_borrar.setText("Borrar");

        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

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
                {null, null, null}
            },
            new String [] {
                "Dia", "Hora Inicio", "Hora Fin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Usuario");

        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonmodificar.jpg"))); // NOI18N

        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });

        spinner_hora_inicio.setModel(new javax.swing.SpinnerDateModel());
        spinner_hora_inicio.setEditor(new javax.swing.JSpinner.DateEditor(spinner_hora_inicio, "HH:mm"));

        spinner_hora_fin.setModel(new javax.swing.SpinnerDateModel());
        spinner_hora_fin.setEditor(new javax.swing.JSpinner.DateEditor(spinner_hora_fin, "HH:mm"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(548, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinner_hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinner_hora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(251, 251, 251))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(180, 180, 180)
                            .addComponent(jLabel3)
                            .addGap(352, 352, 352)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addGap(147, 147, 147)
                            .addComponent(foto1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(19, 19, 19)
                            .addComponent(jButton3)
                            .addGap(83, 83, 83)
                            .addComponent(jLabel2)
                            .addGap(41, 41, 41)
                            .addComponent(cb_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14))
                            .addGap(104, 104, 104)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(50, 50, 50)
                            .addComponent(jLabel4))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15)
                                .addComponent(jLabel16))
                            .addGap(33, 33, 33)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cb_tipodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(49, 49, 49)
                            .addComponent(jLabel5))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel23)
                            .addGap(118, 118, 118)
                            .addComponent(cb_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(159, 159, 159)
                            .addComponent(btn_agregar)
                            .addGap(121, 121, 121)
                            .addComponent(btn_borrar))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel21)
                                .addComponent(jLabel18)
                                .addComponent(jLabel19)
                                .addComponent(jLabel20)
                                .addComponent(jLabel6))
                            .addGap(94, 94, 94)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(49, 49, 49)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel22)
                            .addGap(85, 85, 85)
                            .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(240, 240, 240)
                            .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addComponent(spinner_hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(spinner_hora_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169)
                .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1))
                    .addGap(21, 21, 21)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(jLabel17))
                        .addComponent(foto1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(jButton3))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(cb_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel13)
                            .addGap(23, 23, 23)
                            .addComponent(jLabel14))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel4))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(jLabel15)
                            .addGap(23, 23, 23)
                            .addComponent(jLabel16))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(cb_tipodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(txtnodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel5))
                    .addGap(7, 7, 7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addComponent(jLabel23))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(cb_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btn_agregar)
                        .addComponent(btn_borrar))
                    .addGap(9, 9, 9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addGap(33, 33, 33)
                                    .addComponent(jLabel18)
                                    .addGap(33, 33, 33)
                                    .addComponent(jLabel19)
                                    .addGap(33, 33, 33)
                                    .addComponent(jLabel20)
                                    .addGap(23, 23, 23)
                                    .addComponent(jLabel6))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(58, 58, 58)
                                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(8, 8, 8)
                                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel22))
                        .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    private void txtapellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidosActionPerformed

    private void txtnodocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnodocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnodocumentoActionPerformed

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed

    }//GEN-LAST:event_btn_agregarActionPerformed

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JComboBox cb_cargo;
    private javax.swing.JComboBox cb_dia;
    private javax.swing.JComboBox cb_tipodocumento;
    private javax.swing.JLabel foto1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinner_hora_fin;
    private javax.swing.JSpinner spinner_hora_inicio;
    public javax.swing.JTable table;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtemail;
    public javax.swing.JTextField txtnodocumento;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txttel;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables

    
    private class agregar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            EmpleadoJpaController ejc = new EmpleadoJpaController(emf);
            TurnosSemanalesJpaController tsc = new TurnosSemanalesJpaController(emf);
            TurnosSemanales turno = new TurnosSemanales(); 
           
            if(!txtnombre.getText().trim().equals("") && !txtapellidos.getText().trim().equals("") && !txtnodocumento.getText().trim().equals("") 
              && !txtemail.getText().trim().equals("") && !txtdireccion.getText().trim().equals("") && !txttel.getText().trim().equals("")
              && !txtcelular.getText().trim().equals("") && !txtusuario.getText().trim().equals("") && !txtpass.getText().trim().equals("")){
               
                try {
                    //Integer idEmpleado, String nombres, String apellidos, String cargo,
                    //String telFijo, String telCel, String email, String direccion,
                    //String tipoDocumento,String usuario, String contrase, String estado
                    if(empleado == null){
                        empleado = new Empleado(Integer.parseInt(txtnodocumento.getText()),txtnombre.getText(),txtapellidos.getText(),
                            cb_cargo.getSelectedItem().toString(),txttel.getText(),txtcelular.getText(),txtemail.getText(),
                            txtdireccion.getText(),cb_tipodocumento.getSelectedItem().toString(), txtusuario.getText(), txtpass.getText(),
                            "Activo");
                            //ejc.create(empleado);
                    }
                    
                    turno = new TurnosSemanales(getNumListaTurno(),cb_dia.getSelectedItem().toString(),getSpinner_Hora_Inicio(),getSpinner_Hora_Fin(),empleado);
                    tsc.create(turno);
                    empleado.getTurnosSemanalesSet().add(turno);
                    
                    table.setModel(new tabelModelHorario());
                    
                } catch (Exception ex) {
                    Logger.getLogger(PanelRegistrarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                 JOptionPane.showMessageDialog(null,"Por favor, complete los campos requeridos");
            }
            
        } 
    }
    
    private class quitar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            EmpleadoJpaController ejc = new EmpleadoJpaController(emf);
            TurnosSemanalesJpaController tsc = new TurnosSemanalesJpaController(emf);
            TurnosSemanales turno = null; 
            Set<TurnosSemanales> turnosemanalesset = empleado.getTurnosSemanalesSet();
            List<TurnosSemanales> listaturnos = new LinkedList<>(turnosemanalesset);
           
            if(!txtnombre.getText().trim().equals("") && !txtapellidos.getText().trim().equals("") && !txtnodocumento.getText().trim().equals("") 
              && !txtemail.getText().trim().equals("") && !txtdireccion.getText().trim().equals("") && !txttel.getText().trim().equals("")
              && !txtcelular.getText().trim().equals("") && !txtusuario.getText().trim().equals("") && !txtpass.getText().trim().equals("")){
               
                try {
                    
                    if (table.getSelectedRow() != -1) {
                        turno = listaturnos.get(table.getSelectedRow());
                        tsc.destroy(turno.getId());
                        
                        table.setModel(new tabelModelHorario());
                    }else{
                        JOptionPane.showMessageDialog(null,"Por favor, seleccione un turno antes de quitar de la lista");
                    }
                    
                } catch (Exception ex) {
                    Logger.getLogger(PanelRegistrarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                 JOptionPane.showMessageDialog(null,"Por favor, complete los campos requeridos");
            }
            
        } 
    }
    
    private class actualizar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
            EmpleadoJpaController ejc = new EmpleadoJpaController(emf);
           
            if(!txtnombre.getText().trim().equals("") && !txtapellidos.getText().trim().equals("") && !txtnodocumento.getText().trim().equals("") 
              && !txtemail.getText().trim().equals("") && !txtdireccion.getText().trim().equals("") && !txttel.getText().trim().equals("")
              && !txtcelular.getText().trim().equals("") && !txtusuario.getText().trim().equals("") && !txtpass.getText().trim().equals("")){
               
                try {
                    //Integer idEmpleado, String nombres, String apellidos, String cargo,
                    //String telFijo, String telCel, String email, String direccion,
                    //String tipoDocumento,String usuario, String contrase, String estado
                    empleado.setIdEmpleado(Integer.parseInt(txtnodocumento.getText()));
                    empleado.setNombres(txtnombre.getText());
                    empleado.setApellidos(txtapellidos.getText());
                    empleado.setCargo(cb_cargo.getSelectedItem().toString());
                    empleado.setTelFijo(txttel.getText());
                    empleado.setTelCel(txtcelular.getText());
                    empleado.setEmail(txtemail.getText());
                    empleado.setDireccion(txtdireccion.getText());
                    empleado.setTipoDocumento(cb_tipodocumento.getSelectedItem().toString());
                    empleado.setUsuario(txtusuario.getText());
                    empleado.setContrase(txtpass.getText());
                    empleado.setEstado("Activo");
                    
                    ejc.edit(empleado);
                    
                    JOptionPane.showMessageDialog(null,"El empleado ha sido modificado");
                    
                } catch (Exception ex) {
                    Logger.getLogger(PanelRegistrarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                 JOptionPane.showMessageDialog(null,"Por favor, complete los campos requeridos");
            }
            
        } 
    }
    
    private void cargardatos(){
        
        txtnombre.setText(empleado.getNombres());
        txtapellidos.setText(empleado.getApellidos());
        txtnodocumento.setText(empleado.getIdEmpleado().toString());
        txtemail.setText(empleado.getEmail());
        txtdireccion.setText(empleado.getDireccion());
        txttel.setText(empleado.getTelCel());
        txtcelular.setText(empleado.getTelCel());
        txtusuario.setText(empleado.getUsuario());
        txtpass.setText(empleado.getContrase());
        cb_tipodocumento.setSelectedItem(empleado.getTipoDocumento());
        cb_cargo.setSelectedItem(empleado.getCargo()); 
        txtnodocumento.setEnabled(false);
    }
    
    private LinkedList<TurnosSemanales> getListaTurno(){
        
        LinkedList<TurnosSemanales> listaturno = new LinkedList<TurnosSemanales>();
        TurnosSemanalesJpaController tsj = new TurnosSemanalesJpaController(emf);
        List<TurnosSemanales> listaturnos = tsj.findTurnosSemanalesEntities();
       
        
        for (TurnosSemanales listaturno1 : listaturnos) {
            
            if(listaturno1.getIdEmpleado().getIdEmpleado() == empleado.getIdEmpleado()){
                listaturno.add(listaturno1);
            } 
        }
        return listaturno;
    }
    
    private int getNumListaTurno(){
        int a = 0;
        TurnosSemanalesJpaController tsj = new TurnosSemanalesJpaController(emf);
        List<TurnosSemanales> listaturnos = tsj.findTurnosSemanalesEntities();
        a = listaturnos.get(listaturnos.size()-1).getId();
        return a+1;
    }
    
    private String getSpinner_Hora_Inicio(){
        
        JSpinner.DateEditor de = new JSpinner.DateEditor(spinner_hora_inicio, "HH:mm");
        return de.getFormat().format(spinner_hora_inicio.getValue());
    }
    
    private String getSpinner_Hora_Fin(){
        
        JSpinner.DateEditor def = new JSpinner.DateEditor(spinner_hora_fin, "HH:mm");
        return def.getFormat().format(spinner_hora_fin.getValue());
    }

    
     private class tabelModelHorario extends AbstractTableModel{
        
        //EmpleadoJpaController ejc = new EmpleadoJpaController(emf);
        //List<Empleado> listaempleado = ejc.findEmpleadoEntities();
        //Set<TurnosSemanales> turnosemanalesset = empleado.getTurnosSemanalesSet();
         
        List<TurnosSemanales> listaturnos = getListaTurno();
        
        @Override
        public int getRowCount() {
                return listaturnos.size();

        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public String getColumnName(int column) {
            switch(column){
                case 0: return "Dia"; 
                case 1: return "Hora Inicio";
                case 2: return "Hora Fin";
            }
            return "";
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            
            TurnosSemanales turnos = listaturnos.get(rowIndex);
            
            switch(columnIndex){
                case 0: return turnos.getDia(); 
                case 1: return turnos.getHoraInicio();
                case 2: return turnos.getHoraFin(); 
            }
            return "";
        }
    }
    

}
