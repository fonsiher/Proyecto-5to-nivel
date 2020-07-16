package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cls_conexion;
import model.User;
import model.clsAlumnos;
import model.clsProfesor;
public class DaoUser {
    
    public ArrayList<User> FindAllUser() throws SQLException{
        ArrayList<User> users=new ArrayList<>();
        
        ResultSet re;
        Cls_conexion cl=new Cls_conexion();
        re = cl.consulta("select * from usuario");
        String nom;
        String con;
        int perfil;
        while (re.next()){
            nom = re.getString("nombre_usuario");
            con = re.getString("contrasena");
            perfil = re.getInt("id_perfil");
            users.add(new User(nom,con,perfil));
        }
        return users;
    }
    
    public ArrayList<User> envioUser(String user,String pass,int perfil) throws SQLException{
        User u=new User();
        u.setUser(user);
        u.setPass(pass);
        u.setPerfil(perfil);
        Cls_conexion cl=new Cls_conexion();
        cl.ejecutar("insert into usuario values ("+perfil+",'" + user + "','" + pass + "');");
        
        return this.FindAllUser();
    }      
    
    public void eliminarUser(clsAlumnos alumnos) throws SQLException {

        Cls_conexion cl = new Cls_conexion();
        PreparedStatement st = cl.getConexion().prepareStatement("delete from usuario where nombre_usuario = ? ");
        st.setString(1, alumnos.getNombre_usuario());
        st.executeUpdate();

    }
    
    public void eliminarProfe(clsProfesor profesor) throws SQLException {

        Cls_conexion cl = new Cls_conexion();
        PreparedStatement st = cl.getConexion().prepareStatement("delete from usuario where nombre_usuario = ? ");
        st.setString(1, profesor.getNombre_usuario());
        st.executeUpdate();

    }
}
