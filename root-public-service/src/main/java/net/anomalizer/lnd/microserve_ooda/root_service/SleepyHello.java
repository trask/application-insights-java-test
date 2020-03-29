package net.anomalizer.lnd.microserve_ooda.root_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class SleepyHello {
    @GetMapping(value = "/sleepy-hello")
    public Callable<String> echoHelloWorld() {
        return () -> {
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000));

            return "Hello World !!";
        };
    }

    @GetMapping(value = "/remote-cibil")
    public Flux<Integer> remoteCibil() {
        return WebClient.create()
                .get()
                .uri("http://localhost:8083/cibil")
                .retrieve()
                .bodyToFlux(Integer.class);
    }
}
