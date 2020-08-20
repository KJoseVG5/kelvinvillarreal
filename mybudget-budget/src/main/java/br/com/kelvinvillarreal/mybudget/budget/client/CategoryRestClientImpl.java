package br.com.kelvinvillarreal.mybudget.budget.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CategoryRestClientImpl implements CategoryRestClient {

	private final RestTemplate restTemplate;
	private final String coreHost;

	public CategoryRestClientImpl(final RestTemplate restTemplate, @Value("${coreHost}") final String coreHost) {
		this.restTemplate = restTemplate;
		this.coreHost = coreHost;
	}

	@Override
	public CategoryDTO retrieve() {
		return restTemplate.getForObject(coreHost, CategoryDTO.class);
	}

}
