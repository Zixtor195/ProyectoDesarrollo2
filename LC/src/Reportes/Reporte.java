/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Moni
 */
public class Reporte {

    private static JasperReport report;
    private static JasperPrint reportFilled;
    private static JasperViewer viewer;
  
    public void  generar_reporte() throws SQLException
    {
        try
        {   Connection con = null;
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres" , "postgres" , "mmllano");
           
            try
            {
               report = (JasperReport) JRLoader.loadObject(getClass().getResource("ReportesMeseroMes.jasper"));
            }
            catch(JRException e)
            {
               System.out.print("Error Generando Reporte" + e.getMessage());
            }
            
            Map parametros = new HashMap();
            int ano = Integer.parseInt(JOptionPane.showInputDialog(null,"ingresar el año" ));
            parametros.put("ano", ano);
            reportFilled = JasperFillManager.fillReport(report, parametros, con);
            JasperViewer jViewer = new JasperViewer(reportFilled, false);
            jViewer.setVisible(true);
        }
        catch(JRException e)
        {
            System.out.print("Error Generando Reporte" + e.getMessage());
        
        }
    }
    
    
   
    
}
