
package jdev.tracker.controllers;

import jdev.tracker.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//import org.springframework.stereotype.Controller;

//* Created by user on 04.02.2021.

@Configuration
@PropertySource("classpath:/application.properties")
@EnableScheduling
public class InjectionContext {
    @Bean
    @Primary
    public GPSservice gpservice() {return new GPSservice();}

   @Bean
   @Primary
    public Msgqueueservice queueService() { return new Msgqueueservice();} //перед параметры

    @Bean
    @Primary
    public Msgsendservice sendService() {return new Msgsendservice();}

    @Bean
    @Primary
    public ResponseTick resp() {return new ResponseTick();}

    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("poolScheduler");
        scheduler.setPoolSize(20);
        return scheduler;
    }
}
