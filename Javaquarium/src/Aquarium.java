import java.util.ArrayList;
import java.util.Random;

public class Aquarium {
	private ArrayList<EtreVivant> m_fishes;
	private ArrayList<EtreVivant> m_seaWeeds;
	private int m_nbTour;
	Random r;
	
	public Aquarium () {
		m_fishes = new ArrayList<EtreVivant>();
		m_seaWeeds = new ArrayList<EtreVivant>();
		r = new Random();
		m_nbTour = 1;
	}
	
	//add a fish in the array list
	public void addFish(String name, String sex, String race, int age)
	{
		if(race.equals("Merou") || race.equals("Thon") || race.equals("PoissonClown"))
		{
			this.m_fishes.add(new PoissonCarnivore(name, sex, race, age));	
		}
		else if(race.equals("Bar") || race.equals("Sole") || race.equals("Carpe"))
		{
			this.m_fishes.add(new PoissonHerbivore(name, sex, race, age));
		}
		
	}
	
	//add a fish in the array list
	public void addFish(String name, String sex, String race)
	{
		if(race.equals("Merou") || race.equals("Thon") || race.equals("PoissonClown"))
		{
			this.m_fishes.add(new PoissonCarnivore(name, sex, race));	
		}
		else if(race.equals("Bar") || race.equals("Sole") || race.equals("Carpe"))
		{
			this.m_fishes.add(new PoissonHerbivore(name, sex, race));
		}
		
	}
	
	public ArrayList<EtreVivant> getFishes()
	{
		return m_fishes;
	}
	
	public ArrayList<EtreVivant> getSeaWeeds()
	{
		return m_seaWeeds;
	}
	
	//add a sea weed in the array list
	public void addSeaWeed()
	{
		this.m_seaWeeds.add(new Algue());
	}
	
	//add a sea weed in the array list
	public void addSeaWeed(int age)
	{
		this.m_seaWeeds.add(new Algue(age));
	}
	
	//compute all the actions done during the tour
	public void computeTour()
	{
		m_nbTour += 1; //increment the tour number
		//if there are fishes
		if(!m_fishes.isEmpty())
		{
			System.out.println(m_fishes.size());
			int i = 0;
			do
			{
				if(m_fishes.get(i).isAlive())
				{
					//each tour fishes are more hungry so they lose 1 hp
					m_fishes.get(i).takeDamages(1);
					m_fishes.get(i).setAge(m_fishes.get(i).getAge() + 1);
					//if the fish is hungry
					if(m_fishes.get(i).getHealthPoints() < 5)
					{
						int j = -1;
						//if the fish is a carnivore
						if(((Poisson)m_fishes.get(i)).getType() == "Carnivore")
						{
							//we pick a random fish
							j = r.nextInt(m_fishes.size());
							//if the random fish is different from this one and is not from the same race
							if(j != i && !((Poisson)m_fishes.get(j)).getRace().endsWith(((Poisson)m_fishes.get(i)).getRace()))
							{
								//the fish eats the random fish
								((PoissonCarnivore)m_fishes.get(i)).mange();
								m_fishes.get(j).takeDamages(4);
							}

						}
						//if the fish is herbivore
						if(((Poisson)m_fishes.get(i)).getType() == "Herbivore")
						{
							//pick a random sea weed
							if(!m_seaWeeds.isEmpty())
							{
								j = r.nextInt(m_seaWeeds.size());
							}
							//the fish eats it
							((PoissonHerbivore)m_fishes.get(i)).mange();
							m_seaWeeds.get(j).takeDamages(2);
						}
					}
					else
					{
						int j = r.nextInt(m_fishes.size());
						//System.out.println("j: "+ j);
						//System.out.println(((Poisson)m_fishes.get(j)).getName());
						if(((Poisson)m_fishes.get(i)).getRace().equals(((Poisson)m_fishes.get(j)).getRace()) && !((Poisson)m_fishes.get(i)).getSex().equals(((Poisson)m_fishes.get(j)).getSex()) && m_fishes.get(i).getAge() != 1 && m_fishes.get(j).getAge() != 1)
						{
							EtreVivant baby = null;
							baby = ((Poisson)m_fishes.get(i)).makeBaby();
							m_fishes.add(baby);
							
						}
					}
				}
				else
				{
					m_fishes.remove(i);
					i--;
				}
				i++;
			}while(i < m_fishes.size());
		}
		if(!m_seaWeeds.isEmpty())
		{
			for(int i = 0; i < m_seaWeeds.size(); i++)
			{
				m_seaWeeds.get(i).setAge(m_seaWeeds.get(i).getAge() + 1);
				if(m_seaWeeds.get(i).isAlive())
				{
					m_seaWeeds.get(i).setHealthPoints(m_seaWeeds.get(i).getHealthPoints() + 1);
					if(m_seaWeeds.get(i).getHealthPoints() == 10)
					{
						EtreVivant baby = ((Algue)m_seaWeeds.get(i)).makeBaby();
						m_seaWeeds.add(baby);
					}
				}
				else
				{
					m_seaWeeds.remove(i);
					i--;
				}
			}
				
		}
		//display the content of the aquarium
		displayContent();
	}

	//display the content of the aquarium
	private void displayContent()
	{
		System.out.println("\n_____________________________________________________________\n");
		System.out.println("Tour number : " + m_nbTour);
		System.out.println("The aquarium contains " + m_fishes.size() + " fishes and " + m_seaWeeds.size() + " sea weeds");
		System.out.println("Fishes : ");
		for(int i = 0; i < this.m_fishes.size(); i++)
		{
			System.out.println(((Poisson)m_fishes.get(i)).getName() + " - HP : " + m_fishes.get(i).getHealthPoints() + " - Sex :  " + ((Poisson)m_fishes.get(i)).getSex() + " - Age : " + m_fishes.get(i).getAge() +" - Race : " + ((Poisson)m_fishes.get(i)).getRace() + " - Type : " + ((Poisson)m_fishes.get(i)).getType());
		}
		System.out.println("\nSea weeds : ");
		for(int i = 0; i < this.m_seaWeeds.size(); i++)
		{
			System.out.println("sea Weed :" + i + " " + m_seaWeeds.get(i).getHealthPoints() + "HP - Age : " + m_seaWeeds.get(i).getAge());
		}
		System.out.println("\n_____________________________________________________________\n");
		
	}
}
