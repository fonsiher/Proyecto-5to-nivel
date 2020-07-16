package model;

public class Persona {
	private int id_persona;
	private String nombre;
    private String apellido;
    private String doc_identidad;
    private String correo_electronico;
    private int id_tipo;
    
    public Persona() {
    	
    }
    
    public Persona(int id_persona,String nombre, String apellido, String doc_identidad, String correo, int id_tipo) {
    	this.id_persona = id_persona;
    	this.nombre= nombre;
    	this.apellido = apellido;
    	this.doc_identidad= doc_identidad;
    	this.correo_electronico = correo;
    	this.id_tipo = id_tipo;
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
    
    

}
