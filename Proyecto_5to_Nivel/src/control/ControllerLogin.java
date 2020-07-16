/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DaoUser;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;
import model.clsAlumnos;


public class ControllerLogin {
    
    public int login(String user,String pass) throws SQLException{
        DaoUser daouser= new DaoUser();
        for(User u: daouser.FindAllUser()){
            if (u.getUser().equals(user)&& u.getPass().equals(pass)) {
                return u.getPerfil();
            } 
        }
        return 0;
    }
    
    
    public void enviaDato(String user,String pass,int perfil) throws SQLException{
        DaoUser daoUser= new DaoUser();
        daoUser.envioUser(user, pass,perfil);    
    }
    
    public ArrayList<User> usersList() throws SQLException{
        DaoUser daouser;
        daouser = new DaoUser();
        return daouser.FindAllUser();
    }
    
    public void eliminarUsuario(clsAlumnos alumn) throws SQLException{
        
        DaoUser daousuario = new DaoUser();
        daousuario.eliminarUser(alumn);
    }
    

}
