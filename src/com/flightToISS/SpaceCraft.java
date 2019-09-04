package com.flightToISS;

public interface SpaceCraft {
	 boolean launch();
	 
	 boolean docking();
	 
	 boolean canCarry(Supplies supplies);
	 
	 void carry (Supplies supplies);
}
