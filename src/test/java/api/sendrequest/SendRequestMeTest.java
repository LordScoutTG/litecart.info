package api.sendrequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;

public class SendRequestMeTest {

    private final static String URL = "https://send-request.me";
    private final Integer limit = 3;
    private final Integer offset = 2;
    private final File CompaniesDataSchema = new File("src/test/java/api/sendrequest/jsonschema/CompaniesDataSchema.json");

    @Test
    void activeLimitCompanyTest() {
        Specifications.installSpecifications(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200(CompaniesDataSchema));
        List<CompaniesData> activeCompanies = given()
                .param("limit", limit)
                .when()
                .get("/api/companies/")
                .then().log().all()
                .extract().body().jsonPath().getList("data", CompaniesData.class);
        activeCompanies.forEach(x -> Assert.assertEquals(x.getCompany_status(), "ACTIVE"));
        List<String> statuses = activeCompanies.stream().map(CompaniesData::getCompany_status).collect(Collectors.toList());
        Assert.assertEquals(statuses.size(), limit);
    }

    @Test
    void limitOffsetCompanyTest() {
        Specifications.installSpecifications(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200(CompaniesDataSchema));
        List<CompaniesData> pullCompanies = given()
                .param("limit", limit)
                .param("offset", offset)
                .when()
                .get("/api/companies/")
                .then().log().all()
                .extract().body().jsonPath().getList("data", CompaniesData.class);
        List<Integer> ids = pullCompanies.stream().map(CompaniesData::getCompany_id).collect(Collectors.toList());
        List<Integer> sortedIds = ids.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < ids.size(); i++) {
            Assert.assertTrue(ids.get(i).equals(sortedIds.get(i)));
        }
        Assert.assertEquals(pullCompanies.stream().map(CompaniesData::getCompany_id).findFirst().get(), offset + 1);
        Assert.assertEquals(ids.size(), limit);
    }

    private int companyId = 8;
    private final File badPostRequestSchema = new File("src/test/java/api/sendrequest/jsonschema/BadPostRequestSchema.json");

    @Test
    void unsuccessUserPostIdComp() {
        Specifications.installSpecifications(Specifications.requestSpecification(URL), Specifications.uniqueSpecification(404, badPostRequestSchema));
        PostUserData incorrectUserIdComp = new PostUserData("Roman", "Remizov", companyId);
        ResponseError error = given()
                .body(incorrectUserIdComp)
                .when()
                .post("/api/users/")
                .then().log().all()
                .extract().as(ResponseError.class);
        Assert.assertEquals(error.getDetail().getReason(), String.format("Company with requested id: %s is absent", companyId));

    }

}
