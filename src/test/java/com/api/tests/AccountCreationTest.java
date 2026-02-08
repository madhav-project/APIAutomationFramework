package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

	@Test(description = "Verify Create Account API is working...")
	public void createAccountTest() {

		SignUpRequest signUpRequest = new SignUpRequest.Builder()
		.firstName("madhav")
		.lastName("pathak")
		.email("hierisd523@gmail.com")
		.username("madhavpathak123")
		.password("Pass@1234")
		.mobileNumber("3365478965")
		.build();

		AuthService authService = new AuthService();
		Response response = authService.signUp(signUpRequest);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		Assert.assertEquals(response.statusCode(), 200);

	}

}
