
package Negocio;

import DAO.UsuarioDAO;
import DB.Conexion;
import POJO.Mensaje;
import POJO.Usuario;
import java.sql.Connection;

/**
 *
 * @author Samuel Barberena
 */
public class UsuarioBO {
    
    Mensaje mensaje = new Mensaje();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public Mensaje loginUsuario(Usuario usuario){
        Connection con = Conexion.getConexion();
        try { 
            if(usuarioDAO.loginUsuario(con, usuario)){
                mensaje.setEstado(true);
                mensaje.setText("Bienvenido"); 
            }else{
                mensaje.setEstado(false);
                mensaje.setText("Usuario o contrasena incorrecta"); 
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mensaje;
    }
    
}
