package fr.iutvalence.pandemonium.labyrinth;

public class AppliTest
	{

		public static void main(String[] args)
			{
				DalleBasique maDalle = new DalleBasique();
				
				DalleDeDépart maDalleDeDépart = new DalleDeDépart();
				
				Mur monMur = new Mur();
				
				System.out.println(maDalle.estAccessible());
						

			}

	}
