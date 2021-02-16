package jdev.tracker.services;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdev.server.controllers.CounterController_SRV;
import jdev.tracker.controllers.CounterController_TRK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ch.qos.logback.core.recovery.ResilientFileOutputStream;
import ch.qos.logback.core.util.ContextUtil;
import ch.qos.logback.core.util.FileSize;
import ch.qos.logback.core.util.FileUtil;
import sun.util.logging.PlatformLogger;

import static jdev.tracker.services.Msgsendservice.request;

//import static jdev.domain.Jform.point;
@Service
public class ResponseTick {

    private static final Logger log = LoggerFactory.getLogger(ResponseTick.class);
    private String S;

    public void run() throws IOException, InterruptedException, java.lang.Exception {

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(request.getCoord() + " " + CounterController_TRK.showStatus().getStatus());
        log.info("POST by tracker: {}", json);
        try {
            FileWriter fw = new FileWriter("tracker-core\\src\\main\\resources\\log_file.log",true);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(json + System.getProperty("line.separator"));
            writer.flush();
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}