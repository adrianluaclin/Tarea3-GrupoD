/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import entidadesJPA.Noticia;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ADRIAN LUACES
 */
@Local
public interface NegocioNoticiaLocal {
    
    public void crearNoticia(Noticia noticia);
    public List<Noticia>  listarNot() throws NoticiasException;
    public void  borrarNoticias(String nombre) throws NoticiasException;
    public List<Noticia> buscarNot(String nombre) throws NoticiasException;
}

