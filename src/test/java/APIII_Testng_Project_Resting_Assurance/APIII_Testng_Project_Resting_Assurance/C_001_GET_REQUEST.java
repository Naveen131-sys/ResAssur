package APIII_Testng_Project_Resting_Assurance.APIII_Testng_Project_Resting_Assurance;

import java.sql.Time;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class C_001_GET_REQUEST {
// GET REQUEST NO.1
	/*@Test
	public void GetResults() {
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httprequest=RestAssured.given();
		Response response=httprequest.request(Method.GET, "/2");
		String responsebody=response.getBody().asString();
		System.out.println("The response body is"+responsebody);
		
		int statuscode=response.getStatusCode();
		
		Assert.assertEquals(statuscode, 200);
	}
	
	
//GET REQUEST NO.2
	
@Test
public void GetRequest() {
	RestAssured.baseURI="https://reqres.in/api/users";
	RequestSpecification r=RestAssured.given();
	Response r1=r.request(Method.GET, "/3");
	String responsebody=r1.getBody().toString();
	System.out.println(responsebody);
	
	String Statusline=r1.getStatusLine();
	System.out.println(Statusline);
	
}


// GET REQUEST NO.3
@Test
public void GetRequest2() {
	
	RestAssured.baseURI="https://reqres.in/api/users/3";
	RequestSpecification request=RestAssured.given();
	Response response=request.request(Method.GET);
	String GetBody=response.getBody().asString();
	System.out.println("The Body is"+GetBody);
	
	int statuscode=response.getStatusCode();
	Assert.assertEquals(statuscode, 200);
	
	String SuccessCode=response.jsonPath().getString("Success Code");
	System.out.println(SuccessCode);
}
*/

// POST Request No.1
/*@Test
public void GetPostRequest() {
	
	RestAssured.baseURI="https://reqres.in/api/users";
	RequestSpecification r=RestAssured.given();
	JSONObject json=new JSONObject();
	json.put("names", "morphes");
	json.put("job", "leader");
	r.body(json.toJSONString());
	Response response=r.request(Method.POST);
	int statuscode=response.getStatusCode();
	System.out.println("The status code is"+statuscode);
	
}*/


// Get Request No.4
	/*
@Test
public void GetRequest_RetAssured() {
	
	RestAssured.baseURI="https://reqres.in/api/users";
	RequestSpecification r=RestAssured.given();
	Response res=r.request(Method.GET,"/6");
	Headers FirstResult=res.getHeaders();
	System.out.println("The Headers are"+FirstResult);
	
	String SecondResult=res.jsonPath().toString();
	System.out.println("The Json view is"+SecondResult);
	
	long ThirdResult=res.time();
	System.out.println("The elapsed time is"+ThirdResult);
	
	long ForthResult = res.getTime();
	System.out.println("The elapsed time is"+ForthResult);
	
	String FifthResult = res.xmlPath().toString();
	System.out.println("The elapsed time is"+FifthResult);
	
}*/

/*@Test
public void PostRequest_RestAssured() {
	
	RestAssured.baseURI="https://reqres.in/api/users";
	RequestSpecification req=RestAssured.given();
	JSONObject requestparams=new JSONObject();
	requestparams.put("names", "morpheus");
	requestparams.put("job", "leader");
	
	req.header("Content-Type","application/json");
	req.body(requestparams.toJSONString());//adding the body to request..
	Response res=req.request(Method.POST);
	
	
	String ResponseBody=res.getBody().asString();
	System.out.println("The Response Body is"+ResponseBody);
	
	int Statuscode=res.getStatusCode();
	System.out.println("The Status Code is"+Statuscode);
}*/


/*@Test
public void Post_Requests() {
	RestAssured.baseURI="https://reqres.in/api/users";
	RequestSpecification req=RestAssured.given();
	JSONObject json=new JSONObject();
	json.put("name", "Naveen Gera");
	json.put("job", "leader");
	
	req.header("Content-Type","application/json");
	req.body(json.toJSONString());
	Response res=req.request(Method.PUT);
	String header = res.header("Content-Type");
	System.out.println("The Header Name is"+header);
	String header1=res.getHeader("Content-Type");
	System.out.println("The Header 1 Name is "+header1);
	String Values=res.getBody().asString();
	System.out.println("The result is"+Values);
	
	Headers AllHeaders=res.getHeaders();
	System.out.println("All the Headers are"+AllHeaders);
	
	
	
}


@Test
public void Headers_Print() {
	
	RestAssured.baseURI="https://reqres.in/api/users";
	RequestSpecification req=RestAssured.given();
	Response res=req.request(Method.GET,"/4");
	String JsonResponse=res.getBody().asString();
	
	Headers header=res.headers();
	for(Header h:header) {
		
		System.out.println("The Tag Name of Header is "+h.getName()+" and the value of Header is"+h.getValue());
	}
}*/



/*@Test
public void JsonPathValidation() {
	
	RestAssured.baseURI="https://reqres.in/api/users";
	RequestSpecification req=RestAssured.given();
	Response resp=req.request(Method.GET,"/4");
    String responsebody=resp.getBody().asString();
    Assert.assertEquals(responsebody.contains("Holteeee"), true);
}*/


@Test
public void JSONValidation() {
	RestAssured.baseURI="https://reqres.in/api/users";
	PreemptiveBasicAuthScheme auth=new PreemptiveBasicAuthScheme();
	auth.setPassword("abc");
	auth.setUserName("def");
	RestAssured.authentication=auth;
	RequestSpecification req=RestAssured.given();
	Response res=req.request(Method.GET,"?delay=3");
	String resp=res.getBody().asString();
	System.out.println();
	JsonPath jsonpath=res.jsonPath();
	System.out.println(resp);
	System.out.println(jsonpath.get("per_page"));
	
	Assert.assertEquals(jsonpath.get("per_page"), 6);
	//System.out.println(jsonpath.get("first_name"));
	
}






	

}
