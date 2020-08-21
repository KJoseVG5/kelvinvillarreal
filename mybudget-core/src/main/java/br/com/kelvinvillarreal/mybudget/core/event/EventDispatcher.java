package br.com.kelvinvillarreal.mybudget.core.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EventDispatcher {

	private RabbitTemplate rabbitTemplate;

	private String categoryExchange;
	private String categoryCreatedRoutingKey;

	@Autowired
	EventDispatcher(final RabbitTemplate rabbitTemplate, @Value("${category.exchange}") final String categoryExchange,
			@Value("${category.created.key}") final String categoryCreatedRoutingKey) {

		this.rabbitTemplate = rabbitTemplate;
		this.categoryExchange = categoryExchange;
		this.categoryCreatedRoutingKey = categoryCreatedRoutingKey;
	}

	public void send(final CategoryCreatedEvent categoryCreatedEvent) {
		rabbitTemplate.convertAndSend(categoryExchange, categoryCreatedRoutingKey, categoryCreatedEvent);
	}

}
