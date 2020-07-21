package control;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoPersona;
import model.Persona;


public class ControllerPersona {

	public void enviaDatoEstudiante(int id_persona, String nombre, String apellido, String doc_identidad, String correo, String clave,
			int id_tipo) throws SQLException {

		DaoPersona daoAlumno = new DaoPersona();
		daoAlumno.envioPersona(id_persona, nombre, apellido, doc_identidad, correo, clave, id_tipo);
	}
	
	
	 public ArrayList<Persona> ImprimePersona() throws SQLException{
	        DaoPersona daoalumno;
	        daoalumno = new DaoPersona();
	        return daoalumno.FindAllPersonas();
	    }

}
