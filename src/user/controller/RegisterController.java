package user.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import easyBus.dao.PassengerDAO;
import easyBus.model.Passenger;


@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PassengerDAO dao;   

    public RegisterController() {
        super();
        dao = new PassengerDAO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Passenger user = new Passenger();
		//retrieve input
		user.setEmail(request.getParameter("email"));
		user.setName(request.getParameter("name"));
		user.setICNumber(request.getParameter("ICNumber"));
		user.setPhoneNo(request.getParameter("phoneNo"));
		user.setPassword(request.getParameter("password"));
		user.setConfirmPw(request.getParameter("confirmPw"));

		//set email
		user.setEmail(request.getParameter("email"));

		//check if user exists
		user = PassengerDAO.getPassenger(user);

		//if user not exist, add/register the user
		if(!user.isValid()){

			try {
				dao.add(user);
			} catch (Exception e) {
				e.printStackTrace();
			}

		//redirect to login page
		response.sendRedirect("login.jsp");
		}
	}

}
