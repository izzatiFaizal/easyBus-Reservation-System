package booking.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyBus.dao.BookingDAO;

@WebServlet("/ViewBookingController")
public class ViewBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookingDAO dao;   

    public ViewBookingController() {
        super();
        dao = new BookingDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
        
		if (action.equalsIgnoreCase("view")){			        	
        	int busID = Integer.parseInt(request.getParameter("busID"));        	
        	//forward = VIEW;
        	request.setAttribute("book", dao.getBooking(busID));
        }
		RequestDispatcher view = request.getRequestDispatcher("booking.jsp");
        view.forward(request, response);
	}
}
