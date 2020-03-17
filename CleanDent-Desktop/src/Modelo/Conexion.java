/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Josue Vargas
 */
public class Conexion {

    public static PreparedStatement prepareStatement(String insert_into_person_values_null) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private final String base = "sistema_citas_dentales";
    private final String user = "Admin";
    private final String password = "123456";
    private final String url = "jdbc:mysql://127.0.0.1:3306/" + base;
    private Connection con = null;
    
    public Connection getConexion()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    
    public ResultSet consulta(String sql){
        ResultSet res = null;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            res = ps.executeQuery();
        }
        catch(SQLException e){
            System.err.println("Error Consulta: " + e.getMessage());
        }
        return res;
    }
public DefaultComboBoxModel ObtenerTratamiento(){
    
    
    DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
    ListaModelo.addElement("Seleccione");
    ResultSet res = this.consulta("SELECT * FROM tratamiento ORDER BY nombre");
    
    try{
        
        while(res.next()){
            ListaModelo.addElement(res.getString("nombre"));
        }
        res.close();
    }catch(SQLException ex){
        
        System.err.println(ex.getMessage());    
    }
    return ListaModelo;
}

public DefaultComboBoxModel ObtenerServicio(){
    
    
    DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
    ListaModelo.addElement("Seleccione");
    ResultSet res = this.consulta("SELECT * FROM servicio ORDER BY nombre");
    
    try{
        
        while(res.next()){
            ListaModelo.addElement(res.getString("nombre"));
        }
        res.close();
    }catch(SQLException ex){
        
        System.err.println(ex.getMessage());    
    }
    return ListaModelo;
}
    
}
