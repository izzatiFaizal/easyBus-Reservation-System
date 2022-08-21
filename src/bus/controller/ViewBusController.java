package bus.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyBus.dao.BusDAO;
import easyBus.model.Bus;


@WebServlet("/ViewBusController")
public class ViewBusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusDAO dao;   

    public ViewBusController() {
        super();
        dao = new BusDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int busID = Integer.parseInt(request.getParameter("busID"));
		Bus bus = dao.getBusById(busID);
		request.setAttribute("bus", bus);

		RequestDispatcher view = request.getRequestDispatcher("viewBus.jsp");
		view.forward(request, response);
	}
}
