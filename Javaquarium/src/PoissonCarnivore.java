
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
}
