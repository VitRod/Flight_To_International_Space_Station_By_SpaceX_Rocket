package com.flightToISS;

import java.util.Random;

public class Rocket2_FalconHeavy extends Rocket_of_SpaceX{
	private static int  rocket2FalconHeavy_Counter;
	private final int maxCargo = 12000;
	private static  final  int  cost = 130000000;
	private final int weight = 19000;
	private double chanceOfLaunching;
	private double chanceOfSpaceCraftDocking;
	
	public Rocket2_FalconHeavy() {
		this(0);
	}

	public Rocket2_FalconHeavy(int lastWeight) {
		setMaxCargo(maxCargo);
		setCost(cost);
		setWeight(weight);
		setCurrentWeight(lastWeight);
		
		rocket2FalconHeavy_Counter++;
		System.out.println("===================================================");
		
	}

	public static int getRocket2FalconHeavy_Counter() {
		return rocket2FalconHeavy_Counter;
	}

	public static void setRocket2FalconHeavy_Counter(int rocket2FalconHeavy_Counter) {
		Rocket2_FalconHeavy.rocket2FalconHeavy_Counter = rocket2FalconHeavy_Counter;
	}
	
	@Override
	public boolean launch() {
		System.out.println("\nLAUNCHING...!!!"); 
		Random randomNumber = new Random();
		double rand = randomNumber.nextDouble();
		chanceOfLaunching = 0.04 * getTotalWeight() / getMaxCargo();
		
		System.out.println("Cargo: " + getCurrentWeight());
		if(chanceOfLaunching >= rand) {
			System.out.println("Rocket2_FalconHeavy EXPLOADED...!!!");
			System.out.println(" ... Sending another  rocket because previous exploaded!!!");
			return false;
		} else {
			System.out.println("Rocket2_FalconHeavy launched successfully!!! ");
			return true;
		}	
	}
	
	@Override
	public boolean docking() {
		 System.out.println(" \nDOCKING...!!! ");
		 Random randomNumber = new Random();
		 double rand = randomNumber.nextDouble();
		 chanceOfSpaceCraftDocking = 0.08 * getTotalWeight() / getMaxCargo();
		 
		 if( chanceOfSpaceCraftDocking >= rand) {
			 System.out.println("Rocket2_FalconHeavy  fell and  burned in the atmosphere...!!!");
			 System.out.println(" ... Sending another  rocket because previous burned and crashed!!!");
			 return false;
		 } else {
			 System.out.println("Rocket2_FalconHeavy docked successfully!!! ");
			 return true;
		 }	 
	}
	
	public  static long getTotalCost() {
		return getRocket2FalconHeavy_Counter() * cost;
	}
	
	
}
