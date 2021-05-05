package ec.marca.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ec.marca.dao.MarcaDao;
import ec.marca.model.Marca;
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


@WebServlet("/marca")
public class MarcaApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarcaApi() {
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

		String marcaId = request.getParameter("marca-id");
		
	    if(marcaId != null) {
	    	long id = Long.valueOf(marcaId);
	    	
	    	MarcaDao marcaDao = new MarcaDao();
	    	
	        Marca marca = marcaDao.getMarcaById(id);
	     	Gson gson = new Gson();
	    	response.getWriter().append(gson.toJson(marca));
	    	
	    } else {
	    	
	    	MarcaDao marcaDao = new MarcaDao();
	    	
	    	List<Marca> marcas = marcaDao.getAllMarcas();
	        
	    	Gson gson = new Gson();

	    	response.getWriter().append(gson.toJson(marcas));
	    	/*
	    	 for (Marca u : marcas)
	    	 
	    		response.getWriter().append(u.toString());
	    	*/
	    } //if

		
		String id = request.getParameter("marca-id");
		
		if(id != null) 
		{
			MarcaDao marcaDao = new MarcaDao();
			
			long idMarca = Long.valueOf(id);
			
			marcaDao.getMarcaById(idMarca);
			
			
			
		}else 
		{
			
			MarcaDao marcaDao = new MarcaDao();
			
			List<Marca> marcas = marcaDao.getAllMarcas();
			
			Gson gson = new Gson();
			
			response.getWriter().append(gson.toJson(marcas));
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
		
		Marca u = new Marca(
				request.getParameter("id"),
				request.getParameter("descricaoMarca")							
				);
		
		MarcaDao marcaDao = new MarcaDao();
		
		marcaDao.addMarca(u);
		
		System.out.println(u);
		
		response.getWriter().append(u.toString());
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Ajustar errors com try catch
		response.setContentType("application/json"); //mimeType - https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types

		Marca u = new Marca(
				request.getParameter("id"),
				request.getParameter("descricaoMarca")							
				);

		MarcaDao marcaDao = new MarcaDao();
		
		marcaDao.updateMarca(u);
		
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

		if (request.getParameter("marca-id") == null)
			 response.sendError(407, "Informe o ID do usuÃ¡rio a ser retornado!!!" );
		else {
		Long marcaId = Long.valueOf(request.getParameter("marca-id"));
		
		
		
		VehicleDao ud = new VehicleDao();
		
		ud.deleteUser(marcaId);
		
		response.getWriter().append(request.getParameter("marca-id") + " User removido");
		}
	}

}
