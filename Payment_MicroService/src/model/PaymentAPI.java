package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymentAPI
 */
@WebServlet("/PaymentAPI")
public class PaymentAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Payment paymentObj = new Payment();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String output = paymentObj.insertPayment(request.getParameter("cus_name"),
				 request.getParameter("mobile_no"),
				request.getParameter("amount"),
				request.getParameter("email"),
				request.getParameter("card_type"),
				request.getParameter("card_no"),
				request.getParameter("exp_month"),
				request.getParameter("exp_year"),
				request.getParameter("cvn"));
				response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			 Map paras = getParasMap(request); 
			 String output = paymentObj.updatePayment(paras.get("hidPaymentIDSave").toString(), 
			 paras.get("cus_name").toString(), 
			 paras.get("mobile_no").toString(), 
			 paras.get("amount").toString(), 
			 paras.get("email").toString(),
			 paras.get("card_type").toString(),
			 paras.get("card_no").toString(),
			 paras.get("exp_month").toString(),
			 paras.get("exp_year").toString(),
			 paras.get("cvn").toString());
			 response.getWriter().write(output); 
			
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			 Map paras = getParasMap(request); 
			 String output = paymentObj.deletePayment(paras.get("payment_id").toString()); 
			 response.getWriter().write(output); 
		
	}
	
	private static Map getParasMap(HttpServletRequest request) 
	{ 
		Map<String, String> map = new HashMap<String, String>(); 
		try
		{ 
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
			String queryString = scanner.hasNext() ? 
					scanner.useDelimiter("\\A").next() : ""; 
			scanner.close();
			
			String[] params = queryString.split("&"); 
			for (String param : params) 
			{ 
				String[] p = param.split("=");
				map.put(p[0], p[1]); 
			} 
		} 
		catch (Exception e) 
		{ 
		} 
		return map; 
	}

}
