package fr.iutvalence.pandemonium.labyrinth;

/**
 * joueur qui se déplace dans le labyrinth
 * 
 * @author Eymeric
 *
 */
public class CaseJoueur implements Case
	{
		/**
		 * position Vertical du joueur
		 */
		private int positionVertical;

		/**
		 * position Horizontal du joueur sur le plateau
		 */
		private int positionHorizontal;

		/**
		 * constructeur de {@link CaseJoueur}
		 * 
		 * @param positionInitialeVerticale
		 * @param positionInitialeHorizontal
		 */

		public CaseJoueur(int positionInitialeVerticale, int positionInitialeHorizontal)
			{
				this.positionVertical = positionInitialeVerticale;

				this.positionHorizontal = positionInitialeHorizontal;
			}

		/**
		 * renvoie la position Vertical de la {@link CaseJoueur}
		 * 
		 * @return position Vertical
		 */
		public int donnePositionVertical()
			{
				return this.positionVertical;
			}

		/**
		 * renvoie la position horizontal de la {@link CaseJoueur}
		 * 
		 * @return position horizontal
		 */

		public int donnePositionHorizontal()
			{
				return this.positionHorizontal;
			}

		/**
		 * determine la position vertical de la {@link CaseJoueur}
		 * 
		 * @param positionVertical
		 */

		public void determinePositionVertical(int positionVertical)
			{
				this.positionVertical = positionVertical;
			}

		/**
		 * determine la position horizontal de la {@link CaseJoueur}
		 * 
		 * @param positionHorizontal
		 */

		public void determinePositionHorizontal(int positionHorizontal)
			{
				this.positionHorizontal = positionHorizontal;
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
