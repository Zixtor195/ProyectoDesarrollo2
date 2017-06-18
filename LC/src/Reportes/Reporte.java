/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private static JasperReport report1;
    private static JasperPrint reportFilled;
    private static JasperPrint reportFilled1;
    private static JasperViewer viewer;
    private static JasperViewer viewer1;
    
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
               report = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteTop10MasVendidosMes.jasper"));
               report1 = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteTop10MasVendidosMesGrafica.jasper"));
            }
            catch(JRException e)
            {
               System.out.print("Error Generando Reporte" + e.getMessage());
            }
            
            Map<String, Object> parametros = new HashMap();
            
            parametros.put("fecha", Integer.parseInt(JOptionPane.showInputDialog(null,"Por Favor ingrese un año " )));
            parametros.put("fecha1", Integer.parseInt(JOptionPane.showInputDialog(null,"Por Favor ingrese un mes: " )));
            
            
            reportFilled = JasperFillManager.fillReport(report,parametros , con);
            reportFilled1 = JasperFillManager.fillReport(report1,parametros , con);
            JasperViewer jViewer = new JasperViewer(reportFilled, false);
            JasperViewer jViewer1 = new JasperViewer(reportFilled1, false);
            jViewer.setVisible(true);
            jViewer1.setVisible(true);
            con.close();
        }
        catch(JRException e)
        {
            System.out.print("Error Generando Reporte" + e.getMessage());
        
        }
    }
    
    
     public void  reporteTop10MenosVendidosSemestre() throws SQLException
    {
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres" , "postgres" , "");
        try
        {  
           String opcion = JOptionPane.showInputDialog(null, "¿Primer o segundo semestre del año? 1. Primero 2. Segundo ");
           
           if(opcion.equals("1")){
               
            try
            {
               report = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteMenosVendidosTop10Semestre.jasper"));
               report1 = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteMenosVendidosTop10SemestreGrafica.jasper"));
            }
            catch(JRException e)
            {
               System.out.print("Error Generando Reporte" + e.getMessage());
            }
            
            Map<String, Object> parametros = new HashMap();
            
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
            
            parametros.put("fecha", "01/01/" + sdf.format(date));
            parametros.put("fecha1", "30/06/" + sdf.format(date));
            
            
            reportFilled = JasperFillManager.fillReport(report,parametros , con);
            JasperViewer jViewer = new JasperViewer(reportFilled, false);
            jViewer.setVisible(true);
            con.close();
            
            reportFilled1 = JasperFillManager.fillReport(report1,parametros , con);
            JasperViewer jViewer1 = new JasperViewer(reportFilled1, false);
            jViewer1.setVisible(true);
            con.close();
            
            }else{
               
               try
            {
               report = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteMenosVendidosTop10Semestre.jasper"));
               report1 = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteMenosVendidosTop10SemestreGrafica.jasper"));
            }
            catch(JRException e)
            {
               System.out.print("Error Generando Reporte" + e.getMessage());
            }
            
            Map<String, Object> parametros = new HashMap();
            
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
            
            parametros.put("fecha", "01/07/" + sdf.format(date).toString());
            parametros.put("fecha1", "31/12/" + sdf.format(date).toString());
            
            
            reportFilled = JasperFillManager.fillReport(report,parametros , con);
            reportFilled1 = JasperFillManager.fillReport(report1,parametros , con);
            JasperViewer jViewer = new JasperViewer(reportFilled, false);
            JasperViewer jViewer1 = new JasperViewer(reportFilled1, false);
            jViewer.setVisible(true);
            jViewer1.setVisible(true);
            con.close();
           }
        }
        catch(JRException e)
        {
            System.out.print("Error Generando Reporte" + e.getMessage());
        
        }
    }
    
    
     
     public void  reportePromedioServicioSemestre() throws SQLException
    {
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres" , "postgres" , "");
        try
        {  
           String opcion = JOptionPane.showInputDialog(null, "¿Primer o segundo semestre del año? 1. Primero 2. Segundo ");
           
           if(opcion.equals("1")){
               
            try
            {
               report = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteMenosVendidosTop10Semestre.jasper"));
               report1 = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteMenosVendidosTop10SemestreGrafica.jasper"));
            }
            catch(JRException e)
            {
               System.out.print("Error Generando Reporte" + e.getMessage());
            }
            
            Map<String, Object> parametros = new HashMap();
            
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
            
            parametros.put("fecha", "01/01/" + sdf.format(date));
            parametros.put("fecha1", "30/06/" + sdf.format(date));
            
            
            reportFilled = JasperFillManager.fillReport(report,parametros , con);
            reportFilled1 = JasperFillManager.fillReport(report1,parametros , con);
            JasperViewer jViewer = new JasperViewer(reportFilled, false);
            JasperViewer jViewer1 = new JasperViewer(reportFilled1, false);
            jViewer.setVisible(true);
            jViewer1.setVisible(true);
            con.close();
            
            }else{
               
               try
            {
               report = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteMenosVendidosTop10Semestre.jasper"));
               report1 = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteMenosVendidosTop10SemestreGrafica.jasper"));
            }
            catch(JRException e)
            {
               System.out.print("Error Generando Reporte" + e.getMessage());
            }
            
            Map<String, Object> parametros = new HashMap();
            
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
            
            parametros.put("fecha", "01/07/" + sdf.format(date));
            parametros.put("fecha1", "31/12/" + sdf.format(date));
            
            
            reportFilled = JasperFillManager.fillReport(report,parametros , con);
            reportFilled1 = JasperFillManager.fillReport(report1,parametros , con);
            JasperViewer jViewer = new JasperViewer(reportFilled, false);
            JasperViewer jViewer1 = new JasperViewer(reportFilled1, false);
            jViewer.setVisible(true);
            jViewer1.setVisible(true);
            con.close();
           }
        }
        catch(JRException e)
        {
            System.out.print("Error Generando Reporte" + e.getMessage());
        
        }
    }
    
    
    
   
    
}
