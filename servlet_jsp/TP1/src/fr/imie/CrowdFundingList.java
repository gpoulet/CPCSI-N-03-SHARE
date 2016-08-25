package fr.imie;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CrowdFundingList
 */
@WebServlet("/CrowdFundingList")
public class CrowdFundingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrowdFundingList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<CrowdFundingDTO> CFList = new ArrayList<CrowdFundingDTO>();
		CrowdFundingDTO CF1 = new CrowdFundingDTO();
		CF1.setName("barmad");
		CF1.setGoal(100000);
		CF1.setAim(100000);
		CFList.add(CF1);
		CrowdFundingDTO CF2 = new CrowdFundingDTO();
		CF2.setName("BYOS");
		CF2.setGoal(1200000);
		CF2.setAim(198000);
		CFList.add(CF2);
		CrowdFundingDTO CF3 = new CrowdFundingDTO();
		CF3.setName("FCN");
		CF3.setGoal(35000000);
		CF3.setAim(32000000);
		CFList.add(CF3);
		request.getSession().setAttribute("CrowdFundingList",CFList);

		Writer writer=response.getWriter();
		writer.append("<html>");
		writer.append("<body>");
		Integer numLigne=0;
		for (CrowdFundingDTO crowdFundingDTO : CFList) {
			writer.append("<form method=\"post\"><button name=\"numLigne\" value=\""+numLigne+"\">+</button> ");
			request.setAttribute("CrowdFundingGoal", crowdFundingDTO.getGoal());
			request.setAttribute("CrowdFundingName", crowdFundingDTO.getName());
			request.setAttribute("CrowdFundingAim", crowdFundingDTO.getAim());
			request.getRequestDispatcher("/CrowdFundingView").include(request, response);
			writer.append("</form>");
			numLigne++;
		}
		writer.append("</body>");
		writer.append("</html>");
		

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer numLigne = Integer.parseInt(request.getParameter("numLigne"));
		List<CrowdFundingDTO> CFList =(List<CrowdFundingDTO>) request.getSession().getAttribute("CrowdFundingList");
		CrowdFundingDTO current = CFList.get(numLigne);
		//request.getSession().setAttribute("CrowdFundingCurrent", current);
		response.sendRedirect("./CrowdFundingDetailView?name="+current.getName());
	}

}
