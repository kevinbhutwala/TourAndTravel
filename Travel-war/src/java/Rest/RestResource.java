/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Beans.UserSessionBeanLocal;
import Entities.Hotel;
import Entities.Hotelrating;
import Entities.Message;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
 * @author Karan
 */
@Path("generic")
public class RestResource {
@EJB UserSessionBeanLocal b1;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestResource
     */
    public RestResource() {
    }

    /**
     * Retrieves representation of an instance of Rest.RestResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/travels")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Hotelrating> getAllHotelRatings()
    {
        return b1.getAllHotelRatings();
    }

    /**
     * PUT method for updating or creating an instance of RestResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    


    private UserSessionBeanLocal lookupUserSessionBeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (UserSessionBeanLocal) c.lookup("java:comp/env/UserSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
