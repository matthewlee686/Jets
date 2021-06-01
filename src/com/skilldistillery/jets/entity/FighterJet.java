package com.skilldistillery.jets.entity;

public class FighterJet extends Jet implements FlyBy {

	public FighterJet() {
		super();
	}

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public void look_cool() {
		System.out.println("             Procedures             ");
		System.out.println("------------------------------------");
		System.out.println("1.) Fly by the Air Control Tower without permission from the Chief");
		System.out.println("2.) Nothing else!");
	}

}
