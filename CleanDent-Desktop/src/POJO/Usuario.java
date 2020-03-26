
package POJO;

import java.util.Date;

/**
 *
 * @author Samuel Barberena
 */
public class Usuario {
    
    private int id;
    private Empleado empleado;
    private String usuario;
    private String contrasena;
    private Date lastSession;
    private boolean estado;

    public Usuario() {
    }

    public Usuario(Empleado empleado, String usuario, String contrasena, boolean estado) {
        this.empleado = empleado;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getLastSession() {
        return lastSession;
    }

    public void setLastSession(Date lastSession) {
        this.lastSession = lastSession;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", empleado=" + empleado + ", usuario=" + usuario + ", contrasena=" + contrasena + ", lastSession=" + lastSession + ", estado=" + estado + '}';
    }
        
}
