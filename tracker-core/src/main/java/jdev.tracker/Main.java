package jdev.tracker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by user on 31.01.2021.
 */
public class Main {

    public static  void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(InjectionContext.class);
    }
}
