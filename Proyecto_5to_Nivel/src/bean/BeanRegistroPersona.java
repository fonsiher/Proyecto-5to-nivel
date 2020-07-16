package bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import control.ControllerPersona;
import model.Persona;


@Named(value="beanRegistroPersona")
@SessionScoped
public class BeanRegistroPersona implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_persona;
	private String nombre;
    private String apellido;
    private String doc_identidad;
    private String correo_electronico;
    private int id_tipo;
    private Persona persona = new Persona();
	
	public BeanRegistroPersona () {
		
	}

	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDoc_identidad() {
		return doc_identidad;
	}

	public void setDoc_identidad(String doc_identidad) {
		this.doc_identidad = doc_identidad;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public int getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	
	public void almaceneDatosPersona() throws SQLException{
        int perfil = 2;
        ControllerPersona controller =new ControllerPersona();
        controller.enviaDatoEstudiante(id_persona,nombre,apellido,doc_identidad,correo_electronico,perfil);
    }
	
	public ArrayList<Persona> listaPersona() throws SQLException{
        ControllerPersona controller =new ControllerPersona();
        return controller.ImprimePersona();
   }
	
    public String irEdicion(){
    return "editar_user";
    } 
    
    public String irMenu(){
    return "menuadmin";
    } 
	
	
}
