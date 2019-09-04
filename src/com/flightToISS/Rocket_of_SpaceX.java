package com.flightToISS;

public class Rocket_of_SpaceX implements SpaceCraft {
	private int currentWeight;
	private int weight;
	private  int maxCargo;
	private  double totalWeight = currentWeight + weight;
	private int cost;
	

	@Override
	public boolean launch() {
		return true;
	}

	@Override
	public boolean docking() {
		return true;
	}

	@Override
	public boolean canCarry(Supplies supplies) {
	  if(maxCargo >= (currentWeight + supplies.getWeight())) {
		  
		  return true;
	  } else {
		  System.out.println("Can't carry supplies: " + supplies.getName() + " \tWeight: " + supplies.getWeight());
		  return false;
	  }
		
	}

	@Override
	public void carry(Supplies supplies) {
		System.out.println("Carrying supplies: "  + supplies.getName() + "\tWeight "+ supplies.getWeight());
		 currentWeight += supplies.getWeight();
	}

	public int getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(int currentWeight) {
		this.currentWeight = currentWeight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getMaxCargo() {
		return maxCargo;
	}

	public void setMaxCargo(int maxCargo) {
		this.maxCargo = maxCargo;
	}

	public double getTotalWeight() {
		totalWeight = getCurrentWeight() + getWeight();	
		return totalWeight;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	

}
