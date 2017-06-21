/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import ControladorClasesTablas.ItemJpaController;
import ControladorClasesTablas.ItemPedidoJpaController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
      
  
    public void  reporteMeseroMes(Integer entrada) throws SQLException
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
            
            parametros.put("Ano", entrada);
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
    
    
     public void  reporteIngresosDiarios(Integer mes, Integer ano) throws SQLException
    {
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres" , "postgres" , "mmllano");
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
            
            
            parametros.put("Ano", ano);
            parametros.put("Mes", mes);
            
            
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
    
    
     public void  reporteTop10MasVendidosMes(Integer ano, Integer mes) throws SQLException
    {
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project_ds" , "postgres" , "");
        try
        {  
           
            try
            {
               report = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteTop10MasVendidosMes.jasper"));
            }
            catch(JRException e)
            {
               System.out.print("Error Generando Reporte " + e.getMessage() + e.getLocalizedMessage());
            }
            
            Map<String, Object> parametros = new HashMap();
            
            parametros.put("ano", ano);
            parametros.put("mes", mes);
            
            System.out.print(" asd " + parametros.get("mes"));
            System.out.print(" asd " + parametros.get("ano"));
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
     
     public void  reporteTop10MenosVendidos(Integer ano, Integer semestre ) throws SQLException
    {
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres" , "postgres" , "");
        try
        {  
           
            try
            {
               report = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteMenosVendidosTop10Semestre.jasper"));
            }
            catch(JRException e)
            {
               System.out.print("Error Generando Reporte" + e.getMessage());
            }
            
            Map<String, Object> parametros = new HashMap();
            
            if(semestre == 1){
                parametros.put("fecha", "01/01/"+ano);
                parametros.put("fecah1", "30/06/"+ano);
            }else{
                parametros.put("fecha", "01/07/"+ano);
                parametros.put("fecha1", "31/12/"+ano);
            }
            System.out.println("sad" + parametros.get("fecha"));
            System.out.println("sad" + parametros.get("fecha1"));
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
     
     
    public void  reporteTiempoPromedioAtencion(Integer ano, Integer semestre) throws SQLException
    {
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres" , "postgres" , "");
        try
        {  
           
            try
            {
               report = (JasperReport) JRLoader.loadObject(getClass().getResource("ReportePromedioAtencion.jasper"));
            }
            catch(JRException e)
            {
               System.out.print("Error Generando Reporte" + e.getMessage());
            }
            
            Map<String, Object> parametros = new HashMap();
            
            if(semestre == 1){
                parametros.put("Semestre_inicio", "01/01"+ano);
                parametros.put("Semestre_fin", "30/06"+ano);
            }else{
                parametros.put("Semestre_inicio", "01/07"+ano);
                parametros.put("Semestre_fin", "31/12"+ano);
            }
            
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
    
    
    public void  reporteSemana(Date dia_inicio, Date dia_fin) throws SQLException
    {
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project_ds" , "postgres" , "");
        try
        {  
           
            try
            {
               report = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteSemanal.jasper"));
            }
            catch(JRException e)
            {
               System.out.print("Error Generando Reporte" + e.getMessage());
            }
            
            Map<String, Object> parametros = new HashMap();
            
            parametros.put("fecha_inicio", dia_inicio);
            parametros.put("fecha_fin", dia_fin);
            
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
