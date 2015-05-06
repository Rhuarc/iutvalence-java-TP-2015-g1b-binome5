package fr.iutvalence.pandemonium.labyrinth;

/**
 * joueur qui se déplace dans le labyrinth
 * 
 * @author Eymeric
 *
 */
public class CaseJoueur extends Case
	{
		
		public CaseJoueur(int Vertical, int Horizontal)
		{
			this.PositionVertical=Vertical;
			this.positionHorizontal=Horizontal;
		}
		

		

		/**
		 * une {@link CaseJoueur} ne peut pas être accessible.
		 */
		public boolean estAccessible()
			{
				return false;
			}

		/**
		 * representation ASCII d'une {@link CaseJoueur}
		 */
		public String toString()
			{
				return "J";
			}

	}
