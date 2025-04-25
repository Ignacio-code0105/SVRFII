/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class PRUEBA {

    public static void main(String[] args) {
       String usuario="root";
       String password="";
       String url="jdbc:mysql://localhost:3306/jdbctext";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs =statement.executeQuery("SELECT *FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
                
            }
           
            //insercion de datos
            statement.execute("INSERT INTO `usuarios` (`ID`, `NOMBRE`, `APELLIDO`) VALUES (NULL, 'NACHO', '');");
            System.out.println("");
            rs =statement.executeQuery("SELECT *FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            //Actualizacion de datos 
            statement.execute("UPDATE `usuarios` SET `NOMBRE` = 'SANTIAGO' WHERE `usuarios`.`ID` = 1; ");
            System.out.println("");
            rs =statement.executeQuery("SELECT *FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            //Eliminacion de datos 
            statement.execute("DELETE FROM `usuarios` WHERE `usuarios`.`ID` = 3");
            System.out.println("");
            rs =statement.executeQuery("SELECT *FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PRUEBA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
}
