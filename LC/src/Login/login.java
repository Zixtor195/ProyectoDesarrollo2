/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import ClasesTablas.Empleado;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;


public class login 
{
    private Connection conexion;
    private String usuario, contrasena, baseDatos;
    private ResultSet resultado;
    private Statement sentencia;
    
public ArrayList ValidarLogin(String usuario, String contrasena) throws SQLException {

        EntityManagerFactory emf = Persistence 
                .createEntityManagerFactory("LCPU"); 
        EntityManager em = emf.createEntityManager(); 
        
      String jpql = "SELECT id_empleado,nombres,cargo FROM empleado WHERE usuario = '" + usuario + "' AND contrase = '" + contrasena + "' AND estado = 'Activo';";
      Query query = em.createNativeQuery(jpql);
      List<Object[]> results = query.getResultList();
      ArrayList resulConsulta = new ArrayList<>();
         
        String criptedpass = new Encriptar().EncriptarMd5(contrasena);
        
        
            if (results.size() == 0) {
                resulConsulta = null;

            } else {
                    
                for (Object[] result : results) {
                resulConsulta.add(result[0]);
                resulConsulta.add(result[1]);
                resulConsulta.add(result[2]);        
  }
               
            }

       

        emf.close();
        return resulConsulta;
    }











    
}
