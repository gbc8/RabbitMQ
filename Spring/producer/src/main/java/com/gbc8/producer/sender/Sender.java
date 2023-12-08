package com.gbc8.producer.sender;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableRabbit
@Component
@RequiredArgsConstructor
public class Sender {
	
	@Value("${rabbit-config.rabbit.exchange.send}")
	private String exchange;
	
	@Value("${rabbit-config.rabbit.routingKey.sender}")
	private String sendKey;
	
	@Autowired
	private final RabbitTemplate rabbitTemplate;
	
	@Autowired
    private Queue queue;
	
	public void sendMessage(String message) {
		try {
			rabbitTemplate.convertAndSend(queue.getName(), message);
			log.info("Message was sent successfully.");
		}catch(Exception err) {
			log.info("Error while trying to send a message: ", err.getMessage());
		}
	}
}
