package com.gbc8.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbc8.consumer.receiver.Listener;

@RestController
public class Controller {
	
	@Autowired
	private Listener listener;
	
	@GetMapping("")
	public ResponseEntity<List<String>> getMessages(){
		return ResponseEntity.ok().body(listener.getMessages());
	}
}

	