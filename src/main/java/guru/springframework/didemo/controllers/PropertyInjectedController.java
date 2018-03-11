package guru.springframework.didemo.controllers;

import guru.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


//THIS IS A TEST WHICH WE SHOULDN'T DO PROPERTY DI!!!

//The @Controller annotation mark the class as a Spring component.
//That tells the Spring Framework to manage it as a Spring bean.
@Controller
public class PropertyInjectedController {
    //The autowired annotation tells Spring where to inject the service.
    public String sayHello() {
        return greetingServiceImpl.sayGreeting();
    }

    @Autowired
    @Qualifier("greetingServiceImpl")
    public GreetingService greetingServiceImpl;
    //if the name of the property is the Bean name ("greetingServiceImpl"), so that Spring gonna use reflection and match them up
    //That's a shortcut not to use the Qualifier above
    //But it's a bad habit to depend on property names on dependency injections -
    //As with @Primary annotated bean overriding reflection!!!

}
