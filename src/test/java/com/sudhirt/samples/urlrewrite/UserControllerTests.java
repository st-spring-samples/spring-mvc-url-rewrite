package com.sudhirt.samples.urlrewrite;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void invoke_users_v1() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/users"))
				.andExpect(status().isOk())
				.andExpect(content().string("this is users"));
	}

	@Test
	void invoke_users_v2() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v2/users"))
				.andExpect(status().isOk())
				.andExpect(content().string("this is users v2 implementation"));
	}

	@Test
	void invoke_users_cards_v1() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/users/1/cards"))
				.andExpect(status().isOk())
				.andExpect(content().string("this is cards"));
	}

	@Test
	void invoke_users_cards_v2() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v2/users/1/cards"))
				.andExpect(status().isOk())
				.andExpect(content().string("this is cards"));
	}

}
