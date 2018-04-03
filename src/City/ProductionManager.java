package City;

import Buildings.Buildable;
import Buildings.Building;

public class ProductionManager
{
	CityHub home;
	Buildable nextProject;
	int currentProgress;
	public ProductionManager(CityHub city)
	{
		home = city;
		currentProgress = 0;
	}
	
	public void createProject(Buildable next)
	{
		nextProject = next;
	}
	
	public void addProgress(int progress)
	{
		currentProgress += progress;
		if (nextProject.getProductionCost() > currentProgress)
		{
			if(nextProject instanceof Building)
			{
				Building bob = (Building) nextProject;
				
			}
		}
	}
}
