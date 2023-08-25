package api.sendrequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;

public class SendRequestMeTest {

    private final static String URL = "https://send-request.me";
    private final File CompaniesDataSchema = new File("src/test/java/api/sendrequest/jsonschema/CompaniesDataSchema.json");

    @Test
    void activeLimitCompanyTest() {
        final int limit = 3;
        Specifications.installSpecifications(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200(CompaniesDataSchema));
        List<CompaniesData> activeCompanies = given()
                .param("limit", limit)
                .when()
                .get("/api/companies/")
                .then().log().all()
                .extract().body().jsonPath().getList("data", CompaniesData.class);
        activeCompanies.forEach(x -> Assert.assertEquals(x.getCompanyStatus(), "ACTIVE"));
        List<String> statuses = activeCompanies.stream().map(CompaniesData::getCompanyStatus).collect(Collectors.toList());
        Assert.assertEquals(statuses.size(), limit);
    }

    @Test
    void limitOffsetCompanyTest() {
        final int limit = 3;
        final int offset = 2;
        Specifications.installSpecifications(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200(CompaniesDataSchema));
        List<CompaniesData> pullCompanies = given()
                .param("limit", limit)
                .param("offset", offset)
                .when()
                .get("/api/companies/")
                .then().log().all()
                .extract().body().jsonPath().getList("data", CompaniesData.class);
        List<Integer> ids = pullCompanies.stream().map(CompaniesData::getCompanyId).collect(Collectors.toList());
        List<Integer> sortedIds = ids.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < ids.size(); i++) {
            Assert.assertTrue(ids.get(i).equals(sortedIds.get(i)));
        }
        Assert.assertEquals((int) pullCompanies.stream().map(CompaniesData::getCompanyId).findFirst().get(), offset + 1);
        Assert.assertEquals(ids.size(), limit);
    }


    @Test
    void unsuccessUserPostIdComp() {
        int companyId = 8;
        final File badPostRequestSchema = new File("src/test/java/api/sendrequest/jsonschema/BadPostRequestSchema.json");
        Specifications.installSpecifications(Specifications.requestSpecification(URL), Specifications.uniqueSpecification(404, badPostRequestSchema));
        PostUserData incorrectUserIdComp = DataGenerator.getSimpleUser();

        ResponseError error = given()
                .body(incorrectUserIdComp)
                .when()
                .post("/api/users/")
                .then().log().all()
                .extract().as(ResponseError.class);

        Assert.assertEquals(error.getDetail().getReason(), String.format("Company with requested id: %s is absent", companyId));

    }

}
