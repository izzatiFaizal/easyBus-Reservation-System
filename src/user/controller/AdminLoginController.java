package user.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import easyBus.dao.AdminDAO;
import easyBus.model.Admin;


@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminLoginController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Admin admin = new Admin();
			 //retrieve and set email and password
			admin.setAdminID(Integer.parseInt(request.getParameter("adminID")));
			admin.setAdminIC(request.getParameter("adminIC"));
			admin.setAdminName(request.getParameter("adminName"));
			admin = AdminDAO.login(admin);
			//set user session if user is valid
			if(admin.isValid()){
				 //get the current session
				HttpSession session = request.getSession(true);
				 //set current session based on email
				session.setAttribute("currentSessionUser", admin.getAdminName());
				response.sendRedirect("admin.jsp"); // logged-in page
			}
			//redirect to invalidLoggin.jsp if user is not valid
			else{
				response.sendRedirect("adminlogin.jsp");
			}
		}
		catch (Throwable ex) {
			System.out.println(ex);
		}

	}

}
