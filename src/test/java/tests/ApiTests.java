package tests;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static ApiFramework.ResponseValidator.validateSuccessfulResponseSchema;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.lessThan;
import static ApiFramework.ApiProperties.API_PROPERTIES;

public class ApiTests {

    private static final Long RESPONSE_TIMEOUT = 10L;
    private static final String LOCATION_JSON_PATH = "schemas/parisRueJeanMace.json";
    private static ResponseSpecification responseSpecification;

    @BeforeClass
    public static void setup() {
        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(SC_OK)
                .expectResponseTime(lessThan(RESPONSE_TIMEOUT), TimeUnit.SECONDS)
                .build();
    }

    @Test
    public void shouldVerifyApiIsAlive() {
        given()
                .when().get(API_PROPERTIES.baseUrl())
                .then().spec(responseSpecification);
    }

    @Test
    public void shouldReturnParisLocationJson() {
          given()
                  .when()
                  .get(API_PROPERTIES.baseUrl() + API_PROPERTIES.parisLocation())
                  .then()
                  .spec(validateSuccessfulResponseSchema(LOCATION_JSON_PATH));
    }
}