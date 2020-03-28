package net.anomalizer.lnd.microserve_ooda.bar_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
public class BarMethods {
    @GetMapping(value = "/random-cibil")
    public Integer cibil()
    {
        return ThreadLocalRandom.current().nextInt(300, 851);
    }
}
