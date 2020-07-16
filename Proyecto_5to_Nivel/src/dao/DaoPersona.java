package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cls_conexion;
import model.Persona;



public class DaoPersona {
	
	 public ArrayList<Persona> FindAllPersonas() throws SQLException {
	        ArrayList<Persona> persona = new ArrayList<>();

	        ResultSet re;
	        Cls_conexion cl = new Cls_conexion();
	        re = cl.consulta("select * from persona");
	        int id_persona;
	        String nombre;
	        String apellido;
	        String doc_identidad;
	        String correo_electronico;
	        int id_tipo;
	        while (re.next()) {
	        	id_persona = re.getInt(1);
	            nombre = re.getString(2);
	            apellido = re.getString(3);
	            doc_identidad= re.getString(4);
	            correo_electronico = re.getString(5);
	            id_tipo = re.getInt(6);
	            persona.add(new Persona(id_persona,nombre,apellido,doc_identidad,correo_electronico,id_tipo));
	        }
	        return persona;
	    }
	 
	 public ArrayList<Persona> envioPersona(int id_persona,String nombre, String apellido, String doc_identidad, String correo, int id_tipo) 
			 throws SQLException {
		 	Persona persona = new Persona(id_persona,nombre,apellido,doc_identidad,correo,id_tipo);
	        persona.setNombre(nombre);
	        persona.setApellido(apellido);
	        persona.setDoc_identidad(doc_identidad);
	        persona.setCorreo_electronico(correo);
	        persona.setId_tipo(id_tipo);

	        Cls_conexion cl = new Cls_conexion();
	        cl.ejecutar("insert into alumnos values ('" + nombre + "','" + apellido + "','" + doc_identidad + "','" 
	        + correo + "','" + id_tipo +"' );");

	        return this.FindAllPersonas();
				
			
	    }
	 
	 }
