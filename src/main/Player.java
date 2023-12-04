package main;

import java.util.List;

public class Player {
	private String name;
	private int prize;
	private int currentRound;
	private boolean lifeline_fifty_fifty;
	private boolean lifeline_ask_audience;
	private boolean lifeline_phone_a_friend;
	
	Player(String name,int prize,boolean lifeline_fifty_fifty,boolean lifeline_ask_audience,boolean lifeline_phone_a_friend){
		this.name = name;
		this.prize = prize;
		this.lifeline_fifty_fifty = lifeline_fifty_fifty;
		this.lifeline_ask_audience = lifeline_ask_audience;
		this.lifeline_phone_a_friend = lifeline_phone_a_friend;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrize() {
		System.out.println("Prize: " + prize);
		return prize;
	}
	
	public void setPrize(int prize) {
		this.prize = prize;
	}
	
	public void increasePrize(int point) {
		prize = prize + point;
	}
	
	public boolean isLifeline_fifty_fifty() {
		return lifeline_fifty_fifty;
	}
	
	public void setLifeline_fifty_fifty(boolean lifeline_fifty_fifty) {
		this.lifeline_fifty_fifty = lifeline_fifty_fifty;
	}
	
	public boolean isLifeline_ask_audience() {
		return lifeline_ask_audience;
	}
	
	public void setLifeline_ask_audience(boolean lifeline_ask_audience) {
		this.lifeline_ask_audience = lifeline_ask_audience;
	}
	
	public boolean isLifeline_phone_a_friend() {
		return lifeline_phone_a_friend;
	}
	
	public void setLifeline_phone_a_friend(boolean lifeline_phone_a_friend) {
		this.lifeline_phone_a_friend = lifeline_phone_a_friend;
	}
}
