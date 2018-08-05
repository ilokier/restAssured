import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

public class ExampleTest extends RestAssuredExample {
   public String expectedTitle = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";

    @BeforeClass
    public static void setup() {
        RestAssured.basePath = "https://jsonplaceholder.typicode.com";
    }
    @Test
    public void testRequest() {
        when().get("https://jsonplaceholder.typicode.com/posts/1").then().assertThat().statusCode(200);
    }
    @Test
    public void paramTest() {
        given().param("id", "1")
                .when().get("/posts")
                .then()
                .body("title[0]", equalTo(expectedTitle));
    }

}
