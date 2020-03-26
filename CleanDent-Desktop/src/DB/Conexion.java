package DB;

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
import javax.swing.JOptionPane;


public class Conexion {

    /*public static PreparedStatement prepareStatement(String insert_into_person_values_null) {
        throw new UnsupportedOperationException("Not supported yet.");
    }*/

    private static final String base = "clean_dent";
    private static final String user = "root_test";
    private static final String password = "123456";
    private static final String url = "jdbc:mysql://localhost/" + base;
    private static Connection con = null;

    public static Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
          
            con.setAutoCommit(false);
            
            if(con != null){                
                System.out.println("Conexión exitosa");
            }else{
                System.out.println("No se pudo conectar con el servidor");
            }
   
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar con el servidor"+"\n\n"+ex.getMessage());
        }
        return con;
    }  

    public ResultSet consulta(String sql) {
        ResultSet res = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            res = ps.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error Consulta: " + e.getMessage());
        }
        return res;
    }

    public DefaultComboBoxModel ObtenerTratamiento() {

        DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
        ListaModelo.addElement("Seleccione");
        ResultSet res = this.consulta("SELECT * FROM tratamiento ORDER BY nombre");

        try {

            while (res.next()) {
                ListaModelo.addElement(res.getString("nombre"));
            }
            res.close();
        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
        return ListaModelo;
    }

    public DefaultComboBoxModel ObtenerServicio() {

        DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
        ListaModelo.addElement("Seleccione");
        ResultSet res = this.consulta("SELECT * FROM servicio ORDER BY nombre");

        try {

            while (res.next()) {
                ListaModelo.addElement(res.getString("nombre"));
            }
            res.close();
        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
        return ListaModelo;
    }

}
