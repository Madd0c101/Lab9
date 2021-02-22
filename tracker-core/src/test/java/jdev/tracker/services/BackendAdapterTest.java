package jdev.tracker.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class BackendAdapterTest {

    @Mock
    RestTemplate restTemplate;

    @Mock
    RestTemplateBuilder builder;

    @Test
    public void getreqtest() throws Exception {
        BackendAdapter adapter=new BackendAdapter(builder);
        String result = adapter.getRequests();
        String REQUESTS_ENDPOINT = "/requests";
        String backendUrl="127.0.0.1:8080";
        assertEquals("", result);
    }
}