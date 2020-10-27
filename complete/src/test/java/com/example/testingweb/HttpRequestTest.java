package com.example.testingweb;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void greetingShouldReturnDefaultMessage() {
		String BASE_URL = "http://localhost:" + port + "/";
		String response = this.restTemplate.getForObject(BASE_URL, String.class);
				assertThat(response).contains("homeDefault");
	}

	@Test
	public void greetingShouldReturnParametrizedMessage() {
		String BASE_URL = "http://localhost:" + port + "/";
		String param = "Param";
		String url = BASE_URL +"?param=" + param;
		String response = this.restTemplate.getForObject(url, String.class);
		assertThat(response).contains("home" + param);
	}

	@Test
	public void proxyShouldReturnDefaultMessage() {
		String BASE_URL = "http://localhost:" + port + "/";
		String url = BASE_URL + "proxy";
		String response = this.restTemplate.getForObject(url, String.class);
		assertThat(response).contains("proxyDefault");
	}

	@Test
	public void proxyShouldReturnParametrizedMessage() {
		String BASE_URL = "http://localhost:" + port + "/";
		String param = "Param";
		String url = BASE_URL + "proxy?param=" + param;
		String response = this.restTemplate.getForObject(url, String.class);
		assertThat(response).contains("proxy" + param);
	}
}
