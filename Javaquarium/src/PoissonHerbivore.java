
public class PoissonHerbivore extends Poisson{

	public PoissonHerbivore(String name, String sex, String race) {
		super(name, sex, race, "Herbivore");
	}
	
	public PoissonHerbivore(String name, String sex, String race, int age) {
		super(name, sex, race, "Herbivore", age);
	}

	void mange() {
		this.setHealthPoints(this.getHealthPoints()+3);
	}

	EtreVivant makeBaby()
	{
	int sexInt = r.nextInt(2);
	EtreVivant baby = new PoissonHerbivore(this.getName(), "Unknown", this.getRace(), 0);
	if (sexInt == 0)
		 ((Poisson)baby).setSex("M");
	else if (sexInt == 1)
		((Poisson)baby).setSex("F");
		
	return baby;
}

}
