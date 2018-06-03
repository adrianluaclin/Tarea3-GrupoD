/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import Negocio.NegocioValidarUsuarioLocal;
import entidadesJPA.Registro_seccion;
import entidadesJPA.Rol;
import entidadesJPA.Seccion;
import entidadesJPA.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "controlValidacionUsuario")
@RequestScoped
public class ControlValidacionUsuario {
    
    private Usuario user;
    private Registro_seccion reg_sec;
    private Seccion secc;
    private Rol rol;

    

  
    @EJB
    private NegocioValidarUsuarioLocal negocio;
    
    public ControlValidacionUsuario() {
        secc = new Seccion();
        reg_sec = new Registro_seccion();
        
    }
   
    public List<Usuario> userNoValidados(){
        return negocio.noValidado();
      
    }
    
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public Usuario getUser() {
        return user;
    }

    public String setUser(Usuario user) {
        this.user = user;
        return "formulario-validacion.xhtml";
    }
    

    public Registro_seccion getReg_sec() {
        return reg_sec;
    }

    public void setReg_sec(Registro_seccion reg_sec) {
        this.reg_sec = reg_sec;
    }

    public Seccion getSecc() {
        return secc;
    }

    public void setSecc(Seccion secc) {
        this.secc = secc;
    }

    public String crearRegistro() {
        negocio.crearSecc(reg_sec, user, secc);
        return null;
    }
    
    public String validar(){
        negocio.validar(user);
        return "validar-usuario.xhtml";
    }
    
    public String rol(){
        negocio.rol(user, rol);
        return null;
    }
    
    
    
}
