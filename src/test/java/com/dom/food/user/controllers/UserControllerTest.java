package com.dom.food.user.controllers;

import com.dom.food.user.mapper.UserMapper;
import com.dom.food.user.models.ERole;
import com.dom.food.user.models.UserModel;
import com.dom.food.user.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

//import io.restassured.RestAssured;
//import static io.restassured.RestAssured.when;
//import static io.restassured.RestAssured.given;


//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.;


import org.slf4j.Logger;

// @RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = UserController.class)
@WebAppConfiguration
@WebMvcTest
class UserControllerTest {

	@MockBean
	UserService userService;

	@MockBean
	UserMapper userMapper;

	@Mock
	Logger logger;

	@Autowired
	private MockMvc mockMvc;
	
	ERole role;


	private static ObjectMapper mapper = new ObjectMapper();

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}



	
	@Test
	void testCreateUser() throws Exception {

		UserModel userModel = new UserModel();
		userModel.setFullname("dom").setPhone("012098765").setPassword("123456").setRole(role.ROLE_CUSTOMER)
				.setEmail("yimoudom@hotmail.com").setAddress("phnom penh");
		Mockito.when(logger.isInfoEnabled()).thenReturn(false);
		
		String json = mapper.writeValueAsString(userModel);	
		MvcResult requestResult = mockMvc.perform(post("/user/create").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andReturn();	
		String result = requestResult.getResponse().getContentAsString();
		Assert.notNull(result);
	}

		
	@Test
	void testGetUserInformation() throws Exception {
		UserModel userModel = new UserModel();
		when(userMapper.getUser(1)).thenReturn(userModel);
		assertEquals(1, userModel.getUserId());
		
	}

	@Test
	void testUpdateUser() {
		
	}

	@Test
	void testDeleteUser() {
	}

}
