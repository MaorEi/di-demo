package guru.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
//Marking bean as @Primary annotation it tells Spring if there is more then one bean and no such dependency specified,
//choose the primary annotated.
//If we got more then one profile, giving the "default" parameter making it as default -
// when no other profile is activated in application.properties.
@Profile({"en", "default"})

//@Profile("en") is not enough all the beans has a profile associated with them, and if we don't have an active one,
// those beans aren't eligible anymore, so we must mark one of them as a default that he'll be eligible when brought into the Spring context.
//so the error coming because there is no primary and not using a qualifier, Spring is falling back to trying to autowire by type...

public class PrimaryGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello - Primary Greeting service";
    }
}
