package api.pet;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
                new ArrayList<Tag>(Arrays.asList(new Tag(1, "Sobaken"))),
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
    void petNegativePutTest() {
        api.reqres.Specifications.installSpecifications(api.reqres.Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());

        List<PetData> responsePet = given()
                .when()
                .get("v2/pet/findByStatus")
                .then().log().all()
                .extract()
                .jsonPath().getList("status", PetData.class);
                int t = 1;
//        List<String> statuses = responsePet.stream().map(PetData::getStatus).collect(Collectors.toList());
//        for(int i = 0; i < statuses.size(); i++){
//            Assert.assertTrue(statuses.get(i).contains("sold"));
//        }
    }
}
