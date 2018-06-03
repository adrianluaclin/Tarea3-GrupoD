/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import entidadesJPA.Usuario;
import javax.ejb.Local;

/**
 *
 * @author ADRIAN LUACES
 */
@Local
public interface NegocioAutenticarLocal {
    public void compruebaLogin(Usuario usuario) throws NegocioException;
}

