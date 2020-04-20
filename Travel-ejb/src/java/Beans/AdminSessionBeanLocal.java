/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entities.Advertisement;
import Entities.Cancelbooking;
import Entities.Category;
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
import Entities.Travelpackage;
import Entities.User;
import java.util.Collection;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author misha
 */
@Local
public interface AdminSessionBeanLocal {
       
        public void AddCategory(Category ObjAddCategory);
        public void UpdateCategory(Category ObjUpdateCategory);
        public void DeleteCategory(int category_id);
        Collection<Category> GetAllCategories();
       
        public void AddRoomType(Roomtype ObjAddRoomType);
        public void UpdateRoomType(Roomtype ObjUpdateRoomType);
        public void DeleteRoomType(int roomtype_id);
        public Map<String,Integer> GetAllRoomTypes();
        public Collection<Roomtype> RoomTypeList();
       
        public void AddHotel(Hotel ObjAddHotel);
        public void UpdateHotel(Hotel ObjUpdateHotel);
        public void DeleteHotel(int hotel_id);
        public Hotel GetHotelByID(int hotel_id);
        public Hotel getHotelByName(String hotel_name);
               
        public void InsertHotelFood(Hotelfood ObjInsertHotelFood);
        public void UpdateHotelFood(Hotelfood ObjUpdateHotelFood);
        public void DeleteHotelFood(int hotelfood_id);
 //       public Collection<Hotelfood> getFoodsOfHotel(int hotel_id);
        
        public void AddPackage(Travelpackage ObjAddTravelpackage);
        public void UpdatePackage(Travelpackage ObjUpdateTravelpackage);
        public void DeletePackage(int package_id);
        public Travelpackage GetPackageBYID(int package_id);
        public void InsertImageOfPackage(Packageimage ObjAddPackageImage);
        public void UpdateImageOfPackage(Packageimage ObjUpdatePackageImage);
        public void DeleteImageOfPackage(int packageimage_id);
        
        public void AddAdvertisement(Advertisement ObjAddAdvertisement);
        public void UpdateAdvertisement(Advertisement ObjUpdateAdvertisement);
        public void DeleteAdvertisement(int advertisement_id);
        public void InsertImageOfAdvertisement(Advertisement ObjAddAdvertisement);
        public void UpdateImageOfAdvertisement(Advertisement ObjUpdateAdvertisement);
        public void DeleteImageOfAdvertisement(int adv_id);
        
        public void AddOffer(Offer ObjAddOffer);
        public void UpdateOffer(Offer ObjUpdateOffer);
        public void DeleteOffer(int offer_id);
        
        public void AddFood(Food ObjAddFood);
        public void UpdateFood(Food ObjUpdateFood);
        public void DeleteFood(int food_id);
        public Map<String,Integer> GetAllFood();
        public Collection<Food> FoodList();
        
        public Collection<Message> GetAllMessage();
        
        public Hotelrating GetHotelRatingByHotelID(int hotel_id);
        
        public Collection<Hotelbooking> GetAllHotelBookings();
        public Hotelbooking GetHotelBookingByID(int hotelbooking_id);
        
        public Collection<Payment> GetAllPayments();
        public Payment GetPaymentByID(int payment_id);
        
        public Collection<Cancelbooking> GetAllCancelBookings();
        public Cancelbooking GetCancelBookingByID(int cancelbooking_id);
        
        public Collection<User> GetAllUsers();
        public Map<String,Integer> GetUserList();
        public User GetUserById(int user_id);
        public User GetUserByName(String name);

        public Map<String,Integer> GetAllCities();

        public Map<String,Integer> GetAllStates();
        
        
           
}