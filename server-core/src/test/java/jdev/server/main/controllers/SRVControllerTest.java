package jdev.server.main.controllers;

import jdev.domain.Response;
import jdev.server.services.getcoord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SRVControllerTest {

    @Mock
    Model model;

    @Mock
    getcoord mes ;

    @InjectMocks
    SRVController controller;


    @Test
    public void push() throws Exception {
        String result = controller.solve("name",model);
        assertEquals("solving",result);
    }


}