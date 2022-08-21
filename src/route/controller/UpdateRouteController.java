package route.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import easyBus.dao.RouteDAO;
import easyBus.model.Route;

@WebServlet("/UpdateRouteController")
public class UpdateRouteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RouteDAO dao;   

    public UpdateRouteController() {
        super();
        dao = new RouteDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int routeID = Integer.parseInt(request.getParameter("routeID"));
		Route route = dao.getRouteById(routeID);
		request.setAttribute("route", route);

		RequestDispatcher view = request.getRequestDispatcher("updateR.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Route route = new Route();
		route.setFromWhere(request.getParameter("fromWhere"));
		route.setToWhere(request.getParameter("toWhere"));
		route.setTicketPrice(Double.parseDouble(request.getParameter("ticketPrice")));
		
		String routeID = request.getParameter("routeID");
		route.setRouteID(Integer.parseInt(routeID));
		 
		dao.updateRoute(route);
		//request.setAttribute("rts", RouteDAO.getAllRoute());
		RequestDispatcher view = request.getRequestDispatcher("route.jsp");
		view.forward(request, response);
	}
}
