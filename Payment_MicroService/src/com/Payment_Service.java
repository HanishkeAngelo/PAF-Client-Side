package com;
import model.Payment; 
//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*; 
//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 
@Path("/Payment") 
public class Payment_Service {
	Payment paymentobj = new Payment();

	//retrieve
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems() {
		return paymentobj.readItems();
	}
	
	//insert
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPayment(@FormParam("cus_name") String cus_name, @FormParam("mobile_no") String mobile_no,
			@FormParam("amount") String amount, @FormParam("email") String email,
			@FormParam("card_type") String card_type, @FormParam("card_no") String card_no,
			@FormParam("exp_month") String exp_month, @FormParam("exp_year") String exp_year,
			@FormParam("cvn") String cvn)

	{
		String output = paymentobj.insertPayment(cus_name, mobile_no, amount, email, card_type, card_no, exp_month,
				exp_year, cvn);
		return output;
	}
	
	//update
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePayment(String paymentData) {
		// Convert the input string to a JSON object
		JsonObject itemObject = new JsonParser().parse(paymentData).getAsJsonObject();
		// Read the values from the JSON object
		String payment_id = itemObject.get("payment_id").getAsString();
		String cus_name = itemObject.get("cus_name").getAsString();
		String mobile_no = itemObject.get("mobile_no").getAsString();
		String amount = itemObject.get("amount").getAsString();
		String email = itemObject.get("email").getAsString();
		String card_type = itemObject.get("card_type").getAsString();
		String card_no = itemObject.get("card_no").getAsString();
		String exp_month = itemObject.get("exp_month").getAsString();
		String exp_year = itemObject.get("exp_year").getAsString();
		String cvn = itemObject.get("cvn").getAsString();
		String output = paymentobj.updatePayment(payment_id, cus_name, mobile_no, amount, email, card_type, card_no,
				exp_month, exp_year, cvn);
		return output;
	}
	
	//delete
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePayment(String paymentData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(paymentData, "", Parser.xmlParser());

		// Read the value from the element <itemID>
		String payment_id = doc.select("payment_id").text();
		String output = paymentobj.deletePayment(payment_id);
		return output;
	}
		
}

