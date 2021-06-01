package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entity.AirField;

public class JetsApplication {
	
	private AirField airField;
	{
		airField = new AirField();
	}
	
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		JetsApplication app = new JetsApplication();
		app.run();
		
	}//Main

	public void run() {
		
		airField.popAirField();
		airField.menu();
		
	}//Run Method
	
}//Class
