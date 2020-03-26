/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josue Vargas
 */
public class SQLusuario extends Conexion {

    public boolean registrar(Usuario usr) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO usuario(usuario,password,idtipousuario) VALUES(?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            ps.setString(2, usr.getPassword());
            ps.setInt(3, usr.getIdtipousuario());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SQLusuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public int ExisteUsuario(String usuario) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "Select count(idusuario) from usuario where usuario = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(SQLusuario.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }

    public boolean Login(Usuario usr) {

        /*PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "Select u.idusuario, u.usuario,password, u.idtipousuario, t.Nombre from usuario u "
                + "INNER JOIN tipousuario t ON u.idtipousuario = t.idtipousuario where usuario = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {

                if (usr.getPassword().equals(rs.getString(3))) {

                    String sqlUpdate = "UPDATE usuario SET last_session = ? WHERE idusuario=?";

                    ps = con.prepareStatement(sqlUpdate);
                    ps.setString(1, usr.getLast_session());
                    ps.setInt(2, rs.getInt(1));
                    ps.execute();

                    usr.setId(rs.getInt(1));
                    usr.setIdtipousuario(rs.getInt(4));
                    usr.setNombre_tipo(rs.getString(5));
                    return true;
                } else {
                    return false;
                }

            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(SQLusuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }*/
        
        return true;
    }

}
