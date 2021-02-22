package jdev.tracker.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class GPSserviceTest {

    @Test
    public void gpstest() throws Exception {
        GPSservice gps = new GPSservice();
        gps.job();
    }

}
