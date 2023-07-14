package api.pet;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class PetPutTest {
    private final static String URL = "https://petstore.swagger.io/";

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
    void userUpdatePositiveTest(){
        api.reqres.Specifications.installSpecifications(api.reqres.Specifications.requestSpecification(URL), Specifications.uniqueSpecification(200));
        UserData user2 = new UserData("Romul");
        SuccessUserReg successUpdate = given()
                .body(user2)
                .when()
                .put(URL + "v2/user/Ramul")
                .then().log().all()
                .extract().as(SuccessUserReg.class);

    }
}
