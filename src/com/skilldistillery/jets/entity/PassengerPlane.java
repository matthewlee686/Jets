package com.skilldistillery.jets.entity;


public class PassengerPlane extends Jet implements PassengerAirline {

	public PassengerPlane() {
		super();
	}

	public PassengerPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	
	public void go_over_safety_procedures_to_passengers() {
		System.out.println("             Procedures             ");
		System.out.println("------------------------------------");
		System.out.println("1.) Put your SEATBELTS ON");
		System.out.println("2.) Pilots will exit the Plane before the Passengers");
		System.out.println("3.) In case of a crash landing, don't panic!!!");
	}

}//Class
