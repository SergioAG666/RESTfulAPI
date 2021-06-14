package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class petEndpoints {
    public static Response createUser(String payload)
    {
        RestAssured.baseURI=environment.base_url;
        Response response=RestAssured.
        given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).
        when().post(environment.post_url);
        return response;
    }
    public static Response readUser(String userName)
    {
        RestAssured.baseURI=environment.base_url;
        Response response=RestAssured.
        given().pathParam("username",userName).
        when().get(environment.get_post_delete_url);
        return response;
    }
    public static Response updateUser(String userName,String payload)
    {
        RestAssured.baseURI=environment.base_url;
        Response response=RestAssured.
        given().contentType(ContentType.JSON).accept(ContentType.JSON).
        pathParam("username",userName).body(payload).
        when().put(environment.get_post_delete_url);
        return response;
    }
    public static Response deleteUser(String userName)
    {
        RestAssured.baseURI=environment.base_url;
        Response response=RestAssured.
        given().pathParam("username",userName).
        when().delete(environment.get_post_delete_url);
        return response;
    }
}
