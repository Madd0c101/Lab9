package jdev.domain;

import jdev.domain.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ResponseTest {

    @Test
    public void StatusTest() throws Exception{

        String status="success";
        int code=100;
        Response resp=new Response(status,code);
        String result = resp.getStatus();
        assertEquals("success",result);
    }

    @Test
    public void CodeTest() throws Exception{

        String status="success";
        int code=100;
        Response resp=new Response(status,code);
        int result = resp.getCode();
        assertEquals(100,result);
    }
}