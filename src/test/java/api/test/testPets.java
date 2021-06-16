package api.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import api.endpoints.petEndpoints;
import api.payload.pet;
import io.restassured.response.Response;

public class testPets {
    Faker faker;
    pet petPayload;


    @BeforeTest
    public void beforeTest()
    {
        System.out.println("**************** PET UNDER TEST ***************");
        faker=new Faker();
        petPayload=new pet();
        petPayload.setPetId(faker.idNumber().hashCode());
        petPayload.setPetName(faker.dog().name());
        petPayload.setCategoryId(1);
        petPayload.setCategoryName("Dogs");

        List<String> photoList=new ArrayList<String>();
        photoList.add("photourlstring");
        petPayload.setPhotoUrl(photoList);
        petPayload.setTagId(0);
        petPayload.setTagName("TagTest");
        petPayload.setStatus("available");
        System.out.println("Random id and petname by Faker:\t"+petPayload.getPetId()+" - "+petPayload.getPetName());
        System.out.println("**********************************************");
    }

    @Test(priority = 1)
    public void testPostPet()

    {

        Map<String,Object> catParams=new HashMap<String,Object>();
        catParams.put("id",petPayload.getCategoryId());
        catParams.put("name",petPayload.getCategoryName());


        List<Map<String,Object>> photos=new ArrayList<>();
        Map<String,Object> phoParams=new HashMap<String,Object>();
        phoParams.put("",petPayload.getPhotoUrl());
        photos.add(phoParams);


        List<Map<String,Object>> tags=new ArrayList<>();
        Map<String,Object> tagParams=new HashMap<String,Object>();
        tagParams.put("id",petPayload.getTagId());
        tagParams.put("name",petPayload.getTagName());

        tags.add(tagParams);


        Map<String,Object> bodyParams=new HashMap<String,Object>();
        bodyParams.put("id",petPayload.getPetId());
        bodyParams.put("name",petPayload.getPetName());
        bodyParams.put("category",catParams);
        bodyParams.put("photoUrls", petPayload.getPhotoUrl());
        bodyParams.put("tags",tags);
        bodyParams.put("status",petPayload.getStatus());
        String payload=new Gson().toJson(bodyParams);
        System.out.println("***************  POST  *********************");
        System.out.println("------  " + payload);


        Response response=petEndpoints.createPet(payload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(response.getStatusLine().contains("OK"));

        System.out.println("********** "+this.petPayload.getPetName()+" is created ************");
    }

    @Test(priority = 2)
    public void testGetPetById()
    {
        System.out.println("************  GET  *************************");

        Response response=petEndpoints.readPet(this.petPayload.getPetId());
        response.then().log().body().statusCode(200);

        System.out.println("********** "+this.petPayload.getPetId()+" get ************");

        System.out.println("************  "+this.petPayload.getPetName()+" is fetched **********");
    }

    @Test(priority = 3)
    public void testUpdatePetbyId()
    {
        Map<String,Object> catParams=new HashMap<String,Object>();
        catParams.put("id",petPayload.getCategoryId());
        catParams.put("name",petPayload.getCategoryName());


        List<Map<String,Object>> tags=new ArrayList<>();
        Map<String,Object> tagParams=new HashMap<String,Object>();
        tagParams.put("id",petPayload.getTagId());
        tagParams.put("name",petPayload.getTagName());

        tags.add(tagParams);


        Map<String,Object> bodyParams=new HashMap<String,Object>();
        bodyParams.put("id",petPayload.getPetId());
        bodyParams.put("name",petPayload.getPetName());
        bodyParams.put("category",catParams);
        bodyParams.put("photoUrls", petPayload.getPhotoUrl());
        bodyParams.put("tags",tags);
        bodyParams.put("status","pending");
        String payload=new Gson().toJson(bodyParams);
        System.out.println("************  UPDATE - PUT  **********************");
        System.out.println("------  " + payload);

        Response response=petEndpoints.updatePutPet(this.petPayload.getPetId(), payload);
        response.then().log().body().statusCode(200);

        Response afterUpdateResponse=petEndpoints.readPet(this.petPayload.getPetId());
        afterUpdateResponse.then().log().body().statusCode(200);


        System.out.println("*********  "+this.petPayload.getPetName()+" is updated ************");
    }

    @Test(priority = 4)
    public void testGetFindbyStatusAvailable()
    {
        System.out.println("************  FIND BY STATUS  (AVAILABLE) *************************");

        Response response=petEndpoints.readPetStatus("available");
        response.then().log().body().statusCode(200);

        System.out.println("************ Status Available is fetched **********");
    }

    @Test(priority = 5)
    public void testGetFindbyStatusPending()
    {
        System.out.println("************  FIND BY STATUS  (PENDING) *************************");

        Response responsePen=petEndpoints.readPetStatus("pending");
        responsePen.then().log().body().statusCode(200);

        System.out.println("************ Status Pending is fetched **********");
    }

    @Test(priority = 6)
    public void testPostUpdate()
    {
        System.out.println("************  UPDATE POST  *************************");

        Response response=petEndpoints.updatePet(this.petPayload.getPetId(),"Laika","pending");
        response.then().log().body().statusCode(200);

        System.out.println("************ "+this.petPayload.getPetId()+" is updated (POST) **********");
    }

    @Test(priority = 8)
    public void testGetFindbyTagsPending()
    {
        System.out.println("************  FIND BY TAGS  (TAG1) *************************");

        Response responsep=petEndpoints.readPetTags("TagTest");
        responsep.then().log().body().statusCode(200);

        System.out.println("************ Tag TagTest is fetched **********");
    }

    @Test(priority = 9)
    public void testDeleteUserByName()
    {
        System.out.println("************** DELETE ******************************");

        Response response=petEndpoints.deletePet(this.petPayload.getPetId());
        response.then().log().body().statusCode(200);

        System.out.println("********  "+this.petPayload.getPetName()+" is deleted *************");
    }
}
