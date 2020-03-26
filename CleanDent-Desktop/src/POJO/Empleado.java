
package POJO;

import java.sql.Date;

/**
 *
 * @author Samuel Barberena
 */
public class Empleado extends Persona{
    
    private int id;
    private String correo;
    private String foto;
    private boolean estado;

    public Empleado() {
    }

    public Empleado(int id, String correo, String foto, boolean estado, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String cedula, Date fechaNacimiento, char genero) {
        super(primerNombre, segundoNombre, primerApellido, segundoApellido, cedula, fechaNacimiento, genero);
        this.id = id;
        this.correo = correo;
        this.foto = foto;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", correo=" + correo + ", foto=" + foto + ", estado=" + estado + '}';
    } 
    
}