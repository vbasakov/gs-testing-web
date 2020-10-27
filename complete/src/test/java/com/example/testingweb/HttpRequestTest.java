package com.example.testingweb;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		String response = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
		assertThat(response).contains("homeDefault");
	}

	@Test
	public void greetingShouldReturnParametrizedMessage() throws Exception {
		String param1 = "Param";
		String url = "http://localhost:" + port + "/?param="+param1;
		String response = this.restTemplate.getForObject(url, String.class);
		assertThat(response).contains("home"+param1);
	}
}
