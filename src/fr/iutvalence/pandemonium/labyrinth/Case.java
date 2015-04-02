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
		 * Accesseur en lecture pour accès. permet de savoir si la case est
		 * accessible ou non.
		 * 
		 * @return boolean
		 */
		public boolean obtenirAccès()
			{
				return this.accès;
			}

	}
