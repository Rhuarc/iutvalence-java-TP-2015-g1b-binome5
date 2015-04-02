package fr.iutvalence.pandemonium.labyrinth;

/**
 * 
 * @author chenavie Une dalle accéssible. Le joueur peut accéder à une Dalle.
 */
public abstract class Dalle extends Case
	{
		private static boolean accès = true;

		private final boolean estUnDépart = false;

		private static boolean estUneArrivée = false;

		public boolean estAcces()
			{
				return true;
			}

		public boolean estUnDépart()
			{
				return false;
			}

		public boolean estUneArrivée()
			{
				return false;
			}

	}
