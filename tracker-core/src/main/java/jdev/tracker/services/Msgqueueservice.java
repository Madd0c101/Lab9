package jdev.tracker.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import jdev.domain.Jform;

/**
 * Created by user on 04.02.2021.
 */
@Service
public class Msgqueueservice {
    public BlockingDeque<String> queue =  new LinkedBlockingDeque<>(100);

    @Autowired
    private Msgsendservice msgsendservice;
    @PostConstruct @Scheduled (cron= "${cron.prop2}") //60000
    private void init() throws InterruptedException,Exception,java.lang.NullPointerException {
        Jform.toJson(queue.poll(10, TimeUnit.MILLISECONDS));
        msgsendservice.send();
    }
}
