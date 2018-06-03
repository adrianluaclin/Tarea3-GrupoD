/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import entidadesJPA.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author ADRIAN LUACES
 */
@Stateless
public class NegocioRegistro implements NegocioRegistroLocal {

    @PersistenceContext(unitName = "ScoutsEJB-ejbPU")
    private EntityManager em;
     
    @Override
    public void registrarUsuario(Usuario usuario) throws NegocioException {
        Usuario user = em.find(Usuario.class, usuario.getAliasUs());
        
        if (user != null) {
            // El usuario ya existe
            throw new CuentaRepetidaException();
        }

        em.persist(usuario);
        
    }
}
