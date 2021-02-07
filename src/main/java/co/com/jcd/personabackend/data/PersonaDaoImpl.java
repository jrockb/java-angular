package co.com.jcd.personabackend.data;

import co.com.jcd.personabackend.entity.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jcd
 */
@Stateless
public class PersonaDaoImpl implements PersonaDao {
    
    @PersistenceContext(unitName = "personaPU")
    EntityManager em;

    @Override
    public List<Persona> encontrarTodasLasPersonas() {
        return em.createNamedQuery("Persona.encontrarTodasPersonas")
                .getResultList();
    }

    @Override
    public Persona encontrarPersona(Persona persona) {
        return em.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public void insertarPersona(Persona persona) {
        em.persist(persona);
        em.flush(); // para que el objeto se regrese con el valor de la llave primaria generada
    }

    @Override
    public void actualizarPersona(Persona persona) {
        em.merge(persona);
    }

    @Override
    public void eliminarPersona(Persona persona) {        
        em.remove(em.merge(persona)); // se necesita sincronizar primero el objeto en la base de datos
    }
    
}
