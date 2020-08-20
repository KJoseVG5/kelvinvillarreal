package br.com.kelvinvillarreal.mybudget.budget.event;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.victorpfranca.mybudget.budget.client.CategoryRestClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EventHandler {

	private CategoryRestClient categoryRestClient;

	public EventHandler(final CategoryRestClient categoryRestClient) {
		this.categoryRestClient = categoryRestClient;
	}

	@RabbitListener(queues = "${category.queue}")
	void handleCategoryCreated(CategoryCreatedEvent event) {
		log.info("Category Created Event received: {}", event.getCategoryId());
		log.info("Invoked Core Rest Service: " + categoryRestClient.retrieve().getName());
		try {
		} catch (final Exception e) {
			log.error("Error when trying to process CategoryCreatedEvent", e);
			// Avoids the event to be re-queued and reprocessed.
			throw new AmqpRejectAndDontRequeueException(e);
		}

	}

}
