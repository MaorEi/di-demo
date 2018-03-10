package guru.springframework.didemo.controllers;

import guru.springframework.didemo.services.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetterInjectedControllerTest {
    private GetterInjectedController getterInjectedController;

    @Before
    public void setUp() throws Exception{
        this.getterInjectedController = new GetterInjectedController();
        //If we don't give a greetinhServiceImplementation, in other words, unsatisfied dependency, we will get NP exception.
        this.getterInjectedController.setGreetingService(new GreetingServiceImpl());
    }

    @Test
    public void sayHello() throws Exception {
        assertEquals(GreetingServiceImpl.HELLO_GURUS, getterInjectedController.sayHello());
    }
}