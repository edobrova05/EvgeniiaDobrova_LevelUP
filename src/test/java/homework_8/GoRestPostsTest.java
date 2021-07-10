package homework_8;

import Homework_8.Posts.*;
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

public class GoRestPostsTest {

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
    public void postBodyTest() {

        CreatePostRequest request = new CreatePostRequest("123", "123", "Uno", "Dos");
        CreatePostResponse expected = CreatePostResponse.builder()
                .code("201")
                .meta(null)
                .data("123")
                .build();

        String accessToken = "6733700d981d5126e2a88251a169121e86b4efe412364040da6c09d39cd21dd4";

        CreatePostResponse res = RestAssured
                //.given(rqSpec).auth().oauth2(request.getToken())
                .given(rqSpec)
                .header("Authorization", "Bearer " + accessToken)

                .body(request)
                .when()
                .post("/public-api/posts")
                .then()
                .spec(rsSpec)
                .extract()
                .as(CreatePostResponse.class);

        assertThat(res, equalTo(expected));

    }

    @Test
    public void putPostsBodyTest() {
        CreatePostRequest request = new CreatePostRequest("123", "124", "Uno", "Dos");
        CreatePostResponse expected = CreatePostResponse.builder()
                .code("201")
                .meta(null)
                .data("123")
                .build();

        String accessToken = "6733700d981d5126e2a88251a169121e86b4efe412364040da6c09d39cd21dd4";
        CreatePostResponse res = RestAssured
                .given(rqSpec)
                .header("Authorization", "Bearer " + accessToken)
                .body(request)
                .when()
                .put("/public-api/posts/123")
                .then()
                .spec(rsSpec)
                .extract()
                .as(CreatePostResponse.class);

        assertThat(res, equalTo(expected));

    }

    @Test
    public void deletePostBodyTest() {
        CreatePostRequest request = new CreatePostRequest("123", "124", "Uno", "Dos");
        CreatePostDeletedResponse expected = CreatePostDeletedResponse.builder()
                .code("204")
                .meta(null)
                .data(null)
                .build();

        String accessToken = "6733700d981d5126e2a88251a169121e86b4efe412364040da6c09d39cd21dd4";

        CreatePostDeletedResponse res = RestAssured
                .given(rqSpec)
                .header("Authorization", "Bearer " + accessToken)
                .body(request)
                .when()
                .delete("/public-api/users/123")
                .then()
                .spec(rsSpec)
                .extract()
                .as(CreatePostDeletedResponse.class);

        assertThat(200, equalTo(expected));
    }
}

