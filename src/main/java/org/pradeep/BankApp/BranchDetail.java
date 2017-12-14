package org.pradeep.BankApp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.JsonBankDetail;
@Path("branch")
public class BranchDetail {

	JsonBankDetail jbd=new JsonBankDetail();

	JsonNode node=jbd.getBankdata();//getBankJson();
	@GET
	@Path("get_branch_detail")
	@Produces(MediaType.APPLICATION_JSON)
	public String getIt(   
			@QueryParam("ifsc") String ifscInput       
			) {
		JsonNode response=null;

		if(ifscInput!=null){
			for(JsonNode jn:node){

				String abc=jn.get("ifsc").toString();

				if(abc.contains(ifscInput)){
					response=jn;
				}

			}
		}
		return response!=null?response.toString():"No Data";
	}
}
