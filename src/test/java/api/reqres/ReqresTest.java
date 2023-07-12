package api.reqres;

import io.restassured.http.ContentType;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    private final static String URL = "https://reqres.in/";

    @Test
    public void checkNameAndID(){
        Specifications.installSpecifications(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());
                List<UserData> userData = given()                                                             // Не сокращённый код
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        userData.stream().forEach(x-> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));

        Assert.assertTrue(userData.stream().allMatch(x->x.getEmail().endsWith("reqres.in")));

        List<String> avatars = userData.stream().map(UserData::getAvatar).collect(Collectors.toList());
        List<String> ids = userData.stream().map(x->x.getId().toString()).collect(Collectors.toList());

        for(int i = 0; i < avatars.size(); i++){
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }





//        List<UserData> userData = given()                                                             // Не сокращённый код
//                .when()
//                .contentType(ContentType.JSON)
//                .get(URL + "api/users?page=2")
//                .then().log().all()
//                .extract().body().jsonPath().getList("data", UserData.class);
//        userData.stream().forEach(x-> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
//
//        Assert.assertTrue(userData.stream().allMatch(x->x.getEmail().endsWith("reqres.in")));
//
//        List<String> avatars = userData.stream().map(UserData::getAvatar).collect(Collectors.toList());
//        List<String> ids = userData.stream().map(x->x.getId().toString()).collect(Collectors.toList());
//
//        for(int i = 0; i < avatars.size(); i++){
//            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
//        }
    }

    @Test
    public void successRegTest(){
        Specifications.installSpecifications(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");
        SuccessReg successReg = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessReg.class);
        Assert.assertEquals(successReg.getId(), id);
        Assert.assertEquals(successReg.getToken(), token);

    }

    @Test
    public void failedRegTest(){
        Specifications.installSpecifications(Specifications.requestSpecification(URL), Specifications.responseSpecificationERROR400());
        String error = "Missing password";
        RegisterFailure user1 = new RegisterFailure("sydney@fife");
        UnsuccessReg unsuccessReg = given()
                .body(user1)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(UnsuccessReg.class);
        Assert.assertEquals(unsuccessReg.getError(), error);
    }

    @Test
    public void correctYearSortTest(){
        Specifications.installSpecifications(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());
        List<ListResources> data = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ListResources.class);
        List<Integer> years = data.stream().map(ListResources::getYear).collect(Collectors.toList());
        List<Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());
        for(int i = 0; i < years.size(); i++){
            Assert.assertTrue(years.get(i).equals(sortedYears.get(i)));
        }
    }
}
