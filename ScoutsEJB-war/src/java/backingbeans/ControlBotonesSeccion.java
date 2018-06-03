/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;


import javax.enterprise.context.Dependent;
import javax.inject.Named;;


/**
 *
 * @author FRANCIS
 */
@Named(value = "controlListarSeccion")
@Dependent
public class ControlBotonesSeccion {
    

    
    public ControlBotonesSeccion() {
      
    }

    public String listarCastores(){
      
        return "listar-castores.xhtml";
    }
    
    public String listarManada(){
        return "listar-manada.xhtml";
    }
    
    public String listarTropa(){
        return "listar-tropa.xhtml";
    }
    
    public String listarUnidad(){
        return "listar-unidad.xhtml";
    }
    
    public String listarClan(){
        return "listar-clan.xhtml";
    }
    
}

