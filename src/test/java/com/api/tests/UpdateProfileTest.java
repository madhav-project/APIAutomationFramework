package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test(description = "Verify update profile request API is woring")
	public void updatePrifileInfoTest() {
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("Admin123", "Admin123"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());

		System.out.println("--------------------------------------------------------------------");

		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getPrifile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(), "Admin123");

		System.out.println("--------------------------------------------------------------------");

		ProfileRequest profileRequest = new ProfileRequest.Builder().firstName("Madhav").lastName("Pathak")
				.email("maddyp238@gmail.com").mobileNumber("7385415606").build();

		response = userProfileManagementService.updatePrifile(loginResponse.getToken(), profileRequest);
		System.out.println(response.asPrettyString());
	}
}
