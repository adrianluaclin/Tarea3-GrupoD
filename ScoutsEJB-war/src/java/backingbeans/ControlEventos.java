
package backingbeans;

import Negocio.CuentaRepetidaException;
import Negocio.NegocioEventosLocal;
import Negocio.NegocioException;
import entidadesJPA.Evento;
import entidadesJPA.TipoEvento;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "controlEventos")
@RequestScoped

public class ControlEventos {

    private Evento evento;
    private TipoEvento tipo;
    private boolean creacionOk;
    private String descripcion;
    private String nombre;
    private Evento eventoMostrar;

    @EJB
    private NegocioEventosLocal negocio;
    
    

    public NegocioEventosLocal getNegocio() {
        return negocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNegocio(NegocioEventosLocal negocio) {
        this.negocio = negocio;
    }

    public Evento getEventoMostrar() {
        return eventoMostrar;
    }

    public void setEventoMostrar(Evento eventoMostrar) {
        this.eventoMostrar = eventoMostrar;
    }

    /*
     * Creates a new instance of Eventos
     */
    public ControlEventos() {
        evento = new Evento();
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    public boolean isCreacionOk() {
        return creacionOk;
    }

    public String crearEvento() {
        // Implementar este método

        try {
            negocio.crearEvento(evento);
            creacionOk = true;
            return "exitoEvento.xhtml";

        } catch (CuentaRepetidaException e) {
            FacesMessage fm = new FacesMessage("Ya existe ese evento");
            FacesContext.getCurrentInstance().addMessage("creacion-eventos:nombre", fm);

        } catch (NegocioException e) {
        }

        return null;
    }

    public List<Evento> listaEventos() {
        return negocio.todosEventos();
    }

    public String irEvento(Evento ev) {
        this.eventoMostrar = ev;
        return "evento.xhtml";
    }
    
    
    public String eventoInic() {
        negocio.EventosInic();
        return null;
    }
}
