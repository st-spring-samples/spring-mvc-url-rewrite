package com.sudhirt.samples.urlrewrite;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringMvcUrlRewriteApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void invokeV1Actual() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/uri1")).andExpect(status().isOk());
	}

	@Test
	void invokeV2Actual() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v2/uri1")).andExpect(status().isOk());
	}

	@Test
	void invokeV2Derived() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v2/uri2")).andExpect(status().isOk());
	}

}
