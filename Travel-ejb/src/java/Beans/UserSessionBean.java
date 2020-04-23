/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entities.Cancelbooking;
import Entities.City;
import Entities.Country;
import Entities.Hotel;
import Entities.Hotelbooking;
import Entities.Hotelrating;
import Entities.Message;
import Entities.Packagebooking;
import Entities.Packagerating;
import Entities.Payment;
import Entities.Travelpackage;
import Entities.User;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author misha
 */
@Stateless
public class UserSessionBean implements UserSessionBeanLocal {

    @PersistenceContext(unitName = "TravelPU")
    private EntityManager em;
    
    @Override
    public void AddMessage(int FromUserID,int ToUserID,String Message_Text) 
    {
        User objUser = (User)em.find(User.class, FromUserID);
        Collection<Message> objMessage = objUser.getMessageCollection();
        
        Message objAddMessage = new Message();
        objAddMessage.setFromUserId(objUser);
        objAddMessage.setToUserId(objUser);
        objAddMessage.setMessageText(Message_Text);
        objMessage.add(objAddMessage);

        objUser.setMessageCollection(objMessage);
        em.persist(objAddMessage);
        em.merge(objUser);
    }

    @Override
    public void AddHotelRatings(int UserID,int HotelID, int RatingStar, String Description) 
    {
        User objUser = em.find(User.class, UserID);
        Hotel objHotel = em.find(Hotel.class, HotelID);
        Collection<Hotelrating> objHotelRating = objUser.getHotelratingCollection();

        Hotelrating objAddHotelRating = new Hotelrating();
        objAddHotelRating.setUserId(objUser);
        objAddHotelRating.setHotelId(objHotel);
        objAddHotelRating.setRatingstar(RatingStar);
        objAddHotelRating.setDescription(Description);
        objHotelRating.add(objAddHotelRating);

        objUser.setHotelratingCollection(objHotelRating);
        em.persist(objAddHotelRating);
        em.merge(objUser);   
    }
    
    @Override
    public Collection<Message> GetAllMessage()
    {
        return em.createNamedQuery("Message.findAll").getResultList();
    }
    
    @Override
    public Collection<Hotelrating> getAllHotelRatings()
    {
        return em.createNamedQuery("Hotelrating.findAll").getResultList();
    }
    
    @Override
    public void DeleteHotelBooking(int HotelBookingID) 
    {
        Hotelbooking objDeleteHotelBooking = em.find(Hotelbooking.class, HotelBookingID);
        em.remove(objDeleteHotelBooking);
    }

    @Override
    public void AddPayment(int UserID, int HotelID, int PackageID,  int BusID,Boolean Status, int TotalCharge, Date PaymentDate) 
    {
        try{
        User objUser = em.find(User.class, UserID);
        Hotel objHotel = em.find(Hotel.class, HotelID);
        Travelpackage objPackage = em.find(Travelpackage.class, PackageID);
        Collection<Payment> objPayment = objUser.getPaymentCollection();
        
        Payment objAddPayment = new Payment();
        objAddPayment.setUserId(objUser);
        objAddPayment.setHotelId(objHotel);
        objAddPayment.setPackageId(objPackage);
        objAddPayment.setAmount(TotalCharge);
        objAddPayment.setStatus(true);
        objAddPayment.setDate(PaymentDate);
        objPayment.add(objAddPayment);
        
        objUser.setPaymentCollection(objPayment);
        em.persist(objAddPayment);
        em.merge(objUser);
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void AddCancelBooking(int UserID, int HotelID, int PackageID, int PaymentID, String Reason) 
    {
        User objUser = em.find(User.class, UserID);
        //Hotel objHotelBooking = em.find(Hotelbooking.class, HotelbookingID);
        Hotel objHotel = em.find(Hotel.class, HotelID);
        Travelpackage objPackage = em.find(Travelpackage.class, PackageID);
        Payment objPayment = em.find(Payment.class, PaymentID);
        Collection<Cancelbooking> objCancelBooking = objUser.getCancelbookingCollection();
        
        Cancelbooking objAddCancelBooking = new Cancelbooking();
        objAddCancelBooking.setUserId(objUser);
        objAddCancelBooking.setPackageId(objPackage);
        objAddCancelBooking.setPackageId(objPackage);
        objAddCancelBooking.setPaymentId(objPayment);
        objAddCancelBooking.setReasonForCancel(Reason);
        objCancelBooking.add(objAddCancelBooking);
        
        objUser.setCancelbookingCollection(objCancelBooking);
        em.persist(objAddCancelBooking);
        em.merge(objUser);
    }

    @Override
    public void AddUser(String FirstName, String MiddleName, String LastName,
                        String EmailID, Long ContactNumber, String Password, 
                        Boolean IsActive) 
    {
        try{
        User objAddUser = new User();
        objAddUser.setFirstName(FirstName);
        objAddUser.setMiddleName(MiddleName);
        objAddUser.setLastName(LastName);
        objAddUser.setEmailId(EmailID);
        objAddUser.setContactNo(0);
        objAddUser.setPassword(Password);
        objAddUser.setIsactive(true);
        em.persist(objAddUser);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void UpdateUser(int UserID, String EmailID, Long ContactNumber, String Password,Boolean IsActive) 
    {
        User objUpdateUser = (User)em.find(User.class, UserID);
        objUpdateUser.setEmailId(EmailID);
        objUpdateUser.setContactNo(UserID);
        objUpdateUser.setPassword(Password);
        objUpdateUser.setIsactive(true);
        em.merge(objUpdateUser);
    }
    
    @Override
    public User GetUserByPassword(String Password)
    {
        return (User)em.createNamedQuery("User.findByPassword").setParameter("password", Password).getSingleResult();
    }
    
    @Override
    public void UpdatePassword(int UserID,String Password)
    {
        User objUpdateUserPassword = (User)em.find(User.class, UserID);
        objUpdateUserPassword.setPassword(Password);
        em.merge(objUpdateUserPassword);
    }
    
    @Override
    public Map<String,Integer> GetAllCity()
    {
        Map<String,Integer> map = new LinkedHashMap<String,Integer>();
        Collection<City> lstCity = em.createNamedQuery("City.findAll").getResultList();
        for (City city : lstCity) {
            map.put(city.getCityName(), city.getCityId());
        }
        return map;
    }

    @Override
    public void AddPackageBooking(int PackageID, int UserID, int PaymentID, int NoOfTravelers, String EmailID, Long ContactNumber, Date JourneyDate, Date BookingDate) 
    {
        Travelpackage objPackage = em.find(Travelpackage.class, PackageID);
        User objUser = em.find(User.class, UserID);
        Payment objPayment = em.find(Payment.class, PaymentID);
        Collection<Packagebooking> objPackageBooking = objPackage.getPackagebookingCollection();
        
        Packagebooking objAddPackageBooking = new Packagebooking();
        objAddPackageBooking.setPackageId(objPackage);
        objAddPackageBooking.setUserId(objUser);
        objAddPackageBooking.setPaymentId(objPayment);
        objAddPackageBooking.setNooftravelers(NoOfTravelers);
        objAddPackageBooking.setJourneystartDate(JourneyDate);
        objAddPackageBooking.setBookingDate(BookingDate);
        objPackageBooking.add(objAddPackageBooking);
        
        objPackage.setPackagebookingCollection(objPackageBooking);
        em.persist(objAddPackageBooking);
        em.merge(objPackage);
    }
    
    @Override
    public void AddPackageRatings(int UserID,int PackageID, int RatingStar, String Description) 
    {
        User objUser = em.find(User.class, UserID);
        Travelpackage objpackage = em.find(Travelpackage.class, PackageID);
        Collection<Packagerating> objPackageRating = objUser.getPackageratingCollection();

        Packagerating objAddPackageRating = new Packagerating();
        objAddPackageRating.setUserId(objUser);
        objAddPackageRating.setPackageId(objpackage);
        objAddPackageRating.setRatingstar(RatingStar);
        objAddPackageRating.setDescription(Description);
        objPackageRating.add(objAddPackageRating);

        objUser.setPackageratingCollection(objPackageRating);
        em.persist(objAddPackageRating);
        em.merge(objUser);   
    }
    
    @Override
    public Collection<Packagerating> getAllPackageRatings()
    {
        return em.createNamedQuery("Packagerating.findAll").getResultList();
    }
    
    @Override
    public void AddHotelBooking(int HotelID, int UserID, int PaymentID ,Date CheckInDate,Date CheckOutDate,int Adultes,int NoOfRooms,
                                Date BookingDate) 
    {
        Hotel objHotel = em.find(Hotel.class, HotelID);
        User objUser = em.find(User.class, UserID);
        Payment objPayment = em.find(Payment.class, PaymentID);
        Collection<Hotelbooking> objHotelBooking = objHotel.getHotelbookingCollection();
        
        Hotelbooking objAddHotelBooking = new Hotelbooking();
        objAddHotelBooking.setHotelId(objHotel);
        objAddHotelBooking.setUserId(objUser);
        objAddHotelBooking.setPaymentId(objPayment);
        objAddHotelBooking.setCheckinDate(CheckInDate);
        objAddHotelBooking.setCheckoutDate(CheckOutDate);
        objAddHotelBooking.setAdultes(Adultes);
        objAddHotelBooking.setNoofrooms(NoOfRooms);
        objAddHotelBooking.setBookingDate(BookingDate);
        objHotelBooking.add(objAddHotelBooking);
        
        objHotel.setHotelbookingCollection(objHotelBooking);
        em.persist(objAddHotelBooking);
        em.merge(objHotel);
    }

    @Override
    public Collection<Object[]> TopHotels() {
   try{
        Query query = em.createNativeQuery("SELECT  h.hotelID,h.hotelName,h.description,r.roomtypeId,r.roomtypeName,c.cityId,c.cityName,s.stateId,s.stateName FROM Hotel h\n" +
"                                           INNER JOIN Roomtype rt ON h.roomtypeId = r.roomtypeId\n" +
"                                           INNER JOIN City c ON h.cityId = c.cityId\n" +
"                                           INNER JOIN State s ON h.stateId = s.stateId\n" +
"                                           WHERE h.createdDate >= ?createdDateFrom AND h.createdDate <= ?createdDateTo","MultipleSearchOfHotels");
        
        Date createdDateTo = new Date();
        Date createdDateFrom = Date.from(ZonedDateTime.now().minusMonths(1).toInstant());
        
        query.setParameter("createdDateFrom", createdDateFrom);
        query.setParameter("createdDateTo", createdDateTo);
        
        Collection<Object[]> obj = query.getResultList();
        return obj;
        }
   
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public Hotel GetHotelByID(int HotelID)
    {
        Hotel objHotelByID = (Hotel)em.find(Hotel.class, HotelID);
        return objHotelByID;
    }    

    @Override
    public Collection<Hotel> ShowHotel() {
        return em.createNamedQuery("Hotel.findAll").getResultList();
    }

    @Override
    public Collection<Hotel> getAllHotels() {
        return em.createNamedQuery("Hotel.findAll").getResultList();
    }

    @Override
    public Collection<Country> getallcountry() {
        return em.createNamedQuery("Country.findAll").getResultList();
    }
}
