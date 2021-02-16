package jdev.tracker.services;
import jdev.tracker.controllers.CounterController_TRK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import jdev.domain.RestRequest;
import jdev.server.controllers.CounterController_SRV;
import javax.annotation.PostConstruct;
import java.io.IOException;
import jdev.domain.Jform;
import jdev.domain.ReqCreate;

/**
 * Created by user on 04.02.2021.
 */

@Service
public class Msgsendservice {
 public static RestRequest request=new RestRequest();
//public static RestRequest request=ReqCreate.request;
    private static final Logger log = LoggerFactory.getLogger(Msgsendservice.class);
    private long previous;
    private String foo=null;
    public void send() throws InterruptedException,Exception,IOException,java.lang.NullPointerException {
        ReqCreate.create();
      request=ReqCreate.request;
      //  log.info("sending request");
        long current = System.currentTimeMillis();
     //  log.info((current - previous) + " Current coordinate: " + Jform.fromJson());
        if (Jform.fromJson()==foo)
        {
            CounterController_TRK.post("bad",request);
            request.setCoord("conection lost");
        }
        else {
            request.setCoord((current - previous) + " Current coordinate: " + Jform.fromJson());
            CounterController_TRK.post("good", request);
        }

        previous = current;
    }

    @Autowired
    private ResponseTick resp;

    @PostConstruct
    @Scheduled(cron= "${cron.prop3}") //60000
    private void init() throws InterruptedException,Exception {
        resp.run();
    }

}

