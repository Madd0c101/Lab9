package jdev.tracker.main;
//import jdev.tracker.controllers.TrackController;
import jdev.domain.ReqCreate;
import jdev.tracker.controllers.InjectionContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan({"jdev.tracker","jdev.tracker.services","jdev.server"})
public class Application {

    public static void main(String[] args) {
     //   SpringApplication.run(Application.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(InjectionContext.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        ReqCreate.create();
        return builder.build();
    }
}
