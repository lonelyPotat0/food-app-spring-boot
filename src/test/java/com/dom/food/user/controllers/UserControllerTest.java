package com.dom.food.user.controllers;

import org.apache.http.client.methods.RequestBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.dom.food.user.models.ERole;
import com.dom.food.user.models.UserModel;

@WebMvcTest(UserController.class)
class UserControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserController userController;

	ERole role;

	@Test
	void testCreateUser() throws Exception {

		UserModel userModel = new UserModel();
		userModel.setFullname("dom").setPhone("012098765").setPassword("123456").setRole(role.ROLE_CUSTOMER)
				.setEmail("yimoudom@hotmail.com").setAddress("phnom penh");
	}

	@Test
	void testGetUserInformation() throws Exception {
		UserModel user = new UserModel();
		user.setUserId(1);
		// given(userController.getUserInformation(user.getUserId().toString())).willReturn(user);
	}

	@Test
	void testUpdateUser() {
	}

	@Test
	void testDeleteUser() {
	}

}
