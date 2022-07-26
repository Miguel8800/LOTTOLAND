package com.rockpaperscissor.game.service;

import org.springframework.stereotype.Service;

import com.rockpaperscissor.game.model.Game;

// The service class
@Service
public class GameService {
	
	private Game game;
	
	// init new game and find the winner
	public Game playGame() {
		this.game = new Game();
		this.game.play();
		return game;
	}
	
	// return the game options
	public Game getGameOptions() {
		return this.game;
	}

}
