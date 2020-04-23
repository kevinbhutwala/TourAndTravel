/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Beans.UserSessionBeanLocal;
import Entities.Hotel;
import RestClient.JerseyClient;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Karan
 */
@Named(value = "userCDIBean")
@RequestScoped
public class UserCDIBean {

    @EJB
    private UserSessionBeanLocal userSessionBean;
    
    
    
    GenericType<Collection<Hotel>> gHotel;
    Collection<Hotel> cHotel;
    Response res;
    JerseyClient client;

       int hotel_id,room_id,state_id,city_id;
       String hotel_name,description,created_date,last_modify_date;

           public Collection<Hotel> getAllHotels()
           {
        
               res = client.gethotel_XML(Response.class);
               cHotel= res.readEntity(gHotel);
               
               return cHotel;

//               return userSessionBean.getAllHotels();
    }
    public GenericType<Collection<Hotel>> getTblHotel() {
        return gHotel;
    }

    public void setTblHotel(GenericType<Collection<Hotel>> gHotel) {
        this.gHotel = gHotel;
    }

    public Collection<Hotel> getEmps() {
        return cHotel;
    }

    public void setEmps(Collection<Hotel> cHotel) {
        this.cHotel = cHotel;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public JerseyClient getClient() {
        return client;
    }

    public void setClient(JerseyClient client) {
        this.client = client;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getLast_modify_date() {
        return last_modify_date;
    }

    public void setLast_modify_date(String last_modify_date) {
        this.last_modify_date = last_modify_date;
    }
    
    public UserCDIBean() {
        cHotel = new ArrayList<Hotel>();
        gHotel = new GenericType<Collection<Hotel>>(){};
        client = new JerseyClient();
    }
    
}
