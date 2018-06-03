/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import javax.ejb.EJB;
import Negocio.NegocioListarPorSeccionLocal;
import entidadesJPA.Usuario;
import entidadesJPA.Registro_seccion;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author FRANCIS
 */
@Named (value = "controlListarPorSeccion")
@RequestScoped
public class ControlListarPorSeccion {
    
    @EJB
    private NegocioListarPorSeccionLocal negocio;
    
    public  ControlListarPorSeccion(){
        
    }
    
     public List<Usuario> listarCastores(){
        
        return negocio.listarPorCastores();
    }
     
     public List<Usuario> listarManada(){
        
       return negocio.listarPorManada();
    }
     
     public List<Usuario> listarTropa(){
        
        return negocio.listarPorTropa();
    }
     
     public List<Usuario> listarUnidad(){
        
        return negocio.listarPorUnidad();
    }
     
     public List<Usuario> listarClan(){
        
        return negocio.listarPorClan();
    }
    
    public Registro_seccion ultimoElemento(Usuario us){
        Registro_seccion r1;
        List<Registro_seccion> lista = new ArrayList(us.getRegistro_sec());
        if (!lista.isEmpty()) {
        r1 = lista.get(lista.size()-1);
        }else{
            r1 = null;
        }
        return r1;
    }
}

