/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import entidadesJPA.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author FRANCIS
 */
@Stateless
public class NegocioListarImpagos implements NegocioListarImpagosLocal {
    
    @PersistenceContext (unitName = "ScoutsEJB-ejbPU")
    private EntityManager em;
    
    @Override
    public List<Usuario> listarImpagos(){
        Query query=em.createQuery("SELECT c.usuario from Cuotas c where c.abonado=false");
        List<Usuario> us = query.getResultList();
        
        if ( us == null)
        {
           FacesContext ctx = FacesContext.getCurrentInstance();
           ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No hay usuarios que no hayan pagado la cuota", "No hay usuarios que no hayan pagado la cuota"));
        }
        return us;
    }
}
