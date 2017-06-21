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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private static JasperReport report1;
    private static JasperPrint reportFilled;
    private static JasperPrint reportFilled1;
    private static JasperViewer viewer;
    private static JasperViewer viewer1;
    
    Connection con = null;
      
  
    public void  reporteMeseroMes(Integer entrada) throws SQLException
    {
        
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project_ds" , "postgres" , "");
        try
        {  
           
           
            report = (JasperReport) JRLoader.loadObject(getClass().getResource("ReportesMeseroMes.jasper"));
            
            Map parametros = new HashMap();
            
            parametros.put("Ano", entrada);
            reportFilled = JasperFillManager.fillReport(report, parametros, con);
            JasperViewer jViewer = new JasperViewer(reportFilled, false);
            jViewer.setVisible(true);
            con.close();
        }
        catch(JRException e)
        {
            System.out.print("Error Generando Reporte asd" + e.getMessage());
        
        }
        
        
    }
    
    
     public void  reporteIngresosDiarios(Integer mes, Integer ano) throws SQLException
    {
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project_ds" , "postgres" , "");
        try
        {  
           
            report = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteIngresosDia.jasper"));         
            
            Map<String, Object> parametros = new HashMap();
            
            
            parametros.put("Ano", ano);
            parametros.put("Mes", mes);
            
            
            reportFilled = JasperFillManager.fillReport(report,parametros ,con);
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
           
            report = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteTop10MasVendidosMes.jasper"));
           
            
            Map<String, Object> parametros = new HashMap();
            
            parametros.put("ano", ano);
            parametros.put("mes", mes);
            
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
     
     public void  reporteTop10MenosVendidos(Integer ano, Integer semestre ) throws SQLException, ParseException
    {
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project_ds" , "postgres" , "");
        try
        {  
           
            
            report = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteMenosVendidosTop10Semestre.jasper"));
            report1 = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteMenosVendidosTop10SemestreGrafica.jasper"));
            
            Map<String, Object> parametros = new HashMap();
            
            if (semestre == 1) {
                
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                
                String strFecha = "01/01/" + ano;
                String strFecha1 = "30/06/" + ano;
                Date fechaDate = null;
                Date fechaDate1 = null;

                fechaDate = formato.parse(strFecha);
                fechaDate1 = formato.parse(strFecha1);
                
                parametros.put("fecha", fechaDate);
                parametros.put("fecha1", fechaDate1);
            } else {
                
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                
                String strFecha = "01/07/" + ano;
                String strFecha1 = "31/12/" + ano;
                Date fechaDate = null;
                Date fechaDate1 = null;

                fechaDate = formato.parse(strFecha);
                fechaDate1 = formato.parse(strFecha1);
                parametros.put("fecha", fechaDate);
                parametros.put("fecha1", fechaDate1);
                
            }
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
     
     
    public void  reporteTiempoPromedioAtencion(Integer ano, Integer semestre) throws SQLException, ParseException
    {
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project_ds" , "postgres" , "");
        try
        {  
           
           report = (JasperReport) JRLoader.loadObject(getClass().getResource("ReportePromedioAtencion.jasper"));
//           report1 = (JasperReport) JRLoader.loadObject(getClass().getResource("ReportePromedioAtencionGrafico.jasper"));

            Map<String, Object> parametros = new HashMap();
            
            if(semestre == 1){
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                
                String strFecha = "01/01/" + ano;
                String strFecha1 = "30/06/" + ano;
                Date fechaDate = null;
                Date fechaDate1 = null;

                fechaDate = formato.parse(strFecha);
                fechaDate1 = formato.parse(strFecha1);
                
                parametros.put("Semestre_inicio", fechaDate);
                parametros.put("Semestre_fin", fechaDate1);
            }else{
                
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
               
                String strFecha = "01/07/" + ano;
                String strFecha1 = "31/12/" + ano;
                Date fechaDate = null;
                Date fechaDate1 = null;

                fechaDate = formato.parse(strFecha);
                fechaDate1 = formato.parse(strFecha1);
                parametros.put("fecha", fechaDate);
                parametros.put("fecha1", fechaDate1);
                parametros.put("Semestre_inicio", fechaDate);
                parametros.put("Semestre_fin", fechaDate1);
            }
            
            reportFilled = JasperFillManager.fillReport(report,parametros , con);
//            reportFilled1 = JasperFillManager.fillReport(report1,parametros , con);
            JasperViewer jViewer = new JasperViewer(reportFilled, false);
//            JasperViewer jViewer1 = new JasperViewer(reportFilled1, false);
            jViewer.setVisible(true);
//            jViewer1.setVisible(true);
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
           
           report = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteSemanal.jasper"));
           report1 = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteSemanalGrafico.jasper"));
            
            Map<String, Object> parametros = new HashMap();
            
            parametros.put("fecha_inicio", dia_inicio);
            parametros.put("fecha_fin", dia_fin);
            
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
    
    
}
