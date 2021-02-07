package co.com.jcd.personabackend.web;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Activa la exposicion de metodos en el servicio rest
 * otra opción es con el web.xml
 * @author jcd
 */
@ApplicationPath("webservice") // pah para acceder al servicio web
public class JAXRSActivator extends Application{
    
}
