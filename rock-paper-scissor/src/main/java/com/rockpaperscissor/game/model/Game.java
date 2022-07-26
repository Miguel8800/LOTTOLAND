package com.rockpaperscissor.game.model;

public class Game {
	
	private Choice machine;
	private Choice human;
	private String winner;

	private Integer counter;
	
	public static final String WINNER = "HUMAN";
	public static final String LOSER = "MACHINE";
	
	public Game() {
		this.human = Choice.randomChoice();
		this.machine = Choice.ROCK;
		this.winner = "";
	}
	
	public Choice getPlayer() {
		return human;
	}

	public Choice getPc() {
		return machine;
	}

	public String getWinner() {
		return winner;
	}

	public int getCounter() {
		return counter;
	}
	
	private boolean whoWins(Choice a, Choice b) {
		if(a.equals(Choice.ROCK) && b.equals(Choice.SCISSOR) 
				|| (a.equals(Choice.PAPER) && b.equals(Choice.ROCK))
				|| (a.equals(Choice.SCISSOR) && b.equals(Choice.PAPER))) {
			return true;
		}
		return false;
	}
	
	public void play() {
		counter=counter++;
		if(this.human.equals(this.machine)) {
			this.winner = "NO_WINNER";
		} else if (whoWins(this.human,this.machine)) {
			this.winner = WINNER;
		} else {
			this.winner = LOSER;
		}
	}
}
