package com.api.base;

import static io.restassured.RestAssured.given;

import com.api.filters.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	/*
	 * Wrapper for RestAssure // responsible to handle baseURI, Creating the
	 * request, Handling the response
	 */

	private static final String BASEURL = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;

	static {
		RestAssured.filters(new LoggingFilter());
	}

	public BaseService() {
		requestSpecification = given().baseUri(BASEURL);
	}

	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization", "Bearer " + token);
	}

	protected Response postRequest(Object payLoad, String endPoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payLoad).post(endPoint);

	}

	protected Response getRequest(String endPoint) {
		return requestSpecification.get(endPoint);
	}

	protected Response putRequest(Object payLoad, String endPoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payLoad).put(endPoint);

	}
}
