package bus.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import easyBus.dao.BusDAO;
import easyBus.dao.RouteDAO;
import easyBus.model.Bus;


@WebServlet("/AddBusController")
public class AddBusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusDAO dao;   
    private RouteDAO rdao;
    
    public AddBusController() {
        super();
        dao = new BusDAO();
        rdao = new RouteDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("rts", RouteDAO.getRouteId());
		RequestDispatcher view = request.getRequestDispatcher("/addBus.jsp");
		view.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Bus bus = new Bus();
		bus.setPlateNo(request.getParameter("plateNo"));
		bus.setBusName(request.getParameter("busName"));
		bus.setRouteID(Integer.parseInt(request.getParameter("routeID")));
		bus.setTicketNo(Integer.parseInt(request.getParameter("ticketNo")));
		
		dao.addBus(bus);
		RequestDispatcher view = request.getRequestDispatcher("buses.jsp");
		view.forward(request, response);
	}

}
