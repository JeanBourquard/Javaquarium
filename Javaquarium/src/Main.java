import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String inputString;

		Aquarium myAquarium = new Aquarium();
		
		myAquarium.addFish("Jacques", "M", "Merou", 3);
		myAquarium.addFish("Jules", "M", "Bar", 5);
		myAquarium.addFish("Clementine", "F", "Bar", 8);
		myAquarium.addFish("Fil", "M", "Carpe", 10);
		myAquarium.addFish("Miji", "F", "Carpe", 1);
		myAquarium.addFish("Sally", "F", "Sole", 2);
		myAquarium.addFish("Ellen", "F", "PoissonClown", 7);
		myAquarium.addFish("Chris", "M", "PoissonClown", 11);
		
		myAquarium.addSeaWeed(4);
		myAquarium.addSeaWeed(2);
		myAquarium.addSeaWeed(3);
		myAquarium.addSeaWeed(1);
		myAquarium.addSeaWeed(8);
		
		do
		{

				System.out.println("Do you want to add fishes or sea weeds ? Y/N (Q to exit after next tour)");
				inputString = sc.nextLine();
				
				if(inputString.equals("Y"))
				{
					System.out.println("Which one : fishes or sea weeds ? F/S");
					inputString = sc.nextLine();
					if(inputString.equals("F"))
					{
						String sex = new String();
						String race = new String();
						int age = -1;
						System.out.println("How many ?");
						int inputInt = sc.nextInt();
						sc.nextLine();
						for(int j = 0; j < inputInt; j++)
						{
							
							System.out.println("What name do you want to give to the fish ?");
//							do
//							{
//								inputString = sc.nextLine();
//							}while(inputString.isEmpty());
							inputString = sc.nextLine();
							System.out.println("What sex is it ? M/F");
//							do
//							{
//								
//							}while(sex.isEmpty());
							sex = sc.nextLine();
							System.out.println("What is its race ?");
//							do
//							{
//								
//							}while(race.isEmpty());
							race = sc.nextLine();
							System.out.println("What is its age ?");
//							do
//							{
//								
//							}while(age == -1);
							age = sc.nextInt();
							sc.nextLine();
							
							myAquarium.addFish(inputString, sex, race, age);
						}
					}
					
					if(inputString.equals("S"))
					{
						System.out.println("How many ?");
						int inputInt = sc.nextInt();
						sc.nextLine();
						for(int j = 0; j < inputInt; j++)
						{						
							myAquarium.addSeaWeed();
						}
					}
				}
				
				myAquarium.computeTour();
		}while(!inputString.equals("Q"));
		
		

	}

}
