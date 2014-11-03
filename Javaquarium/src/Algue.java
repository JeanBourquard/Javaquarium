
public class Algue extends EtreVivant{
	
	public Algue()
	{
		super();
	}
	
	public Algue(int age)
	{
		super(age);
	}

	EtreVivant makeBaby()
	{
		this.setHealthPoints(this.getHealthPoints()/2);
		EtreVivant baby = new Algue();
		baby.setHealthPoints(this.getHealthPoints());
		
		return baby;
	}
	
}
