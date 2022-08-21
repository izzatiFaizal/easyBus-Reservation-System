package route.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyBus.dao.RouteDAO;
import easyBus.model.Route;


@WebServlet("/ViewRouteController")
public class ViewRouteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RouteDAO dao;   

    public ViewRouteController() {
        super();
        dao = new RouteDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int routeID = Integer.parseInt(request.getParameter("routeID"));
		Route route = dao.getRouteById(routeID);
		request.setAttribute("route", route);

		RequestDispatcher view = request.getRequestDispatcher("viewRoute.jsp");
		view.forward(request, response);
	}
}
