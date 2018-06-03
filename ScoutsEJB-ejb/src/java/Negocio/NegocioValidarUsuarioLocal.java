/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import entidadesJPA.Registro_seccion;
import entidadesJPA.Rol;
import entidadesJPA.Seccion;
import entidadesJPA.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ADRIAN LUACES
 */
@Local
public interface NegocioValidarUsuarioLocal {

    public List<Usuario> noValidado();

    public void crearSecc(Registro_seccion reg_sec, Usuario user, Seccion secc);

    public void validar(Usuario user);

    public void rol(Usuario user, Rol rol);
}

