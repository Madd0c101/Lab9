package jdev.tracker;

import jdev.tracker.services.GPSservice;
import jdev.tracker.services.Msgqueueservice;
import jdev.tracker.services.Msgsendservice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * Created by user on 04.02.2021.
 */

@Configuration
@PropertySource("classpath:/app.properties")
@EnableScheduling
public class InjectionContext {
    @Bean
    public GPSservice gpservice() {return new GPSservice();}

   @Bean
    public Msgqueueservice queueService() { return new Msgqueueservice();} //перед параметры

    @Bean
    public Msgsendservice sendService() {return new Msgsendservice();}

    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("poolScheduler");
        scheduler.setPoolSize(20);
        return scheduler;
    }
}
