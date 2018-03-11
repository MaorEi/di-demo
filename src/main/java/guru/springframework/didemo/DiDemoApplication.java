package guru.springframework.didemo;

import guru.springframework.didemo.controllers.ConstructorInjectedController;
import guru.springframework.didemo.controllers.GetterInjectedController;
import guru.springframework.didemo.controllers.MyController;
import guru.springframework.didemo.controllers.PropertyInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//@SpringBootApplication annotation means that the Spring Framework gonna do component scan from this package of the class down.
@SpringBootApplication
//@ComponentScan annotation overrides the default component scan behavior of @SpringBootApplication annotation and scan from the packages we give him down.
@ComponentScan(basePackages = {"guru.services", "guru.springframework.didemo"})
public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DiDemoApplication.class, args);
        MyController myController = (MyController) applicationContext.getBean("myController");
        System.out.println(myController.hello());
        //If we don't anotate PropertyInjectedController class as a @Controller
        // we will get a NoSuchBeanDefinitionException
        System.out.println(applicationContext.getBean(PropertyInjectedController.class).sayHello());
        System.out.println(applicationContext.getBean(GetterInjectedController.class).sayHello());
        System.out.println(applicationContext.getBean(ConstructorInjectedController.class).sayHello());
    }
}
