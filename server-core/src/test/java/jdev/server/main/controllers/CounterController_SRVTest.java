package jdev.server.main.controllers;

import jdev.domain.Response;
import jdev.domain.RestRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CounterController_SRVTest {
    @Test
    public void showStatus() throws Exception {
        CounterController_SRV counterController_srv = new CounterController_SRV(new RestTemplate());
        String name = "error";
        Response result = counterController_srv.showStatus();
        assertEquals(name, result.getStatus());
        assertEquals(1, result.getCode());
    }


    @Test
    public void StatusIntegration() throws Exception {
        String mes="1000 Current coordinate: track# 2 lattitude=37.376205 longtitude=-122.1826 United States Palo Alto success";
        Response result = new CounterController_SRV(new RestTemplate()).post("good",request);
        result.setMessage(mes);
        assertNotNull(result);
        assertEquals( mes,result.getMessage());
        assertEquals( "success",result.getStatus());
    }

    @Mock
    RestTemplate restTemplate;

    @Mock
    RestRequest request;

    @InjectMocks
    CounterController_SRV mockedController;

}