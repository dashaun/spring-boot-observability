package io.springone.beginnerfriendly.demoservice;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
@Timed
public class DemoRestController {

    //Micrometer Registry to store all of my custom metrics
    private final MeterRegistry meterRegistry;

    //Constructor that requires a MeterRegistry - From dependencies
    public DemoRestController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    //The simple first step
    @GetMapping("/")
    public String hello() {
        return "Hello World\n";
    }

    //The method that does really important stuff
    @GetMapping("/update")
    public String callAnotherService() {

        //Generate a random number
        Random random = new Random();
        int rvalue = random.nextInt(1000);

        //Put that number into a custom metric
        Gauge.builder("bootifulWavefront.randomValue",
                rvalue,
                Integer::intValue)
                .description("Latest Random Value Generated")
                .register(meterRegistry);

        //Call out to another service to use this new number
        String update = String.format("%d", rvalue);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject("http://localhost:8079/update", update, String.class);

        return rvalue + "\n";
    }
}
