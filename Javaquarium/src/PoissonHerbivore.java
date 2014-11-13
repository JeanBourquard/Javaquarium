
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
}
