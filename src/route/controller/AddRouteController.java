package route.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import easyBus.dao.RouteDAO;
import easyBus.model.Route;

@WebServlet("/AddRouteController")
public class AddRouteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RouteDAO dao;   

    public AddRouteController() {
        super();
        dao = new RouteDAO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Route route = new Route();
		route.setFromWhere(request.getParameter("fromWhere"));
		route.setToWhere(request.getParameter("toWhere"));
		route.setTicketPrice(Double.parseDouble(request.getParameter("ticketPrice")));
		
		dao.addRoute(route);
		RequestDispatcher view = request.getRequestDispatcher("route.jsp");
		view.forward(request, response);
	}

}