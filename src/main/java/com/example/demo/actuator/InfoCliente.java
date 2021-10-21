package com.example.demo.actuator;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;



@Component
public class InfoCliente implements InfoContributor {
	
	private Counter count;
	

	public InfoCliente(MeterRegistry registry) {
		super();
		this.count =  Counter.builder("invocaciones.info").description("Invocaciones Totales de Info").register(registry);
	}


	@Override
	public void contribute(Builder builder) {
		count.increment();
		builder.withDetail("contador", count.count());
	}

}