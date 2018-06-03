/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesJPA;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ADRIAN LUACES
 */
@Entity
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombreEv;
    @Temporal(TemporalType.DATE)
    private Date fechaEv;
    private String lugarEv;
    private int horaEv;
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEv;
    private int precio;
    @OneToMany(mappedBy="evento",cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Hist_asist> historial;
    @OneToMany(mappedBy="evento",cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Comentarios> comentarios;
    @ManyToOne
    private Seccion seccion;
    
    
    public Evento(){
        
    }
    
      public Evento(String nombreEv, TipoEvento tipo){
          this.nombreEv= nombreEv;
          this.tipoEv = tipo;       
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombreEv() {
        return nombreEv;
    }

    public void setNombreEv(String nombreEv) {
        this.nombreEv=nombreEv;
    }
    
    public Date getFechaEv() {
        return fechaEv;
    }

    public void setFechaEv(Date fechaEv) {
        this.fechaEv=fechaEv;
    }
    
    public String getLugarEv() {
        return lugarEv;
    }

    public void setLugarEv(String lugarEv) {
        this.lugarEv=lugarEv;
    }
    
    public Integer getHoraEv() {
        return horaEv;
    }

    public void setHoraEv(int horaEv) {
        this.horaEv=horaEv;
    }
    
    public TipoEvento getTipoEv() {
        return tipoEv;
    }

    public void setTipoEv(TipoEvento tipoEv) {
        this.tipoEv=tipoEv;
    }
    
    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
       /**
     * @return the historial
     */
    public List<Hist_asist> getHistorial() {
        return historial;
    }
    
    public void setHistorial(List<Hist_asist> historial) {
        this.historial = historial;
    }

    /**
     * @return the comentarios
     */
    public List<Comentarios> getComentarios() {
        return comentarios;
    }
    
    public void setComentarios(List<Comentarios> comentarios) {
        this.comentarios = comentarios;
    }

    
    /**
     * @return the seccion
     */
    public Seccion getSeccion() {
        return seccion;
    }
    
    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trabajoscouts.Evento[ id=" + id + " ]";
    }

 

    
}
