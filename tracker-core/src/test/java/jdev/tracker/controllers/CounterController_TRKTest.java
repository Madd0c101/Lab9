package jdev.tracker.controllers;

import jdev.domain.Response;
import jdev.domain.RestRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CounterController_TRKTest {

    @Test
    public void showStatus() throws Exception {
        CounterController_TRK counterController_trk = new CounterController_TRK(new RestTemplate());
        String name = "test name";
        Response result = counterController_trk.showStatus();
    //    assertEquals("error", result.getStatus());
        assertEquals("success", result.getStatus());
        assertEquals(1, result.getCode());
    }

    @Test
    public void post() throws Exception{
        CounterController_TRK counterController_trk = new CounterController_TRK(new RestTemplate());
        String name = "test name";
        Response result = counterController_trk.post("good",restRequest);

        assertEquals("success", result.getStatus());
        assertEquals(100, result.getCode());
    }

    @Mock
    RestTemplate restTemplate;

    @Mock
    RestRequest restRequest;

    @InjectMocks
    CounterController_TRK mockedController;
}