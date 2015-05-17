package fr.iutvalence.pandemonium.labyrinth;


/**
 * Case du labyrinthe.
 * <p>
 * 
 * @author chenavie
 * @version 1.0
 */
 abstract class AbstractBox implements BoxInterface
	{
		private int verticalPosition;
		
		private int horizontalPosition;
		
		
		/**
		 * the {@link AbstractBox} attributes have their coordinates
		 * @param vertical
		 * @param horizontal
		 */
		public AbstractBox(int vertical, int horizontal)
		{
			this.verticalPosition = vertical;
			this.horizontalPosition = horizontal;
		}
		/**
		 * 
		 * @return vertical position of the {@link AbstractBox}
		 */
		public int getPositionVertical()
			{
				return this.verticalPosition;
			}
		/**
		 * setter de la position Horizontal 
		 * @return position horizontal de la {@link AbstractBox}
		 */
		public int getPositionHorizontal()
			{
				return this.horizontalPosition;
			}
		/**
		 * modifie la position veritcal de la {@link AbstractBox}
		 * @param positionVertical
		 */

		public void setPositionVertical(int positionVertical)
			{
				this.verticalPosition = positionVertical;
			}
		/**
		 * modifie la position horizontal de la {@link AbstractBox}
		 * @param positionHorizontal
		 */
		public void setPositionHorizontal(int positionHorizontal)
			{
				this.horizontalPosition = positionHorizontal;
			}

		/** Par défaut, une Case est inaccessible. */
		
		public boolean isAvailable()
			{
				return false;
			}
	}
