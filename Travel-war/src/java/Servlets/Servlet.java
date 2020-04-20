/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.AdminSessionBeanLocal;
import Beans.UserSessionBeanLocal;
import Entities.Advertisement;
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
import Entities.Roomtype;
import Entities.State;
import Entities.Travelpackage;
import Entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author misha
 */
public class Servlet extends HttpServlet {

    @EJB
    private AdminSessionBeanLocal adminSessionBean;
    @EJB UserSessionBeanLocal objUserBean;

    

    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
//            Category c = new Category(3,"nature","4 days");
//            adminSessionBean.UpdateCategory(c);
//            adminSessionBean.DeleteCategory(1);
//            adminSessionBean.AddCategory(c);
//            Collection<Category> objcategory = adminSessionBean.GetAllCategories();
//            for(Category objcategory1 : objcategory)
//            {
//                out.println("Category Name: "+ " " + objcategory1.getCategoryName()+" "+ " Description: "+ objcategory1.getDescription());
//            }

//            Roomtype r = new Roomtype(0, "Childern", 3000, "2 Bed");
//            adminSessionBean.AddRoomType(r);
//            Roomtype r = new Roomtype(1, "Childern", 4000, "3 Bed");
//            adminSessionBean.UpdateRoomType(r);
//            adminSessionBean.DeleteRoomType(2);
//            Collection<Roomtype> objroomtype = adminSessionBean.RoomTypeList();
//            for(Roomtype objroomtype1 : objroomtype)
//            {
//                out.println("Category Name: "+ " " + objroomtype1.getRoomtypeName()+" "+ " Description: "+ objroomtype1.getDescription());
//            }

 //           Hotelfood hf=new Hotelfood(1, 5000);
//            hf.setFoodId(new Food(1));
  //          hf.setHotelId(new Hotel(1));
//            adminSessionBean.InsertHotelFood(hf);
//            adminSessionBean.UpdateHotelFood(hf);
 //             adminSessionBean.DeleteHotelFood(1);

//               Travelpackage p=new Travelpackage(1, "silver", 3, 2, 5000);
//               p.setCategoryId(new Category(2));
//               p.setStateId(new State(1));
//               p.setFromcityId(new City(1));
//               p.setTocityId(new City(1));
 //              adminSessionBean.AddPackage(p);
 //              adminSessionBean.UpdatePackage(p);
 //             adminSessionBean.DeletePackage(3);
     //         adminSessionBean.GetPackageBYID(1);
     
             //   Packageimage pi = new Packageimage(1, "xyz.jpeg");
             //   pi.setPackageId(new Travelpackage(1));
                
                
             // adminSessionBean.InsertImageOfPackage(pi);
         //      adminSessionBean.UpdateImageOfPackage(pi);
             
         
         //   adminSessionBean.DeleteImageOfPackage(1);
              
//              Advertisement adv=new Advertisement(1, "E-Commerce", "PCC","Advertisement");
//              adminSessionBean.AddAdvertisement(adv);
//              adminSessionBean.UpdateAdvertisement(adv);
//              adminSessionBean.DeleteAdvertisement(1);
              
   //         Offer o=new Offer(1, "holi offer", true, "Offer available", "abc.jpg");
 //           adminSessionBean.AddOffer(o);
 //           adminSessionBean.UpdateOffer(o);
//           adminSessionBean.DeleteOffer(1);
  

       // Food f=new Food(1, "Dinner");
 //       adminSessionBean.AddFood(f);
   //     adminSessionBean.UpdateFood(f);
   //     adminSessionBean.DeleteFood(1);
   
//        Collection<Food> objfood = adminSessionBean.FoodList();
//            for(Food objfoodtype1 : objfood)
//            {
//                out.println("Food id: "+ " " + objfoodtype1.getFoodId()+" "+ " type: "+ objfoodtype1.getFoodType());
//            }


//                Collection<Message> objmsg = adminSessionBean.GetAllMessage();
//            for(Message objmsgs : objmsg)
//            {
//                out.println("message id: "+ " " + objmsgs.getMessageId()+" "+ " From userid: "+objmsgs.getFromUserId()+" "+"to useid: "+ " " + objmsgs.getToUserId()+" "+"message_text: "+ " " + objmsgs.getMessageText()+" "+"isRead: "+ " " + objmsgs.getIsread());
//            }

//                Hotelrating hr=new Hotelrating(0, 5, "Amazing");
//                hr.setHotelId(new Hotel(1));
//                hr.setUserId(new User(1));
//                
//                Hotelrating hr1 =adminSessionBean.GetHotelRatingByHotelID(1);
//                out.println(hr1.getDescription());
             
//                Collection<Hotelbooking> objhb = adminSessionBean.GetAllHotelBookings();
//            for(Hotelbooking objhbs : objhb)
//            {
//                out.println("hotelbooking id: "+ " " + objhbs.getHotelbookingId()+" "+ " hotel id: "+objhbs.getHotelId()+" "+"useid: "+ " " + objhbs.getUserId()+" "+"payment_id: "+ " " + objhbs.getPaymentId()+" "+"checkin: "+ " " + objhbs.getCheckinDate());
//            }
      
                Hotelbooking hb=adminSessionBean.GetHotelBookingByID(1);

                out.println("hotelbooking id: "+ " " + hb.getHotelbookingId()+" "+ " hotel id: "+hb.getHotelId()+" "+"useid: "+ " " + hb.getUserId()+" "+"payment_id: "+ " " + hb.getPaymentId()+" "+"checkin: "+ " " + hb.getCheckinDate());

                out.println("</body>");
                    out.println("</html>");
                }
        
       objUserBean.AddHotelRatings(2,1,5,"Best");
            
        
             
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
