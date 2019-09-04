package com.flightToISS;

public class Supplies {
	private String  name;
	private int weight;
	
	public Supplies (String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public  String getName(){
		return name;
	}
	public  int getWeight() {
		return weight;
	}
}
