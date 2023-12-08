package com.gbc8.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gbc8.producer.sender.Sender;

@RestController
public class Controller {
	
	@Autowired
	public Sender sender;
	
	@GetMapping("")
	public ResponseEntity<String> teste(){
		return ResponseEntity.ok().body("Testando");
	}
	
	@PostMapping("")
	public ResponseEntity<Void> sendMessage(@RequestBody String message){
		sender.sendMessage(message);
		return ResponseEntity.noContent().build();
	}
}
