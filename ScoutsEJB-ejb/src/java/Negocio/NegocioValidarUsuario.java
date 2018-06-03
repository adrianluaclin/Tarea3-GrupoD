/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import entidadesJPA.Registro_seccion;
import entidadesJPA.Rol;
import entidadesJPA.Seccion;
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
 * @author ADRIAN LUACES
 */
@Stateless
public class NegocioValidarUsuario implements NegocioValidarUsuarioLocal {

    @PersistenceContext(unitName = "ScoutsEJB-ejbPU")
    private EntityManager em;

    @Override
    public List<Usuario> noValidado() {
        Query query = em.createQuery("SELECT u from Usuario u where u.validado=false");
        List<Usuario> us = query.getResultList();

        if (us == null) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No hay usuarios para validar", "No hay usuarios para validar"));
        }

        return us;
    }

    @Override
    public void crearSecc(Registro_seccion reg_sec, Usuario user, Seccion secc) {
        reg_sec.setUsuario(user);
        reg_sec.setSeccion(secc);
        em.persist(reg_sec);
    }

    @Override
    public void validar(Usuario user) {
        user.setValidado(true);
        em.merge(user);
    }

    @Override
    public void rol(Usuario user, Rol rol) {
        user.setRol(rol);
        em.merge(user);
    }
}
