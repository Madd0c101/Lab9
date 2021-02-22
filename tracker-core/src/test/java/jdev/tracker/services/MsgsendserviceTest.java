package jdev.tracker.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class MsgsendserviceTest {

    @Test
    public void sendtest() throws Exception {
        Msgsendservice msgsendservice = new Msgsendservice();
msgsendservice.send();


    }

}