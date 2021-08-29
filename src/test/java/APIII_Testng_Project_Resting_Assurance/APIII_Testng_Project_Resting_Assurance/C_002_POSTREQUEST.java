package APIII_Testng_Project_Resting_Assurance.APIII_Testng_Project_Resting_Assurance;

import java.io.IOException;

import org.apache.groovy.parser.antlr4.GroovyParser.ExclusiveOrExprAltContext;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class C_002_POSTREQUEST {
	
	@Test(dataProvider ="FixedData1")
	public void Postt_Requests(String Name,String Post) {
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification req=RestAssured.given();
		JSONObject json=new JSONObject();
		json.put("name", Name);
		json.put("job", Post);
		
		req.header("Content-Type","application/json");
		req.body(json.toJSONString());
		Response resp=req.request(Method.POST);
		String GetStringBody=resp.getBody().asString();
		System.out.println("The String Body is"+GetStringBody);
		
	}
	
	/*
	@DataProvider(name="FixedData")
	public String[][] Getdata(){
		String EmpData[][] = {{"Naveen Gera","IAS Officer"},{"Vipin Rawat","Deputy Commissioner"}};
		return EmpData;
		
	}*/
	
	
	@DataProvider(name="FixedData1")
	public String[][] Getdata1() throws IOException{
		String path = System.getProperty("user.dir/")+"APIII_Testng_Project_Resting_Assurance.APIII_Testng_Project_Resting_Assurance/src/test/java/Naveen_Gera.xlsx";
		ExcelllllingUtils e=new ExcelllllingUtils();
		int rows = e.GetRowCount(path, "Sheet1");
		System.out.println("The Number of rows are"+rows);
		
		int columns = e.GetColumnCount(path, "Sheet1", 1);
		System.out.println("The Number of columns are"+columns);
		
		String Empdata[][] = new String[rows][columns];
		
		for(int i=1;i<=rows;i++) {
			
			for(int j=0;j<columns;j++) {
				
				Empdata[i-1][j]=e.GetData(path, "Sheet1", i, j);
			}
		}
		
		return Empdata;
		
	}

}
