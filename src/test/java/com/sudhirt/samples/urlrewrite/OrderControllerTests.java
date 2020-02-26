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
class OrderControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void invoke_orders_v1() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/orders"))
				.andExpect(status().isOk())
				.andExpect(content().string("this is orders"));
	}

	@Test
	void invoke_order$_v1() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/order$"))
				.andExpect(status().isOk())
				.andExpect(content().string("this is orders"));
	}

	@Test
	void invoke_orders_v2() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v2/orders"))
				.andExpect(status().isOk())
				.andExpect(content().string("this is orders v2 implementation"));
	}

	@Test
	void invoke_order$_v2() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v2/order$"))
				.andExpect(status().isOk())
				.andExpect(content().string("this is orders v2 implementation"));
	}

	@Test
	void invoke_orders_items_v1() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/orders/1/items"))
				.andExpect(status().isOk())
				.andExpect(content().string("this is items"));
	}

	@Test
	void invoke_orders_items_v2() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/v2/orders/1/items"))
				.andExpect(status().isOk())
				.andExpect(content().string("this is items"));
	}

}
