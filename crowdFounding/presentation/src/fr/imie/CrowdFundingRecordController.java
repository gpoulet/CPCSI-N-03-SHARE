package fr.imie;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CrowdFundingRecordController
 */
@WebServlet("/CrowdFundingRecordController")
public class CrowdFundingRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB(beanName="CrowdFundingServiceORM") private ICrowdFundingService crowdFundingService;
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrowdFundingRecordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idString = request.getParameter("id");
		Integer id = Integer.parseInt(idString);
		
		CrowdFundingEntity current = null;
		for (CrowdFundingEntity crowdFundingDTO : crowdFundingService.getAllCrowdFunfingDTO()) {
			if(crowdFundingDTO.getId().equals(id)){
				current=crowdFundingDTO;
			}
		}
		
		request.setAttribute("CrowdFundingRecord", current);
		request.getRequestDispatcher("/WEB-INF/CrowdFundingRecord.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		Integer id = Integer.parseInt(idString);
		response.sendRedirect("./CrowdFundingGiveController?id="+id);

	}

}
