package fr.iutvalence.pandemonium.labyrinth;

/**
 * 
 * @author chenavie Classe abstraite modélisant une case du labyrinth.
 */
public abstract class Case
	{
		/**
		 * Pour savoir si le joueur peut accéder à cette case.
		 */
		private static boolean accès = false;

		/**
		 * Une Cas ne peut être accessible.
		 * 
		 * @return boolean
		 */
		public boolean obtenirAccès()
			{
				return false;
			}



	}
