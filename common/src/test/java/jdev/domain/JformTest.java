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
public class JformTest {

    @Test
    public void ToJsnTest() throws Exception {
        Jform jform = new Jform();
        jform.toJson("abc1");
        String result = Jform.point.getAutoId();
        assertEquals("abc1", result);
    }

    @Test
    public void FromJsnTest() throws Exception {
        Jform jform = new Jform();
        Jform.point.setAutoId("abc2");
        String result = jform.fromJson();
        assertEquals("abc2", result);

    }

}