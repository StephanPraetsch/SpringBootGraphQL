package com.mercateo.graphql.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GraphQLProviderIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test_graphlq_schema() throws Exception {

        // given

        // when
        ResponseEntity<String> response = restTemplate.getForEntity("/graphql", String.class);

        // then
        System.out.println(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void test_execute_query() throws Exception {

        // given

        // when
        ResponseEntity<String> response = restTemplate.getForEntity("/graphql", String.class,
                "query:{foo}");

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

}
