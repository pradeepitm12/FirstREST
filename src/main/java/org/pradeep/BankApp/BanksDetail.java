package org.pradeep.BankApp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import Utils.JsonBankDetail;

@Path("banks")
public class BanksDetail {

	JsonBankDetail jbd=new JsonBankDetail();

	JsonNode node=jbd.getBankdata();//getBankJson();
	@GET
	@Path("get_all_banks")
	@Produces(MediaType.APPLICATION_JSON)
	public String getIt(   
			@QueryParam("bank_name") String nameInput,	
			@QueryParam("city_name") String cityInput
			) {
		ObjectMapper mapper=new ObjectMapper();
		ArrayNode arrayNode=mapper.createArrayNode();
		if(nameInput!=null && cityInput!=null){

			for(JsonNode jn:node){

				String bankName=jn.get("bankName").toString();
				String cityname=jn.get("city").toString();

				if(bankName.contains(nameInput)&&cityname.contains(cityInput)){
					arrayNode.add(jn);
				}

			}
		}
		return arrayNode!=null?arrayNode.toString():"No Data";
	}
}
