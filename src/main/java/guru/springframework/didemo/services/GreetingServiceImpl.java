package guru.springframework.didemo.services;

import org.springframework.stereotype.Service;
//Marking class as a service is also picked up a Spring component
//That tells the Spring Framework to manage it as a Spring bean.
//Without the annotation the application will fail to start because spring couldn't find a bean of that type
@Service
public class GreetingServiceImpl implements GreetingService {

    public static final String HELLO_GURUS = "Hello Gurus!!";

    @Override
    public String sayGreeting() {
        return HELLO_GURUS;
    }
}
