package App;

import POJO.*;
import DB.Conexion;
import Presentación.Login;
import Presentación.RegistroUsuario;

/**
 *
 * @author Isabella
 */
public class App {
    
    Empleado empleado;

    public static void main(String[] args) {
        /*new Login().setVisible(true);*/
        
        Conexion c = new Conexion();
        
        c.getConexion();
        
    }
    
    
    
}
