
package DAO;

import DB.SQLusuario;
import POJO.Empleado;
import POJO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel Barberena
 */
public class UsuarioDAO {
    
    //private boolean estado=false;
    
    public Empleado loginUsuario(Connection c, Usuario usuario){       
        PreparedStatement ps = null;
        ResultSet rs = null;
        Empleado empleado=null;

        String sql = "select e.id_empleado, e.primer_nombre, e.primer_apellido, r.id_rol, e.foto from usuario u " +
                     "inner join empleado e on u.id_empleado=e.id_empleado " +
                     "inner join rol r on r.id_rol=e.id_rol " +
                     "where usuario=? and contrasena=?";
        
        //String sql = "select * from usuario where usuario=? and contrasena=?";

        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContrasena());
            rs = ps.executeQuery();

            if (rs.next()) {
                empleado = new Empleado();
                empleado.setId(rs.getInt(1));
                empleado.setPrimerNombre(rs.getString(2));
                empleado.setPrimerApellido(rs.getString(3));
                empleado.setRol(Empleado.Rol.values()[rs.getInt(4)-1]);
                empleado.setFoto(rs.getString(5)); 
                
            }else{
                return empleado;
            }
               
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return empleado;
    }    
}
