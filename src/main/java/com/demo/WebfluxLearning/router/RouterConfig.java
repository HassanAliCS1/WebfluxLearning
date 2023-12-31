package com.demo.WebfluxLearning.router;

import com.demo.WebfluxLearning.handler.CustomerHandler;
import com.demo.WebfluxLearning.handler.CustomerStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.logging.StreamHandler;

@Configuration
public class RouterConfig {

    @Autowired
    private CustomerHandler handler;

    @Autowired
    private CustomerStreamHandler customerStreamHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("/router/customer",handler::loadCustomer)
                .GET("/router/customer/stream", customerStreamHandler::getCustomers)
                .GET("/router/customer/{input}",handler::findCustomer)
                .POST("/router/customer/save",handler::saveCustomer)
                .build();
    }
}
