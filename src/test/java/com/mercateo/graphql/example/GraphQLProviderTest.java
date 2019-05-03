package com.mercateo.graphql.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;

public class GraphQLProviderTest {

    private GraphQLProvider uut;

    private final GraphQLBookDataFetchers bookFetcher = new GraphQLBookDataFetchers();

    @Before
    public void init() {
        initMocks(this);
        uut = new GraphQLProvider(bookFetcher);
    }

    @Test
    public void test_schema_valid() throws Exception {

        // given

        // when
        uut.init();

        // then
        assertThat(uut.graphQL()).isNotNull();

    }

}
