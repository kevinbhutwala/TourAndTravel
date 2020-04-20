/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entities.Hotelrating;
import Entities.Packagerating;
import Entities.User;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author misha
 */
@Local
public interface UserSessionBeanLocal {
   public void AddMessage(int FromUserID,int ToUserID,String Message_Text);
    
    
    public void AddHotelRatings(int UserID,int HotelID,int RatingStar,String Description);
    public Collection<Hotelrating> getAllHotelRatings();
    
    //public void AddHotelBooking(Date BookingDate,Date CheckinDate,Date CheckoutDate,int CategoryID,int NoOfPerson,int NoOfRooms,int UserID);
    public void DeleteHotelBooking(int HotelBookingID);
    
    public void AddPayment(int UserID, int HotelID, int PackageID,  int BusID,Boolean Status, int TotalCharge, Date PaymentDate);
    
    public void AddCancelBooking(int UserID,int HotelID,int PackageID,int PaymentID,String Reason);
    
    public void AddUser(String FirstName,String MiddleName,String LastName,String EmailID,Long ContactNumber,String Password,Boolean IsActive);    
    public void UpdateUser(int UserID,String EmailID,Long ContactNumber,String Password,Boolean IsActive);
    public User GetUserByPassword(String Password);
    public void UpdatePassword(int UserID,String Password);
    

    public void AddPackageBooking(int PackageID,int UserID,int PaymentID,int NoOfTravelers,String EmailID,Long ContactNumber,Date JourneyDate,Date BookingDate);
    public void AddPackageRatings(int UserID,int PackageID,int RatingStar,String Description);
    public Collection<Packagerating> getAllPackageRatings();
    
    public void AddHotelBooking(int HotelID,int UserID,int PaymentID,Date CheckInDate,Date CheckOutDate,int NoOfPerson,int NoOfRooms,Date BookingDate);
    
    public Map<String,Integer> GetAllCity(); 
}
