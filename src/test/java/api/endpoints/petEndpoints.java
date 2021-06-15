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
    public static Response readPetStatus(String petStatus)
    {
        RestAssured.baseURI=environment.base_url;
        Response response=RestAssured.
                given().queryParam("status",petStatus).
                when().get(environment.find_status_url);
        return response;
    }
    public static Response readPetTags(String petTags)
    {
        RestAssured.baseURI=environment.base_url;
        Response response=RestAssured.
                given().queryParam("tags",petTags).
                when().get(environment.find_tags_url);
        return response;
    }
    public static Response updatePutPet(Integer petId,String payload)
    {
        RestAssured.baseURI=environment.base_url;
        Response response=RestAssured.
        given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).
        when().put(environment.put_url);
        return response;
    }
    public static Response updatePet(Integer petId,String payload)
    {
        RestAssured.baseURI=environment.base_url;
        Response response=RestAssured.
                given().contentType(ContentType.JSON).accept(ContentType.JSON).
                pathParam("petId",petId).body(payload).
                when().put(environment.get_post_delete_url);
        return response;
    }
    public static Response deletePet(Integer petId)
    {
        RestAssured.baseURI=environment.base_url;
        Response response=RestAssured.
        given().pathParam("petId",petId).
        when().delete(environment.get_post_delete_url);
        return response;
    }
}
