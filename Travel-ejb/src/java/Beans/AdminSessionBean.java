/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entities.Advertisement;
import Entities.Cancelbooking;
import Entities.Category;
import Entities.City;
import Entities.Food;
import Entities.Hotel;
import Entities.Hotelbooking;
import Entities.Hotelfood;
import Entities.Hotelrating;
import Entities.Message;
import Entities.Offer;
import Entities.Packageimage;
import Entities.Payment;
import Entities.Roomtype;
import Entities.State;
import Entities.Travelpackage;
import Entities.User;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author misha
 */
@Stateless
public class AdminSessionBean implements AdminSessionBeanLocal {

    @PersistenceContext(unitName = "TravelPU")
    EntityManager em;
    
    @Override
    public void AddCategory(Category ObjAddCategory) {
        em.persist(ObjAddCategory);
    }

    @Override
    public void UpdateCategory(Category ObjUpdateCategory) {
        Category objcategory = (Category) em.find(Category.class,ObjUpdateCategory.getCategoryId());
        em.merge(ObjUpdateCategory);
    }

    @Override
    public void DeleteCategory(int category_id) {
        Category objcategory = em.find(Category.class,category_id);
        em.remove(objcategory);
    }

    @Override
    public Collection<Category> GetAllCategories() {
        Collection<Category> categorylist = em.createNamedQuery("Category.findAll").getResultList();
        return categorylist;
    }

    @Override
    public void AddRoomType(Roomtype ObjAddRoomType) {
        em.persist(ObjAddRoomType);
    }

    @Override
    public void UpdateRoomType(Roomtype ObjUpdateRoomType) {
        Roomtype objroomtype = (Roomtype) em.find(Roomtype.class,ObjUpdateRoomType.getRoomtypeId());
        em.merge(ObjUpdateRoomType);
    }

    @Override
    public void DeleteRoomType(int roomtype_id) {
        Roomtype objroomtype = em.find(Roomtype.class,roomtype_id);
        em.remove(objroomtype);
    }

    @Override
    public Map<String, Integer> GetAllRoomTypes() {
        Map<String,Integer> map = new LinkedHashMap<String,Integer>();
        Collection<Roomtype> lstRoomType = em.createNamedQuery("Roomtype.findAll").getResultList();
        for (Roomtype roomtype : lstRoomType) {
            map.put(roomtype.getRoomtypeName(),roomtype.getRoomtypeId());
        }
        return map;
    }

    @Override
    public Collection<Roomtype> RoomTypeList() {
        Collection<Roomtype> roomtypelist = em.createNamedQuery("Roomtype.findAll").getResultList();
        return roomtypelist;
    }

    @Override
    public void AddHotel(Hotel ObjAddHotel) {
        em.persist(ObjAddHotel);
    }

    @Override
    public void UpdateHotel(Hotel ObjUpdateHotel) {
        Hotel objHotel = (Hotel) em.find(Hotel.class,ObjUpdateHotel.getHotelId());
        em.merge(ObjUpdateHotel);
    }

    @Override
    public void DeleteHotel(int hotel_id) {
        Hotel objHotel = em.find(Hotel.class,hotel_id);
        em.remove(objHotel);
    }

    @Override
    public Hotel GetHotelByID(int hotel_id) {
        Hotel objHotelByID = (Hotel)em.find(Hotel.class, hotel_id);
        return objHotelByID;
    }

    @Override
    public Hotel getHotelByName(String hotel_name) {
         return (Hotel)em.createNamedQuery("Hotel.findByHotelName").setParameter("Hotel_name",hotel_name).getSingleResult();
    }

    @Override
    public void InsertHotelFood(Hotelfood ObjInsertHotelFood) {
        em.persist(ObjInsertHotelFood);
    }

    @Override
    public void UpdateHotelFood(Hotelfood ObjUpdateHotelFood) {
        Hotelfood ObjHotelFood=(Hotelfood) em.find(Hotelfood.class, ObjUpdateHotelFood.getHotelfoodId());
        em.merge(ObjUpdateHotelFood);
    }

    @Override
    public void DeleteHotelFood(int hotelfood_id) {
        Hotelfood objHotelFood=em.find(Hotelfood.class, hotelfood_id);
        em.remove(objHotelFood);
    }

//    @Override
//    public Collection<Hotelfood> getFoodsOfHotel(int hotel_id) {
//        Hotel ObjHotel = em.find(Hotel.class,hotel_id);
//        return ObjHotel.getHotelfoodCollection();
//    }

    @Override
    public void AddPackage(Travelpackage ObjAddTravelpackage) {
        em.persist(ObjAddTravelpackage);
    }

    @Override
    public void UpdatePackage(Travelpackage ObjUpdateTravelpackage) {
        Travelpackage ObjTravelpackage= (Travelpackage) em.find(Travelpackage.class,ObjUpdateTravelpackage.getPackageId());
        em.merge(ObjUpdateTravelpackage);
    }

    @Override
    public void DeletePackage(int package_id) {
         Travelpackage objTravelPackage = em.find(Travelpackage.class,package_id);
         em.remove(objTravelPackage);
    }

    @Override
    public Travelpackage GetPackageBYID(int package_id) {
        Travelpackage objPackageByID = (Travelpackage)em.find(Travelpackage.class, package_id);
        return objPackageByID;
    }

    @Override
    public void InsertImageOfPackage(Packageimage ObjAddPackageImage) {
       em.persist(ObjAddPackageImage);
    }
    
    @Override
    public void UpdateImageOfPackage(Packageimage ObjUpdatePackageImage)
    {
         Packageimage ObjPackageimage= (Packageimage) em.find(Packageimage.class,ObjUpdatePackageImage.getPackageimageId());
         em.merge(ObjUpdatePackageImage);
    }

    @Override
    public void DeleteImageOfPackage(int packageimage_id) {
        Packageimage objPackageimage = em.find(Packageimage.class,packageimage_id);
        em.remove(objPackageimage);
    }

    @Override
    public void AddAdvertisement(Advertisement ObjAddAdvertisement) {
        em.persist(ObjAddAdvertisement);
    }

     @Override
    public void UpdateAdvertisement(Advertisement ObjUpdateAdvertisement) {
       Advertisement ObjAdvertisement;
        ObjAdvertisement = (Advertisement) em.find(Advertisement.class, ObjUpdateAdvertisement.getAdvId());
          em.merge(ObjUpdateAdvertisement);
    }
    
    @Override
    public void DeleteAdvertisement(int advertisement_id) {
        Advertisement objadv = em.find(Advertisement.class,advertisement_id);
        em.remove(objadv);
    }

    @Override
    public void InsertImageOfAdvertisement(Advertisement ObjAddAdvertisement)
    {
        em.persist(ObjAddAdvertisement);
    }

    @Override
    public void UpdateImageOfAdvertisement(Advertisement ObjUpdateAdvertisement)
    {
        Advertisement ObjAdvertisement = (Advertisement) em.find(Advertisement.class,ObjUpdateAdvertisement.getAdvId());
        em.merge(ObjUpdateAdvertisement);
    }

    @Override
    public void DeleteImageOfAdvertisement(int adv_id)
    {
        Advertisement objAdvertisement = em.find(Advertisement.class,adv_id);
        em.remove(objAdvertisement);
    }

    @Override
    public void AddOffer(Offer ObjAddOffer) {
        em.persist(ObjAddOffer);
    }

    @Override
    public void UpdateOffer(Offer ObjUpdateOffer) {
          Offer ObjOffer=(Offer) em.find(Offer.class, ObjUpdateOffer.getOfferId());
          em.merge(ObjUpdateOffer);
    }

    @Override
    public void DeleteOffer(int offer_id) {
             Offer objoffer = em.find(Offer.class,offer_id);
            em.remove(objoffer);     
    }

    @Override
    public void AddFood(Food ObjAddFood) {
        em.persist(ObjAddFood);
    }

    @Override
    public void UpdateFood(Food ObjUpdateFood) {
            Food ObjFood=(Food) em.find(Food.class, ObjUpdateFood.getFoodId());
          em.merge(ObjUpdateFood);      
    }
    
    @Override
    public void DeleteFood(int food_id) {
        Food objfood = em.find(Food.class,food_id);
        em.remove(objfood);      
    }

    @Override
    public Map<String, Integer> GetAllFood() {
         Map<String,Integer> map = new LinkedHashMap<String,Integer>();
        Collection<Food> lstFood = em.createNamedQuery("Food.findAll").getResultList();
        for (Food food : lstFood) {
            map.put(food.getFoodType(), food.getFoodId());
        }
        return map;       
    }

    @Override
    public Collection<Food> FoodList() {
        return em.createNamedQuery("Food.findAll").getResultList();
    }


    @Override
    public Collection<Message> GetAllMessage() {
         return em.createNamedQuery("Message.findAll").getResultList();
    }

    @Override
    public Hotelrating GetHotelRatingByHotelID(int hotel_id) {
        Hotelrating objHotelrating = (Hotelrating)em.find(Hotelrating.class,hotel_id);
        return objHotelrating;
    }

    @Override
    public Collection<Hotelbooking> GetAllHotelBookings() {
        return em.createNamedQuery("Hotelbooking.findAll").getResultList();
    }

    @Override
    public Hotelbooking GetHotelBookingByID(int hotelbooking_id) {
        Hotelbooking objHotelBookingByID = (Hotelbooking)em.find(Hotelbooking.class, hotelbooking_id);
        return objHotelBookingByID;
    }

    @Override
    public Collection<Payment> GetAllPayments() {
        return em.createNamedQuery("Payment.findAll").getResultList();
    }

    @Override
    public Payment GetPaymentByID(int payment_id) {
        Payment objPaymentByID = (Payment)em.find(Payment.class, payment_id);
        return objPaymentByID;    }

    @Override
    public Collection<Cancelbooking> GetAllCancelBookings() {
        return em.createNamedQuery("Canclebooking.findAll").getResultList();
    }

    @Override
    public Cancelbooking GetCancelBookingByID(int cancelbooking_id) {
        Cancelbooking objCancelBookingByID = (Cancelbooking)em.find(Cancelbooking.class, cancelbooking_id);
        return objCancelBookingByID;
    }

    @Override
    public Collection<User> GetAllUsers() {
        return em.createNamedQuery("User.findAll").getResultList();
    }

    @Override
    public Map<String, Integer> GetUserList() {
            Map<String,Integer> map = new LinkedHashMap<String,Integer>();
            Collection<User> lstUser = em.createNamedQuery("Tbluser.findAll").getResultList();
            for (User user : lstUser) {
                    map.put(user.getFirstName(),user.getUserId());
            }
            return map;
    }

    @Override
    public User GetUserById(int user_id) {
        User objUserByID = (User)em.find(User.class, user_id);
        return objUserByID;    }

    @Override
    public User GetUserByName(String name) {
        User objUserByName = (User)em.createNamedQuery("User.findByEmailId").setParameter("emailID",name).getSingleResult();
        return objUserByName;    }

    @Override
    public Map<String, Integer> GetAllCities() {
        Map<String,Integer> map = new LinkedHashMap<String,Integer>();
        Collection<City> lstCity = em.createNamedQuery("City.findAll").getResultList();
        for (City city : lstCity) {
            map.put(city.getCityName(), city.getCityId());
        }
        return map;    }

    @Override
    public Map<String, Integer> GetAllStates() {
        Map<String,Integer> map = new LinkedHashMap<String,Integer>();
        Collection<State> lstState = em.createNamedQuery("State.findAll").getResultList();
        for (State state : lstState) {
            map.put(state.getStateName(), state.getStateId());
        }
        return map;    
    }
}