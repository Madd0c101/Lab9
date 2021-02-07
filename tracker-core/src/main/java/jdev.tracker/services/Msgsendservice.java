package jdev.tracker.services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by user on 04.02.2021.
 */
@Service
public class Msgsendservice {
    private static final Logger log = LoggerFactory.getLogger(Msgsendservice.class);
    private long previous;
    public void send() throws InterruptedException,Exception {
        log.info("sending request");
        long current = System.currentTimeMillis();
        log.info((current - previous) + " Current coordinate: " + Jform.fromJson());
        previous = current;
    }
}
