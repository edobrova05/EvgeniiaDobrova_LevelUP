package homework_8;

import Homework_8.People.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GoRestUsersTest {

    RequestSpecification rqSpec;
    ResponseSpecification rsSpec;

    @BeforeClass
    public void beforeClass() {
        rqSpec = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        rsSpec = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectStatusCode(Matchers.greaterThanOrEqualTo(200))
                .build();
    }

    @Test
    public void postUserTest() {

        CreateUserRequest request = new CreateUserRequest("123",
                "Evgeniia",
                "evgeniia123@gmail.com",
                "Female",
                "Active",
                "2021-07-09T03:50:03.657+05:30",
                "2021-07-09T18:34:07.276+05:30");
        CreateUserResponse expected = CreateUserResponse.builder()
                .id(request.getId())
                .name(request.getName())
                .email(request.getEmail())
                .gender(request.getGender())
                .status(request.getStatus())
                .created_at(request.getCreated_at())
                .updated_at(request.getUpdated_at())
                .build();

        String accessToken = "6733700d981d5126e2a88251a169121e86b4efe412364040da6c09d39cd21dd4";

        CreateUserResponse res = RestAssured
                //.given(rqSpec).auth().oauth2(request.getToken())
                .given(rqSpec)
                .header("Authorization", "Bearer " + accessToken)

                .body(request)
                .when()
                .post("/public-api/users")
                .then()
                .spec(rsSpec)
                .extract()
                .as(CreateUserResponse.class);

        assertThat(res, equalTo(expected));

    }

    @Test
    public void putUserTest() {
        CreateUserRequest request = new CreateUserRequest("123",
                "Evgeniia Dobrova",
                "evgeniia123@gmail.com",
                "Female",
                "Active",
                "2021-07-09T03:50:03.657+05:30",
                "2021-07-09T18:34:07.276+05:30");
        CreateUserResponse expected = CreateUserResponse.builder()
                .id(request.getId())
                .name(request.getName())
                .email(request.getEmail())
                .gender(request.getGender())
                .status(request.getStatus())
                .created_at(request.getCreated_at())
                .updated_at(request.getUpdated_at())
                .build();

        String accessToken = "6733700d981d5126e2a88251a169121e86b4efe412364040da6c09d39cd21dd4";
        CreateUserResponse res = RestAssured
                .given(rqSpec)
                .header("Authorization", "Bearer " + accessToken)
                .body(request)
                .when()
                .put("/public-api/users/123")
                .then()
                .spec(rsSpec)
                .extract()
                .as(CreateUserResponse.class);

        assertThat(res, equalTo(expected));

    }

    @Test
    public void deleteUserTest() {
        CreateUserRequest request = new CreateUserRequest("123",
                "Evgeniia Dobrova",
                "evgeniia123@gmail.com",
                "Female",
                "Active",
                "2021-07-09T03:50:03.657+05:30",
                "2021-07-09T18:34:07.276+05:30");
        CreateDeletedResponse expected = CreateDeletedResponse.builder()
                .code("204")
                .meta(null)
                .data(null)
                .build();

        String accessToken = "6733700d981d5126e2a88251a169121e86b4efe412364040da6c09d39cd21dd4";

        CreateDeletedResponse res = RestAssured
                .given(rqSpec)
                .header("Authorization", "Bearer " + accessToken)
                .body(request)
                .when()
                .delete("/public-api/users/123")
                .then()
                .spec(rsSpec)
                .extract()
                .as(CreateDeletedResponse.class);

        assertThat(200, equalTo(expected));
    }
}

