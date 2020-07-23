package dao;

import java.sql.PreparedStatement;
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
		String clave;
		int id_tipo;
		while (re.next()) {
			id_persona = re.getInt(1);
			nombre = re.getString(2);
			apellido = re.getString(3);
			doc_identidad = re.getString(4);
			correo_electronico = re.getString(5);
			clave = re.getString(6);
			id_tipo = re.getInt(7);
			persona.add(new Persona(id_persona, nombre, apellido, doc_identidad, correo_electronico, clave, id_tipo));
		}
		return persona;
	}

	public ArrayList<Persona> envioPersona(int id_persona, String nombre, String apellido, String doc_identidad,
			String correo, String clave, int id_tipo) throws SQLException {
		Persona persona = new Persona(id_persona, nombre, apellido, doc_identidad, correo, clave, 2);
		persona.setId_persona(id_persona);
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setDoc_identidad(doc_identidad);
		persona.setCorreo_electronico(correo);
		persona.setClave(clave);
		persona.setId_tipo(id_tipo);

		Cls_conexion cl = new Cls_conexion();
		cl.ejecutar(
				"insert into persona (nombre, apellido, doc_identidad, correo_electronico, clave, id_tipo) values ('"
						+ nombre + "','" + apellido + "','" + doc_identidad + "','" + correo + "','" + clave + "','" + 2
						+ "');");
		return this.FindAllPersonas();

	}

	public String RegistrarUsuario(int id_persona, String nombre, String apellido, String doc_identidad, String correo,
			String clave, int id_tipo) {
		String result = "";
		Cls_conexion cl = new Cls_conexion();
		PreparedStatement pr = null;
		String sql = "INSERT INTO persona(nombre, apellido, doc_identidad, correo_electronico, clave, id_tipo)";
		sql += "VALUES(?,?,?,?,?,?)";
		try {
			pr = cl.getConexion().prepareStatement(sql);
			pr.setString(1, nombre);
			pr.setString(2, apellido);
			pr.setString(3, doc_identidad);
			pr.setString(4, correo);
			pr.setString(5, clave);
			pr.setInt(6, 2);

			if (pr.executeUpdate() == 1) {
				result = "RegCor";
			} else {
				result = "no";
			}
		} catch (Exception ex) {
			result = ex.getMessage();
		} finally {
			try {
				pr.close();
				cl.getConexion().close();
			} catch (Exception ex) {
				result = ex.getMessage();
			}
		}

		return result;
	}

	public String eliminarEst(String cedula) {
		String result = "";
		PreparedStatement st = null;
		Cls_conexion cl = new Cls_conexion();
		try {
			st = cl.getConexion().prepareStatement("delete from alumnos where cedula = ? ");
			st.setString(1, cedula);
			if (st.executeUpdate() == 1) {
				result = "eliminado";
			} else {
				result = "noelim";
			}
		} catch (Exception ex) {

			result = ex.getMessage();
		} finally {
			try {
				st.close();
				cl.getConexion().close();
			} catch (Exception ex) {
				result = ex.getMessage();
			}
		}
		return result;

	}

}