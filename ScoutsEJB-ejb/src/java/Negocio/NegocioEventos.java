/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import entidadesJPA.Evento;
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
public class NegocioEventos implements NegocioEventosLocal {

    @PersistenceContext(unitName = "ScoutsEJB-ejbPU")
    private EntityManager em;
    private List<Evento> eventos;

    @Override
    public void crearEvento(Evento evento) throws NegocioException {
        
        em.persist(evento);
    }

    @Override
    public List<Evento> todosEventos() {
        Query query = em.createQuery("SELECT ev from Evento ev ORDER BY ev.id");
        eventos = query.getResultList();

        return eventos;
    }

    @Override
    public List<Evento> EventosInic() {
        Query query = em.createQuery("SELECT ev from Evento ev ORDER BY ev.id");
        eventos = query.getResultList();
        return eventos.subList(0, 1);
    }

    @Override
    public List<Evento> metodoEventosSeccion(String seccionent) {
        Query query = em.createQuery("select ev from evento ev where ev.seccion = :s");
        query.setParameter("s", seccionent);
        eventos = query.getResultList();
        if (eventos == null) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No hay usuarios para validar", "No hay usuarios para validar"));
        }
        return eventos;
    }
}

