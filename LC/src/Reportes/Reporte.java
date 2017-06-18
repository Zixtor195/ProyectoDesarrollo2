/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
     Connection con = null;
      
  
    public void  reporteMeseroMes() throws SQLException
    {
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres" , "postgres" , "");
        try
        {  
           
            try
            {
               report = (JasperReport) JRLoader.loadObject(getClass().getResource("ReportesMeseroMes.jasper"));
            }
            catch(JRException e)
            {
               System.out.print("Error Generando Reporte" + e.getMessage());
            }
            
            Map parametros = new HashMap();
            
            parametros.put("Ano", Integer.parseInt(JOptionPane.showInputDialog(null,"ingresar el año " )));
            reportFilled = JasperFillManager.fillReport(report, parametros, con);
            JasperViewer jViewer = new JasperViewer(reportFilled, false);
            jViewer.setVisible(true);
            con.close();
        }
        catch(JRException e)
        {
            System.out.print("Error Generando Reporte" + e.getMessage());
        
        }
        
        
    }
    
    
     public void  reporteIngresosDiarios() throws SQLException
    {
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres" , "postgres" , "");
        try
        {  
           
            try
            {
               report = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteIngresosDia.jasper"));
            }
            catch(JRException e)
            {
               System.out.print("Error Generando Reporte" + e.getMessage());
            }
            
            Map<String, Object> parametros = new HashMap();
            
            
            parametros.put("Ano", Integer.parseInt(JOptionPane.showInputDialog(null,"Por Favor ingrese un año " )));
            parametros.put("Mes", Integer.parseInt(JOptionPane.showInputDialog(null,"Por Favor ingrese un mes: " )));
            
            
            reportFilled = JasperFillManager.fillReport(report,parametros , con);
            JasperViewer jViewer = new JasperViewer(reportFilled, false);
            jViewer.setVisible(true);
            con.close();
        }
        catch(JRException e)
        {
            System.out.print("Error Generando Reporte" + e.getMessage());
        
        }
        
        
    }
    
    
     public void  reporteTop10MasVendidosMes() throws SQLException
    {
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres" , "postgres" , "");
        try
        {  
           
            try
            {
               report = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteTop10MasVendidosMew.jasper"));
            }
            catch(JRException e)
            {
               System.out.print("Error Generando Reporte" + e.getMessage());
            }
            
            Map<String, Object> parametros = new HashMap();
            
            parametros.put("Ano", Integer.parseInt(JOptionPane.showInputDialog(null,"Por Favor ingrese un año " )));
            parametros.put("Mes", Integer.parseInt(JOptionPane.showInputDialog(null,"Por Favor ingrese un mes: " )));
            
            
            reportFilled = JasperFillManager.fillReport(report,parametros , con);
            JasperViewer jViewer = new JasperViewer(reportFilled, false);
            jViewer.setVisible(true);
            con.close();
        }
        catch(JRException e)
        {
            System.out.print("Error Generando Reporte" + e.getMessage());
        
        }
        
        
    }
    
    
    
    
    
    
    
    
   
    
}
