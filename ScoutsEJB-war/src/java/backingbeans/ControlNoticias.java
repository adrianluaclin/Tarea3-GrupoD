/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import java.util.List;
import Negocio.NegocioNoticiaLocal;
import Negocio.NoticiasException;
import entidadesJPA.Noticia;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "controlNoticias")
@RequestScoped
public class ControlNoticias {
    private Noticia noticia;
    private String nombre;
    private Date fecha;
    private boolean creacionOk;
    
    @EJB
    private NegocioNoticiaLocal negocio;

    /**
     * Creates a new instance of ControlNoticias
     */
    public ControlNoticias() {
        noticia=new Noticia();    
    }
    
      public Noticia getNoticia() {
        return noticia;
    }
    
    public void setNoticia(Noticia noticia){
        this.noticia = noticia;
    }
    
    public boolean isCreacionOk() {
        return creacionOk;
    }
    
     public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String crearNoticia() {
      
        negocio.crearNoticia(noticia);
        creacionOk=true;
        return "exitoNoticia.xhtml";
    }
    
    
    public List<Noticia> verNot() throws NoticiasException {
        return negocio.listarNot();
    }

    public String eliminar() throws NoticiasException {
        negocio.borrarNoticias(nombre);
        return null;

    }

    public String buscarNot() throws NoticiasException {
        negocio.buscarNot(nombre);
        return null;

    }
}
    
