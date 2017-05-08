package ca.dann.hangman.domain;

/**
 * 
 * @author Dann - Dangelo Santana
 * @professor Lounis Zaidi
 * @subject OPJE - v11-Project2005-0902
 *
 */
public class HangUser {

	private String userName;
	private int hmScore;
	private String userPassword;
	private int lastScore;
	private int highestScore;
	private int sumScore;
	private int victories;
	private int defeats;
	
	public HangUser() {
		System.out.println("[new HangUser]");
		this.userName = "AAAA";
		this.userPassword = "1234";
		this.lastScore = 0;
		this.highestScore = 0;
		this.sumScore = 0;
		this.victories = 0;
		this.defeats = 0;
		this.hmScore = 0;
	}
	
	public HangUser(String name) {
		this.userName = name;
		this.hmScore = 0;
		this.userPassword = "1234";
		this.lastScore = 0;
		this.highestScore = 0;
		this.sumScore = 0;
		this.victories = 0;
		this.defeats = 0;
	}
	public HangUser(String name, int score) {
		this.userName = name;
		hmScore = score;
		this.userPassword = "1234";
		this.lastScore = 0;
		this.highestScore = 0;
		this.sumScore = 0;
		this.victories = 0;
		this.defeats = 0;
	}
	public HangUser(String name, String pass) {
		this.userName = name;
		this.hmScore = 0 ;
		this.userPassword = pass;
		this.lastScore = 0;
		this.highestScore = 0;
		this.sumScore = 0;
		this.victories = 0;
		this.defeats = 0;
	}


	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String name) {
		this.userName = name;
	}

	public int getScore() {
		return hmScore;
	}

	public void setScore(int score) {
		hmScore = score;
	}


	public int getHmScore() {
		return hmScore;
	}


	public void setHmScore(int hmScore) {
		this.hmScore = hmScore;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPass) {
		this.userPassword = userPass;
	}


	public int getLastScore() {
		return lastScore;
	}


	public void setLastScore(int lastScore) {
		this.lastScore = lastScore;
	}


	public int getHighestScore() {
		return highestScore;
	}


	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}


	public int getSumScore() {
		return sumScore;
	}


	public void setSumScore(int sumScore) {
		this.sumScore = sumScore;
	}


	public int getVictories() {
		return victories;
	}


	public void setVictories(int victories) {
		this.victories = victories;
	}


	public int getDefeats() {
		return defeats;
	}


	public void setDefeats(int defeats) {
		this.defeats = defeats;
	}
	
}
