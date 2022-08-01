package com.cgi.assessment.service;

import java.util.List;

import com.cgi.assessment.exceptions.NoPlayerWithId;
import com.cgi.assessment.exceptions.PlayerWithIdPresent;
import com.cgi.assessment.model.Player;

public interface PlayerService {

	List<Player> getAllPlayers();
	Player addNewPlayer(Player player) throws PlayerWithIdPresent;
	Player getPlayerById(int id) throws NoPlayerWithId;
	
}
