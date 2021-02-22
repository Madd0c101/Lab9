package jdev.server.services;

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
public class getcoordTest {

@Test
    public void push() throws Exception{
    getcoord gc = new getcoord();
    String result = gc.push();
    assertEquals("\"989 Current coordinate: IP not found success\"",result);
}
}