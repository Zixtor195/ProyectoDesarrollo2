/*
    Universidad del Valle
    Asignatura: Desarrollo de Software II 750092M
    Tema: Proyecto final - Entrega 3
    Archivo: GuiPrincipal.java
    Version: 1.0
    Fecha de creacion: 28 abril 2017
    Autores:   
                Monica Marcela Llano
                Sebastian Balante Salazar
                Cristian Camilo Jurado Arboleda
                Juan Felipe Orozco Escobar
    
    Responsabilidad: Interfaz principal Restaurante Lenos y Carbon
       
    Colaboracion: GuiModuloMenu, GuiModuloPersonal, GuiModuloPedidos
                    GuiModuloFacturasReportes, GuiModuloReportes
*/

package VistasUsuario;

import GuiFacturasPagos.FacturasPagos;
import GuiModuloPersonal.GerentePersonal;
import GuiModuloMenu.Menu;
import GuiModuloPedidos.Pedidos;


public class GuiPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form GuisPrincipal
     */
    public GuiPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 909, Short.MAX_VALUE)
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel jpPrincipal;
    // End of variables declaration//GEN-END:variables
}
