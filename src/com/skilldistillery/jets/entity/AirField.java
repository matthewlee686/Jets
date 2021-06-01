package com.skilldistillery.jets.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {
	
	private List<Jet> jets = new ArrayList<>();
	Scanner input = new Scanner(System.in);
	
	public AirField() {

	}

	// reads the jets.csv File and Populates Air Field
	public void popAirField () {
	
				try {
					
					String line;
					int counter = 0;
						
				
					BufferedReader file = new BufferedReader( new FileReader("jets.csv"));
						
					while ( ( line = file.readLine()  )   != null ) {
							
						//Split Line into Useable Pieces using .split() method	
						String[] arr = line.split(",");
						String model = arr[0];		
						double speed = Double.parseDouble(arr[1]);
						int range = Integer.parseInt(arr[2]);
						long price = Long.parseLong(arr[3]);
						
						Jet jet;
							
						
						//Use Data in returned array to construct a Jet Object 
							//Conditionally which class to instansiate 
							
						
						//Passenger
						if(model.contains("Passenger")) {
							jet = new PassengerPlane(model, speed, range, price);
						}
						
						//Fighter
						else if(model.contains("Fighter")) {
							jet = new FighterJet(model, speed, range, price);
						}
						
						//Generic 
						else {
							jet = new JetImpl(model, speed, range, price);
						}
							
						//Add Jet that was created to Jets Array List on Line 10 
						jets.add(jet);
						
				
				
					}//While	
					file.close();
					
					
				}
			
				
			 catch (Exception e) {	
				e.printStackTrace();
			} 
		
		
	}//Pop AirField Method
		
	public void menu() {
		
		String choice;
		
		do
		{
		System.out.println("          Menu          ");
		System.out.println("-------------------------");
		System.out.println("1.) List fleet");
		System.out.println("2.) Fly all jets");
		System.out.println("3.) View fastest Jet");
		System.out.println("4.) View jet with longest range");
		System.out.println("5.) Go over Safety Procedures");
		System.out.println("6.) Dogfight!");
		System.out.println("7.) Add a jet to Fleet");
		System.out.println("8.) Remove a jet from the Fleet");
		System.out.println("9.) Quit");
		
		System.out.println("Please enter your choice");
		choice = input.next().trim();
		
		if (choice.equals("1")) {
			
			//List fleet
			listFleet();
			
		} else if(choice.equals("2")) {
			
			//Fly all jets
			flyAll();
			
		} else if(choice.equals("3")) {
			
			//View fastest jet
			viewFastest();
			
		} else if(choice.equals("4")) {
			
			//View jet w/ longest range
			viewLongestRange();
			
		} else if(choice.equals("5")) {
			
			//Go over Safety Procedures
			goOverSafetyProcedures();
			
		} else if(choice.equals("6")) {
			
			//Dawg
			fight();
			
		} else if(choice.equals("7")) {
			
			//Add jet to Fleet
			addJet();
			
		} else if(choice.equals("8")) {
			
			//Remove jet from Fleet
			removeJet();
			
		} else if(choice.equals("9")) {
			
			break;
			
		} else {
			System.out.println("Invalid -- Please input a Valid Option: ");
			choice = input.next().trim();
		}
		
		
		} while(!choice.equals("9"));
		
		System.out.println("\nEnd");
		
	}//Menu Method
	
	//1
	public void listFleet() {
		
		//Validates if List is empty
		if(jets.size() == 0) {
			System.out.println("\nList Empty -- Returning to Menu\n");
		} 
		
		else {
			for(int i = 0; i < jets.size(); i++) {
				System.out.println("Jet " + (i+1) + " " + jets.get(i));
			}
		}

	}//List Method
	
	//2
	public void flyAll() {
		
		for(Jet jet : jets) {
			System.out.println();
			jet.fly();
			System.out.println();
		}
		
		
	}//Fly All Method

	//3
	public void viewFastest() {

		double largest = 0;
		String nameOfFastest = null;
		
		for (int i = 0; i < jets.size(); i++) {
			if(jets.get(i).getSpeedMach(i) > largest) {
				largest = jets.get(i).getSpeedMach(i);
				nameOfFastest = jets.get(i).getModel();
				
			}
		
		}
		
		System.out.println("\nThe fastest jet is: " + nameOfFastest + ". It goes: " + largest + " Mach\n");
		
	}//View Fastest Method
	
	//4
	public void viewLongestRange() {
		
		int longest = 0;
		String name = null;
		
		for (int i = 0; i < jets.size(); i++) {
			if(jets.get(i).getRange() > longest) {
				longest = jets.get(i).getRange();
				name = jets.get(i).getModel();
				
			}
		
		}
		
		System.out.println("\nThe jet with the longest range is: " + name + ". It goes: " + longest + " Miles\n");
		
	}
	
	//5
	public void goOverSafetyProcedures() {
		
		for(Jet jet : jets) {
			
			if(jet instanceof PassengerPlane) {
				((PassengerPlane) jet).go_over_safety_procedures_to_passengers();
				} else {
					System.out.println("Returning to Menu");
					break;
					
				}
			}
		
	}//Go Over Safety Method
	
	//6
	public void fight() {
		
			for(Jet jet : jets) {
				
				if(jet instanceof FighterJet) {
					((FighterJet) jet).look_cool();
				} else {
					System.out.println("Returning to Menu");
					break;
				}
				
			}
	
	}//Look Cool Method
	
	//7
	public void addJet() {
		
		String choice;
		
		System.out.println("\nWould you like to add a Jet to the List?\n");
		choice = input.next().toUpperCase();
		
		if(choice.equals("YES")) {
			
			System.out.println("Please input the Model of the Jet: "); 
			String model_type = input.next(); //Model (i.e: Boeing)
			String model_name = input.next(); //Name (i.e: 757)
			String model = model_type + " " + model_name; //Concats type and name into one String
			
			System.out.println("Please input the Speed of the Jet: ");
			double speed = input.nextDouble();
			
			System.out.println("Please input the Range of the Jet: ");
			int range = input.nextInt();
			
			System.out.println("Please input the Price of the Jet: ");
			long price = input.nextLong();
			
			
			Jet jet;
			
			//Passenger
			if (model.charAt(0) == 80 || model.charAt(0) == 112) {
				jet = new PassengerPlane(model, speed, range, price);
				
			//Fighter
			} else if(model.charAt(0) == 70 || model.charAt(0) == 106) {
				jet = new FighterJet(model, speed, range, price);
				
			//Generic 
			} else {
				jet = new JetImpl(model, speed, range, price);
			}
		
			jets.add(jet);
	
			System.out.println("\nJet added -- Returning to Menu\n");
		} else {
			System.out.println("Returning to Menu...\n");
		}
		
		
		
	}
	
	//8
	public void removeJet() {
		
		int choice;
		String confirm;
		
		//Will validate if there are Jets on the List -- if none, choice set to Zero and Method exits to Menu
		if(jets.size() == 0) {
			
			System.out.println("There are no Jets on this List -- Returning to Menu");
			
		} else {
		
		//List Jets and asks User which Jet they would like to remove
		for(int i = 0; i < jets.size(); i++) {
			
			System.out.println("Jet " + (i+1) + " " + jets.get(i));
			choice = 0;
		}
		
		System.out.println("\nWhich Jet would you like to remove from the list: \n");
		choice = input.nextInt();
		
		System.out.println("\n!!! Are you sure you would like to remove this Jet from the Menu? !!!\n");
		confirm = input.next().toUpperCase();
		
		if(confirm.equals("YES")) {
		
			if(choice == 1) {
				Jet removed = jets.get(0);
				jets.remove(0);
				System.out.println("\nYou removed the: " + removed.getModel() + " Jet-- returning to Menu\n");
			} else if (choice == 2) {
				Jet removed = jets.get(1);
				jets.remove(1);
				System.out.println("\nYou removed the: " + removed.getModel() + " Jet-- returning to Menu\n");
			} else if (choice == 3) {
				Jet removed = jets.get(2);
				jets.remove(2);
				System.out.println("\nYou removed the: " + removed.getModel() + " Jet-- returning to Menu\n");
			} else if (choice == 4) {
				Jet removed = jets.get(3);
				jets.remove(3);
				System.out.println("\nYou removed the: " + removed.getModel() + " Jet -- returning to Menu\n");
			} else {
				System.out.println("\nInvalid choice -- returning to Menu\n");
			}

		} else {
			System.out.println("\nReturning to Menu\n");
		}
		
		}
	}//Remove Method
	
	
	
}//Class
