package com.flightToISS;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Flight {

		private ArrayList<Supplies> numberOfSupplies;
		private ArrayList<Rocket_of_SpaceX> rocket1_Falcon9;
		private ArrayList<Rocket_of_SpaceX> rocket2_FalconHeavy;
		private  boolean hasDocked = true;
		private  File stage1 = new File("stage-1.txt");
		private  File stage2 = new File("stage-2.txt");
				
		
		public Flight() {
			
		}
		
	public ArrayList <Supplies> loadSupplies(int stage)  throws FileNotFoundException {
		
		if(stage == 1) {
			System.out.println("Starting stage 1");
			loadPerStageSupplies(stage1);
			System.out.println("Done starting  stage 1");
		} else {
			System.out.println("Starting stage 2");
			loadPerStageSupplies(stage2);
			System.out.println("Done starting  stage 2\n");
		}
		return numberOfSupplies;
	}
		
	
	public void loadPerStageSupplies(File file) throws FileNotFoundException {
		numberOfSupplies = new ArrayList<>();
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            String string = fileScanner.nextLine();
            String[] separated = string.split("=");

            Supplies item = new Supplies(separated[0], Integer.parseInt(separated[1]));
            numberOfSupplies.add(item);
        }
    }
	
	
	
	
	public ArrayList <Rocket_of_SpaceX> loadRocket1_Falcon9(List <Supplies> suppliesRocket1_Falcon9){
		System.out.println("loading Rocket1_Falcon9...");
		rocket1_Falcon9 = new ArrayList<>();
		Rocket_of_SpaceX rocket = new Rocket1_Falcon9();
		Iterator iterator = suppliesRocket1_Falcon9.iterator();
		
		while (iterator.hasNext()) {
			Supplies supplies = (Supplies) iterator.next();
			if(rocket.canCarry(supplies)) {
				rocket.carry(supplies);
			} else {
				rocket1_Falcon9.add(rocket);
				rocket =   new Rocket1_Falcon9();
				System.out.println("New Rocket1_Falcon9 is created");
				rocket.carry(supplies);	
			}
			if(!iterator.hasNext()) {
				rocket1_Falcon9.add(rocket);
			}
		}
		return rocket1_Falcon9;
	}
	
	public ArrayList <Rocket_of_SpaceX> loadRocket2_FalconHeavy(List <Supplies> suppliesRocket2_FalconHeavy){
		System.out.println("loading Rocket2_FalconHeavy ...");
		rocket2_FalconHeavy = new ArrayList<>();
		Rocket_of_SpaceX rocket = new Rocket2_FalconHeavy();
		Iterator iterator = suppliesRocket2_FalconHeavy.iterator();
		
		while (iterator.hasNext()) {
			Supplies supplies = (Supplies) iterator.next();
			if(rocket.canCarry(supplies)) {
				rocket.carry(supplies);
			} else {
				rocket2_FalconHeavy.add(rocket);
				rocket =   new Rocket2_FalconHeavy();
				System.out.println("New Rocket2_FalconHeavy is created");
				rocket.carry(supplies);	
			}
			if(!iterator.hasNext()) {
				rocket2_FalconHeavy.add(rocket);
			}
		}
		return rocket2_FalconHeavy;
	}
	
	public  void flyingOfRocket(ArrayList<Rocket_of_SpaceX> rockets, int i)	{
		
		for(Rocket_of_SpaceX rocket : rockets) {
			
			while(!rocket.launch()) {
				launchOfRocket(i);
			}
			
			while(!rocket.docking()) {
				while (!rocket.launch()) {
					launchOfRocket(i);
				}
				dockingOfRocket(i);
			}
		}
	}
	
	
	public  void launchOfRocket (int i) {
		
		if(i == 1) {
			int counter1 = Rocket1_Falcon9.getRocket1Falcon9_Counter();
			counter1++;
			Rocket1_Falcon9.setRocket1Falcon9_Counter(counter1);
		
	} else {
			int counter1 = Rocket2_FalconHeavy.getRocket2FalconHeavy_Counter();
			counter1++;
			Rocket2_FalconHeavy.setRocket2FalconHeavy_Counter(counter1);
			
	}
	}
	
	
	public void dockingOfRocket(int  i) {
		
		if(i == 1) {
			int counter = Rocket1_Falcon9.getRocket1Falcon9_Counter();
			counter++;
			Rocket1_Falcon9.setRocket1Falcon9_Counter(counter);
		
	} else {
			int counter = Rocket2_FalconHeavy.getRocket2FalconHeavy_Counter();
			counter++;
			Rocket2_FalconHeavy.setRocket2FalconHeavy_Counter(counter);
	}
		hasDocked = false;
		
	}
}
