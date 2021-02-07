package jdev.tracker.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 04.02.2021.
 */
@Service
public class Msgqueueservice {
    public BlockingDeque<String> queue =  new LinkedBlockingDeque<>(100);

    @Autowired
    private Msgsendservice msgsendservice;

    @PostConstruct @Scheduled (cron= "${cron.prop2}") //60000
    private void init() throws InterruptedException,Exception {
        Jform.toJson(queue.poll(500, TimeUnit.MILLISECONDS));
       // msgsendservice.sendmsg=queue.take();
        msgsendservice.send();
    }
}
