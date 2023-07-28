package api.pet;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class PetPutTest {
    private final static String URL = "https://petstore.swagger.io/";
    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private static final String API_KEY = "your-api-key";

    @Test
    void petPositivePutTest() {
        api.reqres.Specifications.installSpecifications(api.reqres.Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());
        PetData newPet = new PetData(1,
                new Category(1, "dog"),
                "GavGav",
                new ArrayList<>(Arrays.asList("https://t0.gstatic.com/licensed-image?q=tbn:ANd9GcQkrjYxSfSHeCEA7hkPy8e2JphDsfFHZVKqx-3t37E4XKr-AT7DML8IwtwY0TnZsUcQ")),
                new ArrayList<>(Arrays.asList(new Tag(1, "Sobaken"))),
                "sold");
        PetData responsePet = given()
                .body(newPet)
                .when()
                .post(URL + "v2/pet")
                .then().log().all()
                .extract().as(PetData.class);
        Assert.assertEquals(newPet.getId(), responsePet.getId());
    }

    @Test
    void userPutPositiveTest(){
        api.reqres.Specifications.installSpecifications(api.reqres.Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());
        UserData user1 = new UserData(2345, "Romul", "Roman", "Ivanov", "s23@mail.ru", "lumoR", "+79183333333", 1);
        SuccessUserReg successUserReg = given()
                .body(user1)
                .when()
                .post(URL + "v2/user")
                .then().log().all()
                .extract().as(SuccessUserReg.class);
        Assert.assertEquals(successUserReg.getMessage(), user1.getId().toString());
    }

    @Test
    void petNegativePutTest(){
        api.reqres.Specifications.installSpecifications(api.reqres.Specifications.requestSpecification(URL), Specifications.uniqueSpecification(400));




        BadInput responsePet = given()
                .body(new PetData(0))
                .when()
                .put(URL + "v2/pet")
                .then().log().all()
                .extract().as(BadInput.class);

    }



        @Test
        public void testCreateExistingPet() {
            api.reqres.Specifications.installSpecifications(api.reqres.Specifications.requestSpecification(URL), Specifications.uniqueSpecification(404));
            // Создаем запрос с информацией о питомце, который уже существует
            String requestBody = "{\"id\": 1, \"name\": \"Fluffy\", \"status\": \"available\"}";

            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .when()
                    .post(URL + "v2/pet");

            Assert.assertTrue(response.getBody().asString().contains("Duplicate pet id"));
        }
//    private static final String API_KEY = "your-api-key";
//    @Test
//    public void testNegativeScenarioWithPostRequest() {
//        given()
//                .baseUri(URL)
//                .header("api_key", API_KEY)
//                .contentType("application/json")
//                .body("{\"name\": \"Bobby\"}")
//                .when()
//                .post("v2/pet")
//                .then()
//                .statusCode(404)
//                .extract().as(BadInput.class);
//    }





        @Test
        public void testNegativeScenarioWithPutRequest() {
            given()
                    .baseUri(BASE_URL)
                    .header("api_key", API_KEY)
                    .contentType("application/json")
                    .body("{\"name\": \"Bobby\"}")
                    .when()
                    .put("/pet/10001") // Assuming 10001 is an existing pet ID
                    .then()
                    .statusCode(400)
                    .body("message", equalTo("Invalid input"));
        }

        @Test
        public void testNegativeScenarioWithPostRequest() {
            given()
                    .baseUri(BASE_URL)
                    .header("api_key", API_KEY)
                    .contentType("application/json")
                    .body("{\"name\": \"Bobby\"}")
                    .when()
                    .post("/pet")
                    .then()
                    .statusCode(405)
                    .body("message", equalTo("Method Not Allowed"));
        }
    }






