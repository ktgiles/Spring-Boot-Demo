package com.cgi.assessment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.assessment.exceptions.NoPlayerWithId;
import com.cgi.assessment.exceptions.PlayerWithIdPresent;
import com.cgi.assessment.model.Player;
import com.cgi.assessment.repo.PlayerRepo;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	private PlayerRepo playerRepo;

	public List<Player> getAllPlayers() {
		return playerRepo.findAll();
	}

	public Player addNewPlayer(Player player) throws PlayerWithIdPresent {
		Optional <Player> optPlayer = playerRepo.findById(player.getId());
		
		if (optPlayer.isEmpty()) {
			playerRepo.save(player);
			return player;
		}
		
		else {
			throw new PlayerWithIdPresent();
		}
	}

	public Player getPlayerById(int id) throws NoPlayerWithId {
		Optional <Player> optPlayer = playerRepo.findById(id);
		
		if (optPlayer.isPresent()) {
			return optPlayer.get();
		}
		else {
			throw new NoPlayerWithId();
		}
	}

}
