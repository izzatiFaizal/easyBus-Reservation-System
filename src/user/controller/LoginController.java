package user.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import easyBus.dao.PassengerDAO;
import easyBus.model.Passenger;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Passenger user = new Passenger();

			//retrieve and set email and password
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			user.setName(request.getParameter("name"));
			//user.setICNumber(request.getParameter("ICNumber"));
			//user.setPhoneNo(request.getParameter("phoneNo"));
			//user.setPassID(Integer.parseInt(request.getParameter("passID")));
			user = PassengerDAO.login(user);
			//set user session if user is valid
			if(user.isValid())
			{
				//get the current session
				HttpSession session = request.getSession(true);
				//set current session based on email
				session.setAttribute("currentSessionUser", user.getName());
				session.setAttribute("email", user.getEmail());
				session.setAttribute("ICNumber", user.getICNumber());
				session.setAttribute("phoneNo", user.getPhoneNo());
				session.setAttribute("passID", user.getPassID());
				
				//session.getEmail();
				response.sendRedirect("home.jsp"); // logged-in page
			}
			//redirect to invalidLoggin.jsp if user is not valid
			else{
				response.sendRedirect("login.jsp");
			}
		}
		catch (Throwable ex) {
			System.out.println(ex);
		}
	}

}
