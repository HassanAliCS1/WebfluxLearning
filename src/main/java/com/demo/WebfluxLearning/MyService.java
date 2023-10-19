package com.demo.WebfluxLearning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MyService {
    private final WebClient webClient;
    @Autowired
    public MyService(WebClient webClient) {
        this.webClient = webClient;
    }
    public <Employee> Mono<Employee> createEmployee(Employee employee) {
        return webClient.post()
                .uri("/employees")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(employee), Employee.class)
                .retrieve()
                .bodyToMono(Employee.class);
    }
}
