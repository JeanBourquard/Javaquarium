
public class PoissonCarnivore extends Poisson{

	public PoissonCarnivore(String name, String sex, String race) {
		super(name, sex, race, "Carnivore");
	}
	
	public PoissonCarnivore(String name, String sex, String race, int age) {
		super(name, sex, race, "Carnivore",age);
	}

	void mange() {
		this.setHealthPoints(this.getHealthPoints()+5);
		
	}

	EtreVivant makeBaby()
		{
		int sexInt = r.nextInt(2);
		EtreVivant baby = new PoissonCarnivore(this.getName(), "Unknown", this.getRace(), 0);;
		if (sexInt == 0)
			 ((Poisson)baby).setSex("M");
		else if (sexInt == 1)
			((Poisson)baby).setSex("F");
			
		return baby;
	}
}
