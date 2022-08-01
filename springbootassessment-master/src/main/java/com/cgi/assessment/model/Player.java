package com.cgi.assessment.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {
	@Id
	private int id;
	private String name;
	private int matchesPlayed;
	private String country;
	
	public Player () {}
	
	
	public Player(int id, String name, int matchesPlayed, String country) {
			super();
			this.id = id;
			this.name = name;
			this.matchesPlayed = matchesPlayed;
			this.country = country;
		}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMatchesPlayed() {
		return matchesPlayed;
	}


	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "PlayerModel [id=" + id + ", name=" + name + ", matchesPlayed=" + matchesPlayed + ", country=" + country
				+ "]";
	}
	
	
}
