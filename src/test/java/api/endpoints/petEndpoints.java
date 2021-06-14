package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class petEndpoints {
    public static Response  createPet(String payload)
    {
        RestAssured.baseURI=environment.base_url;
        Response response=RestAssured.
        given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).
        when().post(environment.post_url);
        return response;
    }
    public static Response readPet(Integer petId)
    {
        RestAssured.baseURI=environment.base_url;
        Response response=RestAssured.
        given().pathParam("petId",petId).
        when().get(environment.get_post_delete_url);
        return response;
    }
    public static Response updatePet(String petId,String payload)
    {
        RestAssured.baseURI=environment.base_url;
        Response response=RestAssured.
        given().contentType(ContentType.JSON).accept(ContentType.JSON).
        pathParam("petId",petId).body(payload).
        when().put(environment.get_post_delete_url);
        return response;
    }
    public static Response deletePet(String petId)
    {
        RestAssured.baseURI=environment.base_url;
        Response response=RestAssured.
        given().pathParam("petId",petId).
        when().delete(environment.get_post_delete_url);
        return response;
    }
}
