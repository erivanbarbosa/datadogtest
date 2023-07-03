package br.com.redesprou.datadogtest;

import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataDogConfig {

    @Bean
    public Tracer dataDogTracer() {
        return GlobalTracer.get();
    }
}
