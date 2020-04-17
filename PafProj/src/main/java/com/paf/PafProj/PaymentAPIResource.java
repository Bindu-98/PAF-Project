package com.paf.PafProj;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("Payment")
public class PaymentAPIResource {

	//-------------------------SELECT ALL-----------------------
	@GET
	@Path("/Select")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ArrayList<Payment> SelectAll() throws Exception
	{
		PaymentHandlr hndlr = new PaymentHandlr();
		return hndlr.SelectAll();
	}



	//-------------------------SELECT WHERE-----------------------
		@GET
		@Path("/SelectPay/{pid}")
		@Produces(MediaType.APPLICATION_JSON)
		public Payment Select_Where(@PathParam("pid") int pid) throws SQLException
		{
			PaymentHandlr hndlr = new PaymentHandlr();
			return hndlr.SelectWhere(pid);
		}
		
	//-------------------------INSERT INTO--------------------------
					
		@POST
		@Path("/Insert")
		public String insert_details(Payment pay) throws SQLException
		{
			PaymentHandlr hndlr = new PaymentHandlr();
			String retval = hndlr.InsertIntoPayment(pay);
			return retval;
		}
		
	//-------------------------DELETE--------------------------
		
		@DELETE
		@Path("/Delete/{pid}")
		public String Delete_Details(@PathParam("pid") String pid) throws SQLException
		{
			PaymentHandlr hndlr = new PaymentHandlr();
			String retval = hndlr.DeleteDetails(pid);
			return retval;
		}
		
	//-------------------------UPDATE--------------------------

		@PUT
		@Path("/update")
		public String Update_Details(Payment pay) throws SQLException
		{
			PaymentHandlr hndlr = new PaymentHandlr();
			String retval = hndlr.updatePayment(pay);
			return retval;
		}
		

}


