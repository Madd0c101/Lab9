package jdev.tracker.controllers;

import jdev.tracker.services.GPSservice;
import jdev.tracker.services.Msgqueueservice;
import jdev.tracker.services.Msgsendservice;
import jdev.tracker.services.ResponseTick;
import org.junit.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@TestConfiguration
public class InjectionContextTest {

    @Test
    public void gpstest() throws Exception {
        GPSservice gpservice = new GPSservice();
    }

    @Test
    public void queuetest() throws Exception {
        Msgqueueservice queue = new Msgqueueservice();
    }

    @Test
    public void sendtest() throws Exception {
        Msgsendservice send = new Msgsendservice();
    }

    @Test
    public void resptest() throws Exception {
        ResponseTick resp = new ResponseTick();
    }

    @Test
    public void schedtest() throws Exception {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
    }

}