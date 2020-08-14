package stepDefinition;

import MyTestRunner.TestNGRunCucumberTestRunner;

import cucumber.api.java.en.Given;
import dto.ZomatoLocationResponseDTO;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ZomatoAPI extends TestNGRunCucumberTestRunner {
    final Properties properties = new Properties();


    @Given("^I do a get call to zomato and search location '(.*)'$")
    public void zomatoLocation(String location) throws IOException {
        properties.load(new FileInputStream("src/main/java/application.properties"));
        RestAssured.baseURI = properties.getProperty("zomato.base.uri");
        RequestSpecification httpRequest = RestAssured.given().queryParam("query",location);
        httpRequest.header("user-key",properties.getProperty("user.key"));

        Response response = httpRequest.request(Method.GET);
        ResponseBody body = response.getBody();
        ZomatoLocationResponseDTO zomatoLocationResponseDTO = body.as(ZomatoLocationResponseDTO.class);

        Assert.assertEquals(zomatoLocationResponseDTO.getStatus(), "success", "status code not success");
        Assert.assertEquals(zomatoLocationResponseDTO.getLocation_suggestions().get(0).getCity_name().toLowerCase(), location, "location does not match");
    }
}
