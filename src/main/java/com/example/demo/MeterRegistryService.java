package com.example.demo;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Component
public class MeterRegistryService {

	
    private final Counter requestRecive;
    private final Counter responseError;
    private final Counter responseOK;
    
    public MeterRegistryService(MeterRegistry registry) {
    	requestRecive = Counter
                .builder("request_recibidos")
                .description("cantidad requests recibidos")
                .register(registry);
    	
    	responseError = Counter
                .builder("response_con_error")
                .description("cantidad responses con error")
                .register(registry);
    	
    	responseOK = Counter
                .builder("response_ok")
                .description("cantidad responses ok")
                .register(registry);
    }
    
    public void requestReciveCall() {
    	requestRecive.increment();
    }
	
    public void responseErrorReciveCall() {
    	responseError.increment();
    }
    
    public void responseOkReciveCall() {
    	responseOK.increment();
    }
    
    
	
}
