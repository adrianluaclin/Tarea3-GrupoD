/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import entidadesJPA.Evento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ADRIAN LUACES
 */
@Local
public interface NegocioEventosLocal {
    public void crearEvento(Evento evento) throws NegocioException;
    public List<Evento> todosEventos();
    public List<Evento> EventosInic();
    public List<Evento> metodoEventosSeccion(String seccionent);
}
