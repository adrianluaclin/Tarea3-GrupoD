/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import entidadesJPA.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FRANCIS
 */
@Local
public interface NegocioListarImpagosLocal {
    public List<Usuario> listarImpagos();
}
