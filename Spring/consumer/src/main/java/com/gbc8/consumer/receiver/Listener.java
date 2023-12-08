package com.gbc8.consumer.receiver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Listener {
	
	private List<String> msg = new ArrayList<>();

    @RabbitListener(queues = "${rabbit-config.rabbit.queue.sender}")
    public void recieveMessage(String message) throws JsonProcessingException {
        log.info("Recieving message with data: " + message);
        msg.add(message);
    }
	
	public List<String> getMessages(){
		return msg;
	}
}
