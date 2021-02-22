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
public class RestRequestTest {


    @Test
    public void setCoordTest() throws Exception{
        RestRequest rr=new RestRequest();
        String s="some coord1";
        rr.setCoord(s);
        assertEquals(s,rr.getCoord());

    }

    @Test
    public void getCoordTest() throws Exception{
        RestRequest rr=new RestRequest();
        String result = rr.getCoord();
        assertEquals(null,result);
    }

}