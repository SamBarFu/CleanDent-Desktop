
package Negocio;

import DAO.UsuarioDAO;
import DB.Conexion;
import POJO.Empleado;
import POJO.Mensaje;
import POJO.Usuario;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samuel Barberena
 */
public class UsuarioBO {
    
    Mensaje mensaje = new Mensaje();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public List<Object> loginUsuario(Usuario usuario){
        Connection con = Conexion.getConexion();
        List<Object> result = new ArrayList<Object>();
        Empleado empleado = usuarioDAO.loginUsuario(con, usuario);
        try { 
            if(empleado != null){
                mensaje.setEstado(true);
                mensaje.setText("Bienvenido Dr. "+empleado.getPrimerApellido());
            }else{
                mensaje.setEstado(false);
                mensaje.setText("Usuario o contrasena incorrecta"); 
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }      
        result.add(empleado);
        result.add(mensaje);
        return result;
    }
    
}
