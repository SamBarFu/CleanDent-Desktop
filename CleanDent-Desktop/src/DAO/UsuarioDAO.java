
package DAO;

import DB.SQLusuario;
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
    
    private boolean estado=false;
    
    public boolean loginUsuario(Connection c, Usuario usuario){       
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select u.usuario, u.contrasena from usuario u where usuario=?  and contrasena=?";

        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContrasena());
            rs = ps.executeQuery();

            if (rs.next()) {
                estado = true;                               
            }else{
                estado = false;
            }
               
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return estado;
    }    
}
