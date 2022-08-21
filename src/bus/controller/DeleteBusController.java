package bus.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyBus.dao.BusDAO;

@WebServlet("/DeleteBusController")
public class DeleteBusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusDAO dao;   

    public DeleteBusController() {
        super();
        dao = new BusDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("delete")){
			int busID = Integer.parseInt(request.getParameter("busID"));
			dao.deleteBus(busID);
			String forward = "buses.jsp";
			//request.setAttribute("buses", dao.getAllBus());
		}
		
		RequestDispatcher view = request.getRequestDispatcher("buses.jsp");
		view.forward(request, response);
	}
}
