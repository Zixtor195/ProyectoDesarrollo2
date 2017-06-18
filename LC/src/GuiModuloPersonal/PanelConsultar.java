

package GuiModuloPersonal;

import ClasesTablas.Empleado;
import ControladorClasesTablas.EmpleadoJpaController;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * 
 */
public class PanelConsultar extends javax.swing.JPanel {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
    EmpleadoJpaController ejc = new EmpleadoJpaController(emf);
    List<Empleado> listEmpleado = ejc.findEmpleadoEntities();
    
    
    public PanelConsultar() {
        initComponents();
        table.setModel(new tabelModelc());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jlConsultarBoton = new javax.swing.JLabel();

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
                "Nombre", "Apellidos", "Tipo de Documento", "No.Identificacion"
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

        jlConsultarBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonConsultar.jpg"))); // NOI18N
        jlConsultarBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlConsultarBotonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(173, 173, 173))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlConsultarBoton)
                        .addGap(428, 428, 428))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jlConsultarBoton)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlConsultarBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlConsultarBotonMouseClicked
        
        
       
        Empleado empleado = new Empleado();
        
        empleado = listEmpleado.get(table.getSelectedRow());
        
        PanelResultadosConsulta rc = null;
        try {
            rc = new PanelResultadosConsulta(empleado);
        } catch (IOException ex) {
            Logger.getLogger(PanelConsultar.class.getName()).log(Level.SEVERE, null, ex);
        }
        rc.setSize(986,686);
        
        this.setSize(1000, 1000);
        this.removeAll();
        this.revalidate();
        this.repaint();
        this.add(rc);
    }//GEN-LAST:event_jlConsultarBotonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlConsultarBoton;
    public javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
  
    
    private class tabelModelc extends AbstractTableModel{
        
  
        
        @Override
        public int getRowCount() {
                
                for (int i = 0; i < listEmpleado.size(); i++) 
                {
                    if(!(listEmpleado.get(i).getEstado().equalsIgnoreCase("Activo")))
                    {
                            listEmpleado.remove(i);
                    }   
                }
            return listEmpleado.size();    
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public String getColumnName(int column) {
            switch(column){
                case 0: return "Nombre"; 
                case 1: return "Apellido";
                case 2: return "Tipo Documento"; 
                case 3: return "No. Identificación";
            }
            return "";
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            
            Empleado empleado = listEmpleado.get(rowIndex);
            
            switch(columnIndex){
                case 0: return empleado.getNombres(); 
                case 1: return empleado.getApellidos();
                case 2: return empleado.getTipoDocumento(); 
                case 3: return empleado.getIdEmpleado();
            }
            return "";
        }
        
    }
    

}
