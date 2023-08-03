package api.sendrequest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.File;

public class Specifications {

    public static RequestSpecification requestSpecification(String URL) {
        return new RequestSpecBuilder()
                .setBaseUri(URL)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpecificationOK200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification responseSpecificationOK200(File file) {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody(JsonSchemaValidator.matchesJsonSchema(file))
                .build();
    }

    public static ResponseSpecification responseSpecificationERROR400() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }

    public static ResponseSpecification uniqueSpecification(Integer status) {
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .build();
    }

    public static ResponseSpecification uniqueSpecification(Integer status, File file) {
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .expectBody(JsonSchemaValidator.matchesJsonSchema(file))
                .build();
    }

    public static void installSpecifications(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;

    }
}
