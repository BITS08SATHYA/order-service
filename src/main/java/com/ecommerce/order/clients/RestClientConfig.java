package com.ecommerce.order.clients;


import io.micrometer.observation.ObservationRegistry;
import io.micrometer.tracing.Tracer;
import io.micrometer.tracing.propagation.Propagator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestClient;

import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.HttpRequest;
//import brave.Tracer;
//import brave.propagation.Propagation;

@Configuration
public class RestClientConfig {

    @Autowired(required = false)
    private ObservationRegistry observationRegistry;

    @Autowired(required = false)
    private Tracer tracer;
    @Autowired(required = false)
    private Propagator propagator;

    @Bean
    @LoadBalanced
    public RestClient.Builder restClientBuilder() {

        RestClient.Builder builder = RestClient.builder();

        if (observationRegistry != null) {
            builder.requestInterceptor(createTracingInterceptor());
        }

        return builder;
    }

    private ClientHttpRequestInterceptor createTracingInterceptor() {
        return (request, body, execution) -> {
            if (tracer != null && propagator != null && tracer.currentSpan() != null) {
                propagator.inject(
                        tracer.currentSpan().context(),
                        request.getHeaders(),
                        HttpHeaders::add
                );
            }
            return execution.execute(request, body);
        };
    }


}
