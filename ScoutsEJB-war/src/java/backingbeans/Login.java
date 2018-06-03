/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import Negocio.ContraseniaInvalidaException;
import Negocio.CuentaInactivaException;
import Negocio.CuentaInexistenteException;
import Negocio.NegocioAutenticarLocal;
import Negocio.NegocioException;
import entidadesJPA.Usuario;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "login")
@RequestScoped
public class Login {

    
    private Usuario usuario;
    @EJB
    private NegocioAutenticarLocal negocio;
    
    
    @Inject
    private ControlAutorizacion ctrl;
    /**
     * Creates a new instance of Login
     */
    public Login() {
       usuario= new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario= usuario;
    }

    public String autenticar() {
        // Implementar este método
      
        try {
              negocio.compruebaLogin(usuario);
              ctrl.setUsuario(usuario);
              return ctrl.home();

        } catch (CuentaInexistenteException e) {
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("inicio:us", fm);
        } catch (ContraseniaInvalidaException e) {
            FacesMessage fm = new FacesMessage("La contraseña no es correcta");
            FacesContext.getCurrentInstance().addMessage("inicio:contr", fm);
        } catch (CuentaInactivaException e) {
            FacesMessage fm = new FacesMessage("La cuenta no está activa");
            FacesContext.getCurrentInstance().addMessage("inicio:us", fm);
        } catch (NegocioException e) {
            FacesMessage fm = new FacesMessage("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return null;
    }
}
