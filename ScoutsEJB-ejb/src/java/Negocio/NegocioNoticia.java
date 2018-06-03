package Negocio;

import entidadesJPA.Noticia;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ADRIAN LUACES
 */
@Stateless
public class NegocioNoticia implements NegocioNoticiaLocal {

    @PersistenceContext(unitName = "ScoutsEJB-ejbPU")
    private EntityManager em;
    private List<Noticia> noticias;
    private Query query;

    @Override
    public void crearNoticia(Noticia noticia) {
        em.persist(noticia);
    }

    @Override
    public List<Noticia> listarNot() throws NoticiasException {

        query = em.createQuery("SELECT noti from Noticia noti ORDER BY noti.id DESC");
        noticias = query.getResultList();

        if (noticias == null) {
            throw new NoticiaInexistente();
        }
        return noticias;

    }

    @Override
    public List<Noticia> buscarNot(String nombre) throws NoticiasException {

        query = em.createQuery("SELECT noti from Noticia noti WHERE noti.nombre= " + nombre);
        noticias = query.getResultList();

        if (noticias == null) {
            throw new NoticiaInexistente();
        }
        return noticias;
    }

    @Override
    public void borrarNoticias(String nombre) throws NoticiasException {
        query = em.createQuery("SELECT noti FROM Noticia noti WHERE noti.nombre = " + nombre);
        noticias = query.getResultList();
        if (noticias == null) {
            throw new NoticiaInexistente();
        }
        em.remove(noticias.get(0));
    }
}
