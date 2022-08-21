package bus.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import easyBus.dao.BusDAO;
import easyBus.model.Bus;

@WebServlet("/UpdateBusController")
public class UpdateBusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusDAO dao;   

    public UpdateBusController() {
        super();
        dao = new BusDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int busID = Integer.parseInt(request.getParameter("busID"));
		Bus bus = dao.getBusById(busID);
		request.setAttribute("bus", bus);

		RequestDispatcher view = request.getRequestDispatcher("updateB.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Bus bus = new Bus();
		bus.setPlateNo(request.getParameter("plateNo"));
		bus.setBusName(request.getParameter("busName"));
		bus.setRouteID(Integer.parseInt(request.getParameter("routeID")));
		bus.setTicketNo(Integer.parseInt(request.getParameter("ticketNo")));
		
		String busID = request.getParameter("busID");
		bus.setBusID(Integer.parseInt(busID));
		dao.updateBus(bus);

		//request.setAttribute("buses", BusDAO.getAllBus());
		RequestDispatcher view = request.getRequestDispatcher("buses.jsp");
		view.forward(request, response);
	}

}
