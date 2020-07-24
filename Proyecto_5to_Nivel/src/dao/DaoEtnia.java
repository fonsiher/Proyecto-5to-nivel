package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.Cls_conexion;
import model.Etnia;


public class DaoEtnia {
	
	public ArrayList<Etnia> FindAllEtnias() throws SQLException {
		ArrayList<Etnia> et = new ArrayList<>();

		ResultSet re;
		Cls_conexion cl = new Cls_conexion();
		re = cl.consulta("select * from dim_etnia");
		int sk_etnia;
		int pk_etnia;
		String etnia;
		Date valido_desde;
		Date valido_hasta;
		int version;
		while (re.next()) {
			sk_etnia = re.getInt(1);
			pk_etnia = re.getInt(2);
			etnia = re.getString(3);
			valido_desde = re.getDate(4);
			valido_hasta = re.getDate(5);
			version = re.getInt(6);
			et.add(new Etnia(sk_etnia,pk_etnia,etnia,valido_desde,valido_hasta,version));
		}
		return et;
	}
	
	public ArrayList<String> getEtnias(){
		ArrayList<String> lista_etnias = new ArrayList<>();
		try {
			ResultSet re;
			Cls_conexion cl = new Cls_conexion();
			re = cl.consulta("select * from dim_etnia");
			//String genero;
			while (re.next()) {
				
				lista_etnias.add(re.getString(3));
			}
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		return lista_etnias;
	}

}
