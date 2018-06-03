/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;


import Negocio.NegocioListarImpagosLocal;
import entidadesJPA.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author FRANCIS
 */
@Named(value = "controlImpagos")
@RequestScoped
public class ControlImpagos {
    
    @EJB
    private NegocioListarImpagosLocal negocio;
    
    public ControlImpagos(){
        
    }
    
    public List<Usuario> listarImpagos(){
        
        return negocio.listarImpagos();
    }
}

