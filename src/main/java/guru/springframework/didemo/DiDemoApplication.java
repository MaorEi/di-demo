package guru.springframework.didemo;

import guru.springframework.didemo.controllers.ConstructorInjectedController;
import guru.springframework.didemo.controllers.GetterInjectedController;
import guru.springframework.didemo.controllers.MyController;
import guru.springframework.didemo.controllers.PropertyInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DiDemoApplication.class, args);
		MyController myController = (MyController) applicationContext.getBean("myController");
		System.out.println(myController.hello());
		System.out.println(applicationContext.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(applicationContext.getBean(GetterInjectedController.class).sayHello());
		System.out.println(applicationContext.getBean(ConstructorInjectedController.class).sayHello());
	}
}
