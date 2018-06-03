/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import entidadesJPA.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ADRIAN LUACES
 */
@Stateless
public class NegocioAutenticar implements NegocioAutenticarLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "ScoutsEJB-ejbPU")
    private EntityManager em;
        
    
    @Override
    public void compruebaLogin(Usuario usuario) throws NegocioException {
        
        Usuario user = em.find(Usuario.class, usuario.getAliasUs());
       
        if (user == null) {
            throw new CuentaInexistenteException();
        }

        if (!user.getContrasenia().equals(usuario.getContrasenia())) {
            throw new ContraseniaInvalidaException();
        }
        
        
        if (!usuario.isValidado())
        {
            throw new CuentaInactivaException();
        }
        
    }
  
}
