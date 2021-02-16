package jdev.server.main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import jdev.domain.ReqCreate;

@SpringBootApplication
@ComponentScan({"jdev.server", "jdev.server.services","jdev.tracker","jdev.tracker.services", "jdev.domain"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
       ReqCreate.create();
        return builder.build();
    }
}
