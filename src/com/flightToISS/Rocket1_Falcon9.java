package com.flightToISS;

import java.util.Random;

public class Rocket1_Falcon9 extends Rocket_of_SpaceX {

	private static int  rocket1Falcon9_Counter;
	private final int maxCargo = 9000;
	private static  final  int  cost = 200000000;
	private final int weight = 20000;
	private double chanceOfLaunching;
	private double chanceOfSpaceCraftDocking;
	
	public Rocket1_Falcon9() {
		this(0);
	}

	public Rocket1_Falcon9(int lastWeight) {
		setMaxCargo(maxCargo);
		setCost(cost);
		setWeight(weight);
		setCurrentWeight(lastWeight);
		
		rocket1Falcon9_Counter++;
		System.out.println("===================================================");
		
	}

	public static int getRocket1Falcon9_Counter() {
		return rocket1Falcon9_Counter;
	}

	public static void setRocket1Falcon9_Counter(int rocket1Falcon9_Counter) {
		Rocket1_Falcon9.rocket1Falcon9_Counter = rocket1Falcon9_Counter;
	}
	
	

	@Override
	public boolean launch() {
		System.out.println("\nLAUNCHING...!!!"); 
		Random randomNumber = new Random();
		double rand = randomNumber.nextDouble();
		chanceOfLaunching = 0.05 * getTotalWeight() / getMaxCargo();
		
		System.out.println("Cargo: " + getCurrentWeight());
		if(chanceOfLaunching >= rand) {
			System.out.println("Rocket1_Falcon9 EXPLOADED...!!!");
			System.out.println(" ... Sending another  rocket because previous exploaded!!!");
			return false;
		} else {
			System.out.println("Rocket1_Falcon9 launched successfully!!! ");
			return true;
		}
		
		
	}

	@Override
	public boolean docking() {
		 System.out.println(" \nDOCKING...!!! ");
		 Random randomNumber = new Random();
		 double rand = randomNumber.nextDouble();
		 chanceOfSpaceCraftDocking = 0.01 * getTotalWeight() / getMaxCargo();
		 
		 if( chanceOfSpaceCraftDocking >= rand) {
			 System.out.println("Rocket1_Falcon9  fell and  burned in the atmosphere...!!!");
			 System.out.println(" ... Sending another  rocket because previous burned and crashed!!!");
			 return false;
		 } else {
			 System.out.println("Rocket1_Falcon9 docked successfully!!! ");
			 return true;
		 }
		
		 
		 
	}
	
	public  static long getTotalCost() {
		return getRocket1Falcon9_Counter() * cost;
	}
	
}
