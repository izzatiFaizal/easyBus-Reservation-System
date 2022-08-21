package route.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import easyBus.dao.RouteDAO;


@WebServlet("/ListRouteController")
public class ListRouteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListRouteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("rts", RouteDAO.getAllRoute());
		RequestDispatcher view = request.getRequestDispatcher("route.jsp");
		view.forward(request, response);
	}
}
