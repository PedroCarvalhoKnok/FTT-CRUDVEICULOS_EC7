package ec.vehicle.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ec.vehicle.dao.VehicleDao;
import ec.vehicle.model.Vehicle;

/**
 * Servlet implementation class UserApi
 * 
 * CRUD - 
 * 
 */

// TODO: PROJETO: CRIAR CRUD WEB + GRÃ�FICO PARA MAIS UMA TABELA COM MAIS CAMPOS PARA N1 2B
// TODO: PROJETO: PROJETO INDIVIDUAL OU NO MÃ�XIMO EM DUPLAS (EM DUPLAS 2 TABELAS)
// TODO: PROJETO: JavaScript Valina - CRUD em uma pÃ¡gina - User "fetch"
// TODO: PROJETO: Gerar grÃ¡fico com "Chart.js" https://www.chartjs.org/
// TODO: PROJETO: Trabalhar bem mensagens de erro da WEB API com try catch


@WebServlet("/vehicle")
public class VehicleApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setStatus(418); //200 - OK - PadrÃ£o (Default)

		String vehicleId = request.getParameter("vehicle-id");
		
	    if(vehicleId != null) {
	    	long id = Long.valueOf(vehicleId);
	    	
	    	VehicleDao vehicleDao = new VehicleDao();
	    	
	        Vehicle vehicle = vehicleDao.getUserById(id);
	     	Gson gson = new Gson();
	    	response.getWriter().append(gson.toJson(vehicle));
	    	
	    } else {
	    	
	    	VehicleDao vehicleDao = new VehicleDao();
	    	
	    	List<Vehicle> vehicles = vehicleDao.getAllUser();
	        
	    	Gson gson = new Gson();

	    	response.getWriter().append(gson.toJson(vehicles));
	    	/*
	    	 for (User u : users)
	    	 
	    		response.getWriter().append(u.toString());
	    	*/
	    } //if

		
		String id = request.getParameter("vehicle-id");
		
		if(id != null) 
		{
			VehicleDao vehicleDao = new VehicleDao();
			
			long idUser = Long.valueOf(id);
			
			vehicleDao.getUserById(idUser);
			
			
			
		}else 
		{
			
			VehicleDao vehicleDao = new VehicleDao();
			
			List<Vehicle> vehicles = vehicleDao.getAllUser();
			
			Gson gson = new Gson();
			
			response.getWriter().append(gson.toJson(vehicles));
			/*
			for(User u: users) {
				
				response.getWriter().append(u.toString());
				
				
			}*/
		}
		
		
		//response.getWriter().append("DB Served date: ").append(userDao.getDbDate()).append(" - ").append(System.getenv("PATH"));
		response.getWriter().append("FTT_PWD - ").append(System.getenv("FTT_PWD"));
		
		
	} //doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Vehicle u = new Vehicle(
				request.getParameter("id"),
				request.getParameter("marca"),
				request.getParameter("modelo"),
				request.getParameter("chassi"),
				request.getParameter("placa"),
				request.getParameter("cor"),
				request.getParameter("condicao"),
				request.getParameter("dataFabricacao"),				
				request.getParameter("preco")				
				);
		
		VehicleDao vehicleDao = new VehicleDao();
		
		vehicleDao.addUser(u);
		
		System.out.println(u);
		
		response.getWriter().append(u.toString());
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Ajustar errors com try catch
		response.setContentType("application/json"); //mimeType - https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types

		Vehicle u = new Vehicle(
				request.getParameter("id"),
				request.getParameter("marca"),
				request.getParameter("modelo"),
				request.getParameter("chassi"),
				request.getParameter("placa"),
				request.getParameter("cor"),
				request.getParameter("condicao"),
				request.getParameter("dataFabricacao"),				
				request.getParameter("preco")				
				);

		VehicleDao vehicleDao = new VehicleDao();
		
		vehicleDao.updateUser(u);
		
		System.out.println(u);
		
		response.getWriter().append(u.toString());

	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// https://www.tutorialspoint.com/servlets/servlets-http-status-codes.htm
		// Reference: https://www.tutorialspoint.com/servlets/servlets-http-status-codes.htm
		// 
		
		response.setStatus(418); //200 - OK - PadrÃ£o (Default)

		if (request.getParameter("vehicle-id") == null)
			 response.sendError(407, "Informe o ID do usuÃ¡rio a ser retornado!!!" );
		else {
		Long vehicleId = Long.valueOf(request.getParameter("vehicle-id"));
		
		
		
		VehicleDao vd = new VehicleDao();
		
		vd.deleteUser(vehicleId);
		
		response.getWriter().append(request.getParameter("vehicle-id") + " Veiculo removido");
		}
	}

}
