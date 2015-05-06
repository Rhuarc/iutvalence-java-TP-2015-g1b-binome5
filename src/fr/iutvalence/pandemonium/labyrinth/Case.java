package fr.iutvalence.pandemonium.labyrinth;


/**
 * Case du labyrinthe.
 * <p>
 * 
 * @author chenavie
 * @version 1.0
 */
 abstract class Case implements InterfaceCase
	{
		private int positionVertical;
		
		private int positionHorizontal;
		
		
		/**
		 * une {@link Case} à comme attributs ses coordonés.
		 * @param vertical
		 * @param horizontal
		 */
		public Case(int vertical, int horizontal)
		{
			this.positionVertical = vertical;
			this.positionHorizontal = horizontal;
		}
		/**
		 * 
		 * @return position Vertical de la {@link Case}
		 */
		public int getPositionVertical()
			{
				return this.positionVertical;
			}
		/**
		 * setter de la position Horizontal 
		 * @return position horizontal de la {@link Case}
		 */
		public int getPositionHorizontal()
			{
				return this.positionHorizontal;
			}
		/**
		 * modifie la position veritcal de la {@link Case}
		 * @param positionVertical
		 */

		public void setPositionVertical(int positionVertical)
			{
				this.positionVertical = positionVertical;
			}
		/**
		 * modifie la position horizontal de la {@link Case}
		 * @param positionHorizontal
		 */
		public void setPositionHorizontal(int positionHorizontal)
			{
				this.positionHorizontal = positionHorizontal;
			}

		/** Par défaut, une Case est inaccessible. */
		
		public boolean estAccessible()
			{
				return false;
			}
	}
