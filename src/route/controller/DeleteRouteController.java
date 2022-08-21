package route.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import easyBus.dao.RouteDAO;

@WebServlet("/DeleteRouteController")
public class DeleteRouteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RouteDAO dao;   

    public DeleteRouteController() {
        super();
        dao = new RouteDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("delete")){
			int routeID = Integer.parseInt(request.getParameter("routeID"));
			dao.deleteRoute(routeID);
			String forward = "route.jsp";
			request.setAttribute("rts", dao.getAllRoute());
		}
		
		RequestDispatcher view = request.getRequestDispatcher("route.jsp");
		view.forward(request, response);
	}
}
