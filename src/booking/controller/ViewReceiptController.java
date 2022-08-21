package booking.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyBus.dao.BookingDAO;


@WebServlet("/ViewReceiptController")
public class ViewReceiptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingDAO dao;   

    public ViewReceiptController() {
        super();
        dao = new BookingDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
        
		if (action.equalsIgnoreCase("view")){			        	
        	int passID = Integer.parseInt(request.getParameter("passID"));        	
        	//forward = VIEW;
        	request.setAttribute("book", dao.getBookingByPassId(passID));
        }
		RequestDispatcher view = request.getRequestDispatcher("bookingdetails.jsp");
        view.forward(request, response);
	}
}
