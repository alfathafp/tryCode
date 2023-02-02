package com.company;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestAssuredRequestFilter implements Filter {
    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {
        Response response = ctx.next(requestSpec, responseSpec);
        if (response.statusCode() != 200) {
            log.info(requestSpec.getMethod() + " " + requestSpec.getURI() + " => " + response.getStatusCode() + " "
                    + response.getStatusLine());
        } else {
            log.info(requestSpec.getMethod() + " => " + requestSpec.getURI() + " \n Request Body =>"
                    + requestSpec.getBody());
            log.info("Response Status => " + response.getStatusCode() + " " + response.getStatusLine());
            log.info("Response Body => " + response.getBody().prettyPrint());
        }
        return response;
    }
}
