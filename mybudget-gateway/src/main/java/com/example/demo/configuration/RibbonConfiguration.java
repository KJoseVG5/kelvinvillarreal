package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class RibbonConfiguration {

	public IPing ribbonPing() {
		return new PingUrl(false, "/actuator/health");
	}

	@Bean
	public IRule ribbonRule() {
		return new AvailabilityFilteringRule();
	}

}
