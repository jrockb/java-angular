package co.com.jcd.personabackend.data;

import co.com.jcd.personabackend.entity.Persona;
import java.util.List;

/**
 *
 * @author jcd
 */
public interface PersonaDao {
    
    public List<Persona> encontrarTodasLasPersonas();
    
    public Persona encontrarPersona(Persona persona);
    
    public void insertarPersona(Persona persona);
    
    public void actualizarPersona(Persona persona);
    
    public void eliminarPersona(Persona persona);
    
}
