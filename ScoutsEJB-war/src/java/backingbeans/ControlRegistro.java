/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import Negocio.CuentaRepetidaException;
import Negocio.NegocioException;
import Negocio.NegocioRegistroLocal;
import entidadesJPA.Usuario;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author ADRIAN LUACES
 */
@Named(value = "controlRegistro")
@RequestScoped
public class ControlRegistro {

    private Usuario usuario;
    @EJB
    private NegocioRegistroLocal negocio;

    
   
    private boolean registroOK;
    
    public ControlRegistro() {
        usuario = new Usuario();
    }
    
    public boolean isRegistroOK() {
        return registroOK;
    }
   
    public void setRegistronOk(boolean registroOK) {
        this.registroOK = registroOK;
    }
 
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String registrarUsuario() {
        try {
            
     
            negocio.registrarUsuario(usuario);
            registroOK = true;
            return "exitoRegistro.xhtml";
            
        } catch (CuentaRepetidaException e) {
            FacesMessage fm = new FacesMessage("Existe un usuario con la misma cuenta");
            FacesContext.getCurrentInstance().addMessage("inscripcion:alias", fm);
            
        } catch (NegocioException e) {
        }
        return null;
    }
    
}
