package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;
@Listeners(com.api.listeners.MyTestListener.class)
public class LoginAPITest2 {

	@Test(description = "Verify if login API is working")
	public void loginTest() {

		LoginRequest loginRequest = new LoginRequest("Admin123", "Admin123");

		AuthService authService = new AuthService();

		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);

		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse.getUsername());

		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getEmail(), "maddyp238@gmail.com");
		Assert.assertEquals(loginResponse.getUsername(), "Admin123");

	}

}
