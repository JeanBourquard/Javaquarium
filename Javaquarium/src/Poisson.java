import java.util.Random;


public abstract class Poisson extends EtreVivant {
	protected String m_name;
	protected String m_sex;
	protected String m_race;
	protected String m_type;
	protected Random r;
	

	abstract void mange();
	
	public Poisson(String name, String sex, String race, String type)
	{
		super();
		m_name = name;
		m_sex = sex;
		m_race = race;
		m_type = type;
		r = new Random();
	}
	
	public Poisson(String name, String sex, String race, String type, int age)
	{
		super(age);
		m_name = name;
		m_sex = sex;
		m_race = race;
		m_type = type;
		r = new Random();
	}
	
	public String getName()
	{
		return m_name;
	}
	
	public String getSex()
	{
		return m_sex;
	}
	
	public String getRace()
	{
		return m_race;
	}
	
	public String getType()
	{
		return m_type;
	}
	
	public void setSex(String sex)
	{
		m_sex = sex;
	}
	
	EtreVivant makeBaby()
	{
		System.out.println("MAKE BABY : " + this.getRace());
	int sexInt = r.nextInt(2);
	EtreVivant baby = null;
	if(this.getType().equals("Carnivore"))
	{
		baby = new PoissonCarnivore(this.getName(), "Unknown", this.getRace(), 0);
	}
	else if(this.getType().equals("Herbivore"))
	{
		baby = new PoissonHerbivore(this.getName(), "Unknown", this.getRace(), 0);
	}	
	if (sexInt == 0)
		 ((Poisson)baby).setSex("M");
	else if (sexInt == 1)
		((Poisson)baby).setSex("F");
		
	return baby;
	}

	
}
