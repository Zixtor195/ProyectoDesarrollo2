/*
    Universidad del Valle
    Asignatura: Desarrollo de Software II 750092M
    Tema: Proyecto final - Entrega final
    Archivo: MenuPane.java
    Version: 1.0
    Fecha de creacion: 10 junio 2017
    Autores:   
                Monica Marcela Llano
                Sebastian Balante Salazar
                Cristian Camilo Jurado Arboleda
                Juan Felipe Orozco Escobar
    
    Responsabilidad: Interfaz Menu del  Restaurante Lenos y Carbon, el cual muestra
                     precios reales basados en la carta del menu del Restaurante 
                     Lenos & Carbon a la fecha 14 de junio del 2017 Cali - Colombia
                          
    Colaboracion: ContenedorFondo
*/

package GuiMenu;

public class MenuPane extends javax.swing.JFrame {

    ContenedorFondo contenedorPrincipalFondo;
    
    public MenuPane() {
        // Asignar el Contenedor principal de la Clase externa para usar un fondo
        contenedorPrincipalFondo = new ContenedorFondo("src/images/fondo.jpg");
        super.setContentPane(contenedorPrincipalFondo);
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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

        jpOpciones = new javax.swing.JPanel();
        jbCerdoPollo = new javax.swing.JButton();
        jlCarnes = new javax.swing.JLabel();
        jlMenuTitulo = new javax.swing.JLabel();
        jbResLC = new javax.swing.JButton();
        jbPlatosMar = new javax.swing.JButton();
        jlEnsaladasSopas = new javax.swing.JLabel();
        jbEnsaladasSopas = new javax.swing.JButton();
        jlAdicionesPostres = new javax.swing.JLabel();
        jbAdicionesPostres = new javax.swing.JButton();
        jlEntradas = new javax.swing.JLabel();
        jbEntradas = new javax.swing.JButton();
        jlBebidas = new javax.swing.JLabel();
        jbBebidas = new javax.swing.JButton();
        jlBebidasAlcoholicas = new javax.swing.JLabel();
        jbCervezasCocteles = new javax.swing.JButton();
        jbLicores = new javax.swing.JButton();
        jlVinos = new javax.swing.JLabel();
        jbVinosChilenos = new javax.swing.JButton();
        jbVinosArgentinosLocales = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jpMenus = new javax.swing.JPanel();
        jlImagesMenus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpOpciones.setOpaque(false);

        jbCerdoPollo.setForeground(new java.awt.Color(69, 32, 5));
        jbCerdoPollo.setText("Cerdo y Pollo");
        jbCerdoPollo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerdoPolloActionPerformed(evt);
            }
        });

        jlCarnes.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 13)); // NOI18N
        jlCarnes.setForeground(new java.awt.Color(255, 255, 255));
        jlCarnes.setText("Carnes:");

        jlMenuTitulo.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jlMenuTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlMenuTitulo.setText("MENU");

        jbResLC.setForeground(new java.awt.Color(69, 32, 5));
        jbResLC.setText("Res y L&C");
        jbResLC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbResLCActionPerformed(evt);
            }
        });

        jbPlatosMar.setForeground(new java.awt.Color(69, 32, 5));
        jbPlatosMar.setText("Platos de Mar");
        jbPlatosMar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPlatosMarActionPerformed(evt);
            }
        });

        jlEnsaladasSopas.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 13)); // NOI18N
        jlEnsaladasSopas.setForeground(new java.awt.Color(255, 255, 255));
        jlEnsaladasSopas.setText("Ensaladas y Sopas:");

        jbEnsaladasSopas.setForeground(new java.awt.Color(69, 32, 5));
        jbEnsaladasSopas.setText("Ensaladas y Sopas");
        jbEnsaladasSopas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnsaladasSopasActionPerformed(evt);
            }
        });

        jlAdicionesPostres.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 13)); // NOI18N
        jlAdicionesPostres.setForeground(new java.awt.Color(255, 255, 255));
        jlAdicionesPostres.setText("Adiciones y Postres:");

        jbAdicionesPostres.setForeground(new java.awt.Color(69, 32, 5));
        jbAdicionesPostres.setText("Adiciones y Postres");
        jbAdicionesPostres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdicionesPostresActionPerformed(evt);
            }
        });

        jlEntradas.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 13)); // NOI18N
        jlEntradas.setForeground(new java.awt.Color(255, 255, 255));
        jlEntradas.setText("Entradas:");

        jbEntradas.setForeground(new java.awt.Color(69, 32, 5));
        jbEntradas.setText("Entradas");
        jbEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEntradasActionPerformed(evt);
            }
        });

        jlBebidas.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 13)); // NOI18N
        jlBebidas.setForeground(new java.awt.Color(255, 255, 255));
        jlBebidas.setText("Bebidas:");

        jbBebidas.setForeground(new java.awt.Color(69, 32, 5));
        jbBebidas.setText("Bebidas");
        jbBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBebidasActionPerformed(evt);
            }
        });

        jlBebidasAlcoholicas.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 13)); // NOI18N
        jlBebidasAlcoholicas.setForeground(new java.awt.Color(255, 255, 255));
        jlBebidasAlcoholicas.setText("Bebidas Alcoholicas:");

        jbCervezasCocteles.setForeground(new java.awt.Color(69, 32, 5));
        jbCervezasCocteles.setText("Cervezas y Cocteles");
        jbCervezasCocteles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCervezasCoctelesActionPerformed(evt);
            }
        });

        jbLicores.setForeground(new java.awt.Color(69, 32, 5));
        jbLicores.setText("Licores");
        jbLicores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLicoresActionPerformed(evt);
            }
        });

        jlVinos.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 13)); // NOI18N
        jlVinos.setForeground(new java.awt.Color(255, 255, 255));
        jlVinos.setText("Vinos:");

        jbVinosChilenos.setForeground(new java.awt.Color(69, 32, 5));
        jbVinosChilenos.setText("Vinos Chilenos");
        jbVinosChilenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVinosChilenosActionPerformed(evt);
            }
        });

        jbVinosArgentinosLocales.setForeground(new java.awt.Color(69, 32, 5));
        jbVinosArgentinosLocales.setText("Vinos Argentinos/Locales");
        jbVinosArgentinosLocales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVinosArgentinosLocalesActionPerformed(evt);
            }
        });

        jbSalir.setForeground(new java.awt.Color(69, 32, 5));
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpOpcionesLayout = new javax.swing.GroupLayout(jpOpciones);
        jpOpciones.setLayout(jpOpcionesLayout);
        jpOpcionesLayout.setHorizontalGroup(
            jpOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbCerdoPollo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbResLC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbPlatosMar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpOpcionesLayout.createSequentialGroup()
                        .addComponent(jlMenuTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpOpcionesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jpOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbEnsaladasSopas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbAdicionesPostres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbEntradas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbBebidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbCervezasCocteles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbLicores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jpOpcionesLayout.createSequentialGroup()
                                .addGroup(jpOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlVinos)
                                    .addComponent(jlAdicionesPostres)
                                    .addComponent(jlEnsaladasSopas)
                                    .addComponent(jlCarnes)
                                    .addComponent(jlEntradas)
                                    .addComponent(jlBebidas)
                                    .addComponent(jlBebidasAlcoholicas))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jbVinosChilenos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbVinosArgentinosLocales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpOpcionesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jpOpcionesLayout.setVerticalGroup(
            jpOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlMenuTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlCarnes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCerdoPollo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbResLC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbPlatosMar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlEnsaladasSopas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbEnsaladasSopas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlAdicionesPostres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAdicionesPostres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlEntradas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbEntradas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlBebidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbBebidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlBebidasAlcoholicas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCervezasCocteles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbLicores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlVinos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbVinosChilenos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbVinosArgentinosLocales)
                .addGap(18, 18, 18)
                .addComponent(jbSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpMenus.setOpaque(false);

        javax.swing.GroupLayout jpMenusLayout = new javax.swing.GroupLayout(jpMenus);
        jpMenus.setLayout(jpMenusLayout);
        jpMenusLayout.setHorizontalGroup(
            jpMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMenusLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlImagesMenus, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(397, 397, 397))
        );
        jpMenusLayout.setVerticalGroup(
            jpMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlImagesMenus, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpMenus, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpMenus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCerdoPolloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerdoPolloActionPerformed
        jlImagesMenus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1. Cerdo y Pollo.jpg")));
        jlImagesMenus.setVisible(true);
    }//GEN-LAST:event_jbCerdoPolloActionPerformed

    private void jbResLCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbResLCActionPerformed
        jlImagesMenus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2. Res y Especiales L&C.jpg")));
        jlImagesMenus.setVisible(true);
    }//GEN-LAST:event_jbResLCActionPerformed

    private void jbPlatosMarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPlatosMarActionPerformed
        jlImagesMenus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3 Pescados, Mariscos.jpg")));
        jlImagesMenus.setVisible(true);
    }//GEN-LAST:event_jbPlatosMarActionPerformed

    private void jbEnsaladasSopasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnsaladasSopasActionPerformed
        jlImagesMenus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1. Ensaladas y Sopas.jpg")));
        jlImagesMenus.setVisible(true);
    }//GEN-LAST:event_jbEnsaladasSopasActionPerformed

    private void jbAdicionesPostresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionesPostresActionPerformed
        jlImagesMenus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1. Adiciones y Postres.png")));
        jlImagesMenus.setVisible(true);
    }//GEN-LAST:event_jbAdicionesPostresActionPerformed

    private void jbEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEntradasActionPerformed
        jlImagesMenus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1. Entradas y Ceviches.jpg")));
        jlImagesMenus.setVisible(true);
    }//GEN-LAST:event_jbEntradasActionPerformed

    private void jbBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBebidasActionPerformed
        jlImagesMenus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1. Bebidas y Otras Bebidas.jpg")));
        jlImagesMenus.setVisible(true);
    }//GEN-LAST:event_jbBebidasActionPerformed

    private void jbCervezasCoctelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCervezasCoctelesActionPerformed
        jlImagesMenus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1. Cervezas, Cocteles y Sin Licor.jpg")));
        jlImagesMenus.setVisible(true);
    }//GEN-LAST:event_jbCervezasCoctelesActionPerformed

    private void jbLicoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLicoresActionPerformed
        jlImagesMenus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2. Licores.jpg")));
        jlImagesMenus.setVisible(true);
    }//GEN-LAST:event_jbLicoresActionPerformed

    private void jbVinosChilenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVinosChilenosActionPerformed
        jlImagesMenus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1. Vinos.jpg")));
        jlImagesMenus.setVisible(true);
    }//GEN-LAST:event_jbVinosChilenosActionPerformed

    private void jbVinosArgentinosLocalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVinosArgentinosLocalesActionPerformed
        jlImagesMenus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2. Vinos.jpg")));
        jlImagesMenus.setVisible(true);
    }//GEN-LAST:event_jbVinosArgentinosLocalesActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbAdicionesPostres;
    private javax.swing.JButton jbBebidas;
    private javax.swing.JButton jbCerdoPollo;
    private javax.swing.JButton jbCervezasCocteles;
    private javax.swing.JButton jbEnsaladasSopas;
    private javax.swing.JButton jbEntradas;
    private javax.swing.JButton jbLicores;
    private javax.swing.JButton jbPlatosMar;
    private javax.swing.JButton jbResLC;
    private javax.swing.JButton jbSalir;
    private javax.swing.JButton jbVinosArgentinosLocales;
    private javax.swing.JButton jbVinosChilenos;
    private javax.swing.JLabel jlAdicionesPostres;
    private javax.swing.JLabel jlBebidas;
    private javax.swing.JLabel jlBebidasAlcoholicas;
    private javax.swing.JLabel jlCarnes;
    private javax.swing.JLabel jlEnsaladasSopas;
    private javax.swing.JLabel jlEntradas;
    private javax.swing.JLabel jlImagesMenus;
    private javax.swing.JLabel jlMenuTitulo;
    private javax.swing.JLabel jlVinos;
    private javax.swing.JPanel jpMenus;
    private javax.swing.JPanel jpOpciones;
    // End of variables declaration//GEN-END:variables
}