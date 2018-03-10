package guru.springframework.didemo.controllers;

import guru.springframework.didemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {
    private GreetingService greetingService;

    //We can't omit the @Autowired annotation here because of the automatic wiring of constructor based components.
    //So what Spring is seeing, it seems that constructor on a Spring component and it tries to satisfy that dependency.
    //But it's a good habit to mark constructor components as @Autowired, to specify you intend that constructor to be Autowired.
    @Autowired
    //The @Qualifier annotation gets in a String with the lowercase name of the bean we want to inject.
    //Without the annotation the Spring component ConstructorInjectedController won't know which bean he shall use.
    //In case of constructor injection, the qualifier must be inline.
    public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
