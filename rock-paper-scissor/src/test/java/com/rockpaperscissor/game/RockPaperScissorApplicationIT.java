package com.rockpaperscissor.game;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RockPaperScissorApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RockPaperScissorApplicationIT {
	
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void testPlayGame() {

		HttpEntity<String> entity = new HttpEntity<String>("ROCK", headers);

		ResponseEntity<String> response = restTemplate.exchange(
				"http://localhost:" + port +"/lottoland/v1/game",
				HttpMethod.POST, entity, String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void testNotFound() {
		HttpEntity<String> entity = new HttpEntity<String>("ROCK", headers);

		ResponseEntity<String> response = restTemplate.exchange(
				"http://localhost:" + port +"/lottoland/v1/game/kk",
				HttpMethod.POST, entity, String.class);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

}
