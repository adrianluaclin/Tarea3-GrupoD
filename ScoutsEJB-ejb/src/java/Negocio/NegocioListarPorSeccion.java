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
public class NegocioListarPorSeccion implements NegocioListarPorSeccionLocal {
    
   
    
    @PersistenceContext (unitName="ScoutsEJB-ejbPU")
    private EntityManager em;
    
    
    @Override
    public List<Usuario> listarPorCastores(){
        Query query1=em.createQuery("SELECT r.usuario from Registro_seccion r  where r.seccion.tipoSec = entidadesJPA.TipoSeccion.castores and r.fechBajaSecc is null");
        List<Usuario> usuarios=query1.getResultList();
         if ( usuarios == null)
        {
           FacesContext ctx = FacesContext.getCurrentInstance();
           ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No hay usuarios registrados en esta sección", "No hay usuarios registrados en esta sección"));
        }
        return usuarios;
    }
    
    @Override
    public List<Usuario> listarPorManada(){
        Query query2=em.createQuery("SELECT r.usuario from Registro_seccion r  where r.seccion.tipoSec = entidadesJPA.TipoSeccion.manada and r.fechBajaSecc is null");
        List<Usuario> usuarios=query2.getResultList();
         if ( usuarios == null)
        {
           FacesContext ctx = FacesContext.getCurrentInstance();
           ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No hay usuarios registrados en esta sección", "No hay usuarios registrados en esta sección"));
        }
        return usuarios;
    }
    
    @Override
    public List<Usuario> listarPorTropa(){
        Query query3=em.createQuery("SELECT r.usuario from Registro_seccion r  where r.seccion.tipoSec = entidadesJPA.TipoSeccion.tropa and r.fechBajaSecc is null");
        List<Usuario> usuarios=query3.getResultList();
         if ( usuarios == null)
        {
           FacesContext ctx = FacesContext.getCurrentInstance();
           ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No hay usuarios registrados en esta sección", "No hay usuarios registrados en esta sección"));
        }
        return usuarios;
    }
    
    @Override
    public List<Usuario> listarPorUnidad(){
        Query query4=em.createQuery("SELECT r.usuario from Registro_seccion r  where r.seccion.tipoSec = entidadesJPA.TipoSeccion.unidad and r.fechBajaSecc is null");
        List<Usuario> usuarios=query4.getResultList();
         if ( usuarios == null)
        {
           FacesContext ctx = FacesContext.getCurrentInstance();
           ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No hay usuarios registrados en esta sección", "No hay usuarios registrados en esta sección"));
        }
        return usuarios;
    }
    
    @Override
    public List<Usuario> listarPorClan(){
        Query query5=em.createQuery("SELECT r.usuario from Registro_seccion r  where r.seccion.tipoSec = entidadesJPA.TipoSeccion.clan and r.fechBajaSecc is null");
        List<Usuario> usuarios=query5.getResultList();
         if ( usuarios == null)
        {
           FacesContext ctx = FacesContext.getCurrentInstance();
           ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No hay usuarios registrados en esta sección", "No hay usuarios registrados en esta sección"));
        }
        return usuarios;
    }
    
    
    
}

