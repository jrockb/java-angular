package co.com.jcd.personabackend.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author jcd
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Persona.encontrarTodasPersonas", 
            query = "SELECT p FROM Persona p ORDER BY p.idPersona")
})
public class Persona implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int idPersona;
    
    private String nombre;

    public Persona() {
    }

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }    

    public Persona(int idVersion, String nombrePersona) {
        this.idPersona = idVersion;
        this.nombre = nombrePersona;
    }   

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombrePersona) {
        this.nombre = nombrePersona;
    }
    
    
    
}
