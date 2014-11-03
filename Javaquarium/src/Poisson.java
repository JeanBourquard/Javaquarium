import java.util.Random;


public abstract class Poisson extends EtreVivant {
	protected String m_name;
	protected String m_sex;
	protected String m_race;
	protected String m_type;
	protected Random r;
	
	abstract EtreVivant makeBaby();
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

	
}
