package fr.iutvalence.pandemonium.labyrinth;

/**
 * Classe abstraite modélisant une case du labyrinthe.
 * @author chenavie 
 */
public abstract class Case
	{
		/**
		 * Pour savoir si le joueur peut accéder à cette case.
		 */
		private static boolean accès = false;
		
		/**
		 * Une Case ne peut être accessible.
		 * 
		 * @return boolean
		 */
		public boolean estAccessible()
			{
				return false;
			}

	}
