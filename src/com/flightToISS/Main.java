package com.flightToISS;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		final int stage1 = 1;
		final int stage2 = 2;
		
		long rocket1_Falcon9Cost;
		long rocket2_FalconHeavyCost;
		int stage1Rockets;
		int stage2Rockets;
		
		ArrayList<Supplies> stage1Supplies;
		ArrayList<Supplies> stage2Supplies;
		
		Flight flight  = new Flight();
		
		
		
		System.out.println(" LOADING OF THE ROCKET .....................");
		stage1Supplies = flight.loadSupplies(stage1);
		stage2Supplies = flight.loadSupplies(stage2);
		
		System.out.println("STARTING THE FLIGHT FOR ROCKET 1 FALCON 9... \n");
		System.out.println("======The flight Stage1 ========The flight Stage1 ======== The flight Stage1 ========");
		flight.flyingOfRocket(flight.loadRocket1_Falcon9(stage1Supplies), 1);
		System.out.println("===== Stage1 DONE=======Stage1 DONE=======Stage1 DONE=======Stage1 DONE=======");
		stage1Rockets = Rocket1_Falcon9.getRocket1Falcon9_Counter();
		System.out.println("Rockets used for stage 1: "+ stage1Rockets);
		
		System.out.println("======The flight Stage2 ========The flight Stage2 ======== The flight Stage2 ========");
		flight.flyingOfRocket(flight.loadRocket1_Falcon9(stage2Supplies), 1);
		System.out.println("===== Stage2 DONE=======Stage2 DONE=======Stage2 DONE=======Stage2 DONE=======");
		stage2Rockets = Rocket1_Falcon9.getRocket1Falcon9_Counter() - stage1Rockets;
		System.out.println("Rockets used for stage 2: "+ stage2Rockets + "\n");
		
		System.out.println("A total of " + Rocket1_Falcon9.getRocket1Falcon9_Counter() + " rockets were used. " );
		rocket1_Falcon9Cost = totalCost(1);
		
		
		System.out.println("STARTING THE FLIGHT FOR ROCKET 2 FALCON HEAVY... \n");
		System.out.println("======The flight Stage1 ========The flight Stage1 ======== The flight Stage1 ========");
		flight.flyingOfRocket(flight.loadRocket2_FalconHeavy(stage1Supplies), 2);
		System.out.println("===== Stage1 DONE=======Stage1 DONE=======Stage1 DONE=======Stage1 DONE=======");
		stage1Rockets = Rocket2_FalconHeavy.getRocket2FalconHeavy_Counter();
		System.out.println("Rockets used for stage 1: "+ stage1Rockets);
		
		System.out.println("======The flight Stage2 ========The flight Stage2 ======== The flight Stage2 ========");
		flight.flyingOfRocket(flight.loadRocket2_FalconHeavy(stage2Supplies), 2);
		System.out.println("===== Stage2 DONE=======Stage2 DONE=======Stage2 DONE=======Stage2 DONE=======");
		stage2Rockets = Rocket2_FalconHeavy.getRocket2FalconHeavy_Counter() - stage1Rockets;
		System.out.println("Rockets used for stage 2: "+ stage2Rockets + "\n");
		
		System.out.println("A total of " + Rocket2_FalconHeavy.getRocket2FalconHeavy_Counter() + " rockets were used. " + "\n" );
		rocket2_FalconHeavyCost = totalCost(2);
		
		if(rocket1_Falcon9Cost > rocket2_FalconHeavyCost) {
			System.out.println("Using  Falcon Heavy rockets is cheaper in this flight");
		} else {
			System.out.println("Using  Falcon 9 rockets is cheaper in this flight");
		}
	}
	
	public static long totalCost(int i) {
		return (i == 1) ? Rocket1_Falcon9.getTotalCost() : Rocket2_FalconHeavy.getTotalCost();
	}

}
