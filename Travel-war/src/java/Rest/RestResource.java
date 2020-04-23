/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Beans.UserSessionBeanLocal;
import Entities.Country;
import Entities.Hotel;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author misha
 */
@Path("Travel")
@Stateless
public class RestResource {

    @EJB UserSessionBeanLocal  ebl;
    
    @Context
    private UriInfo context;
    
    @GET
    @Path("/getcountry")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Country> getcountry(){
        return ebl.getallcountry();
    }
    
    @GET
    @Path("/getHotels")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Hotel> gethotel(){
        return ebl.getAllHotels();
    }
    
    
    
}
