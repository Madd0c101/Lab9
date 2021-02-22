package jdev.tracker.main;

import jdev.domain.ReqCreate;
import jdev.domain.Response;
import jdev.server.main.controllers.CounterController_SRV;
import jdev.tracker.controllers.InjectionContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import jdev.domain.ReqCreate;

import static jdev.tracker.services.Msgsendservice.request;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@TestConfiguration
public class ApplicationTest {

    @Test
    public void main() {

        Application.main(new String[] {});
        ApplicationContext context = new AnnotationConfigApplicationContext(InjectionContext.class);

    }

    @Mock
    RestTemplate restTemplate;

    @Mock
    RestTemplateBuilder builder;

    @Test
    public void RestTemplate() throws Exception {
        ReqCreate.create();
        RestTemplate result =builder.build();
    }


}