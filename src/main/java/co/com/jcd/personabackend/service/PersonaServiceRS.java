package co.com.jcd.personabackend.service;

import co.com.jcd.personabackend.data.PersonaDao;
import co.com.jcd.personabackend.entity.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * En este ejemplo se va a inyectar directamente la capa de datos
 * es recomendable tener una capa de servicio
 * @author jcd
 */
@Stateless // bean sin estado
@Path("/personas") // indica que es un servicio rest con este path
public class PersonaServiceRS {
    
    @Inject
    private PersonaDao personaDao;
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Persona> listarPersona(){
        List<Persona> personas = personaDao.encontrarTodasLasPersonas();
        System.out.println("personas encontradas" + personas);
        return personas;
    }
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}") // hace referencia al objeto path: /personas/{id} ejp: /personas/1
    public Persona encontrarPersona(@PathParam("id") int id){
        Persona persona = personaDao.encontrarPersona(new Persona(id));
        System.out.println("Persona encontrada: "+ persona);
        return persona;
    }
    
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Persona agregarPersona(Persona persona){
        personaDao.insertarPersona(persona);
        System.out.println("Persona agreagada: "+ persona);
        return persona; // porque el cliente necesita el objeto para obtener la llave primaria 
    }
    
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response modificarPersona(@PathParam("id") int id, 
            Persona personaModificada){
        Persona persona = personaDao.encontrarPersona(personaModificada); // verificar si existe la persona buscando por id
        if(persona != null){
            personaDao.actualizarPersona(personaModificada);
            System.out.println("Persona modificada: "+ persona);
            return Response.ok().entity(personaModificada).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }
    
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response eliminarPersona(@PathParam("id") int id){
        personaDao.eliminarPersona(new Persona(id));
        System.out.println("persona eliminada con el id: "+ id);
        return Response.ok().build();
    }
    
}
