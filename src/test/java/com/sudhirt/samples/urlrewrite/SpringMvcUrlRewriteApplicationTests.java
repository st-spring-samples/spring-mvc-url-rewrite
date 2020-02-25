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
class SpringMvcUrlRewriteApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void invoke_v1Uri1_Actual() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/uri1"))
				.andExpect(status().isOk())
				.andExpect(content().string("this is uri1"));
	}

	@Test
	void invoke_v1AnotherUri1_Actual() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/another-uri1"))
				.andExpect(status().isOk())
				.andExpect(content().string("this is uri1"));
	}

	@Test
	void invoke_v2Uri1_Actual() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v2/uri1"))
				.andExpect(status().isOk())
				.andExpect(content().string("this is uri1 v2 implementation"));
	}

	@Test
	void invoke_v2Uri2_Derived() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v2/uri2"))
				.andExpect(status().isOk())
				.andExpect(content().string("this is uri2"));
	}

	@Test
	void invoke_v1Uri2_Actual() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/uri2"))
				.andExpect(status().isOk())
				.andExpect(content().string("this is uri2"));
	}

}
