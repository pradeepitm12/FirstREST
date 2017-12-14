package Utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import bean.BankBean;


@Singleton
//Startup
public class JsonBankDetail {

	public static JsonNode bankdata=null;

	public JsonBankDetail(){
		JsonNode node=null;

		try {
			if(bankdata==null){
				InputStream is = getClass().getResourceAsStream("/details.csv");
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader in = new BufferedReader(isr);

				List<Object> details = in .lines().skip(1).map(new Function<String, Object>() {
					@Override
					public Object apply(String line) {

						//String[] x =line.split(",");
						String[] x =line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

						return new BankBean(x[0].toString(),Integer.parseInt(x[1]),x[2].toString(),x[3].toString(),
								x[4].toString(),x[5].toString(),x[6].toString(),x[7].toString());

					}
				}).collect(Collectors.toList());

				ObjectMapper mapper = new ObjectMapper();

				mapper.enable(SerializationFeature.INDENT_OUTPUT);

				node = mapper.valueToTree(details);
			}
			else{
				node=bankdata;
			}

		}
		catch(Exception ex){
			//System.out.println("this is ex-->"+ex);

		}
		setBankdata(node);
	}

	public static JsonNode getBankdata() {
		return bankdata;
	}

	public static void setBankdata(JsonNode bankdata) {
		JsonBankDetail.bankdata = bankdata;
	}





}
