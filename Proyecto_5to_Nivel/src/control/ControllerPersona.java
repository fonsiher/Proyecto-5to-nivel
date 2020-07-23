package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.context.FacesContext;
import dao.DaoPersona;
import model.Persona;




public class ControllerPersona {

	public String enviaDatoEstudiante(int id_persona, String nombre, String apellido, String doc_identidad,
			String correo, String clave, int id_tipo) {
		DaoPersona daoAlumno = new DaoPersona();
		String respuesta = "";
		try {
			daoAlumno.envioPersona(id_persona, nombre, apellido, doc_identidad, correo, clave, id_tipo);
			respuesta = "RegCor";
		} catch (Exception e) {
			respuesta = "no";
		}

		return respuesta;
	}

	public String agregarPersona(int id_persona, String nombre, String apellido, String doc_identidad, String correo,
			String clave, int id_tipo) {
		DaoPersona daoAlumno = new DaoPersona();
		String respuesta = daoAlumno.RegistrarUsuario(id_persona, nombre, apellido, doc_identidad, correo, clave,
				id_tipo);
		return respuesta;
	}

	public String eliminarPersona(Persona persona)  {

		DaoPersona daoalumno = new DaoPersona();
		String respuesta = daoalumno.eliminarPer(persona);
		return respuesta;
		
	}
	
    public void modificarPersona(Persona persona)throws SQLException{
        
        DaoPersona daoAlumno = new DaoPersona();
        daoAlumno.modificarPer(persona);   
    }
	
	

	public void forward() throws IOException {
		String uri = "destination.xhtml";
		FacesContext.getCurrentInstance().getExternalContext().dispatch(uri);
	}

	public ArrayList<Persona> ImprimePersona() throws SQLException {
		DaoPersona daoalumno;
		daoalumno = new DaoPersona();
		return daoalumno.FindAllPersonas();
	}
	
public Persona leerIDPersona(Persona persona) throws Exception{
        
        DaoPersona daoAlumno = new DaoPersona();
        return daoAlumno.LeerID(persona);                
    }

}
