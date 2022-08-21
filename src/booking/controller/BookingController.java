package booking.controller;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import easyBus.dao.BookingDAO;
import easyBus.model.Booking;


@WebServlet("/BookingController")
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookingDAO dao;   

    public BookingController() {
        super();
        dao = new BookingDAO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Booking book = new Booking();
		book.setBusID(Integer.parseInt(request.getParameter("busID")));
		book.setBusName(request.getParameter("busName"));
		book.setFromWhere(request.getParameter("fromWhere"));
		book.setToWhere(request.getParameter("toWhere"));
		book.setTicketTime(request.getParameter("ticketTime"));
		String date = request.getParameter("date");
		Date newDate;
		try {
			newDate = new SimpleDateFormat("yyyy-mm-dd").parse(date);
			book.setDate(newDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		book.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		book.setPassID(Integer.parseInt(request.getParameter("passID")));
		
		//String busID = request.getParameter("busID");
		//book.setBusID(Integer.parseInt(busID));
		dao.addBooking(book);

		//request.setAttribute("buses", BusDAO.getAllBus());
		RequestDispatcher view = request.getRequestDispatcher("thankyou.jsp");
		view.forward(request, response);
	}

}
