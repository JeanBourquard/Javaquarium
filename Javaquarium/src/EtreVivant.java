
abstract class EtreVivant {
	protected int m_healthPoints;
	protected int m_age;
	
	public EtreVivant(int age)
	{
		m_healthPoints = 10;
		m_age = age;
	}
	
	public EtreVivant()
	{
		m_healthPoints = 10;
		m_age = 0;
	}
	
	abstract EtreVivant makeBaby();
	
	public boolean isAlive()
	{
		if(m_healthPoints < 0 || m_age >= 20)
		{
			return false;
		}
		else
		{
			return true;
		}
					
	}
	
	public void takeDamages(int damages)
	{
		m_healthPoints = m_healthPoints - damages;
	}
	
	public int getHealthPoints()
	{
		return m_healthPoints;
	}
	
	public void setHealthPoints(int healthPoints)
	{
		m_healthPoints = healthPoints;
	}
	
	public int getAge()
	{
		return m_age;
	}
	
	public void setAge(int age)
	{
		m_age = age;
	}

}
