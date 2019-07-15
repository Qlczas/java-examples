package ApiFramework;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_OK;

public class ResponseValidator {
    public static ResponseSpecification validateSuccessfulResponseSchema(String path) {
        return new ResponseSpecBuilder()
                .expectStatusCode(SC_OK)
                .expectBody(matchesJsonSchemaInClasspath(path))
                .build();
    }
}