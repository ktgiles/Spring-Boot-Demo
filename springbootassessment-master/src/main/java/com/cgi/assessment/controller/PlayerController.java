package com.cgi.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.assessment.exceptions.NoPlayerWithId;
import com.cgi.assessment.exceptions.PlayerWithIdPresent;
import com.cgi.assessment.model.Player;
import com.cgi.assessment.service.PlayerService;

@RestController
@RequestMapping(value = "/api/v1")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;

	@GetMapping(value = "/players")
	public ResponseEntity<List<Player>> getPlayerHandler() {

		ResponseEntity<List<Player>> response;
		List<Player> players = playerService.getAllPlayers();
		response = new ResponseEntity<List<Player>>(players,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/players")
	public ResponseEntity<?> addPlayerHandler(@RequestBody Player player){
		ResponseEntity<?> response;
		try {
		Player newPlayer = playerService.addNewPlayer(player);
		response = new ResponseEntity<Player>(newPlayer, HttpStatus.CREATED);
		} catch (PlayerWithIdPresent e) {
			response = new ResponseEntity<String>("Failed to add player - duplicate", HttpStatus.CONFLICT);
		}
		return response;
	}
	
	@GetMapping("/players/{playerId}")
	public ResponseEntity<?> getPlayerByIdHandler(@PathVariable("playerId") int id){
		ResponseEntity<?> response;
		
		try {
			Player player = playerService.getPlayerById(id);
			response = new ResponseEntity<Player>(player, HttpStatus.OK);
		} catch (NoPlayerWithId e) {
			response = new ResponseEntity<String>("Failed to retrieve player - not found", HttpStatus.NOT_FOUND);	
		}
		return response;
	}
}
