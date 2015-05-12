package fr.iutvalence.pandemonium.labyrinth;


/**
 * Case du labyrinthe.
 * <p>
 * 
 * @author chenavie
 * @version 1.0
 */
 abstract class Box implements BoxInterface
	{
		private int positionVertical;
		
		private int positionHorizontal;
		
		
		/**
		 * the {@link Box} attributes have their coordinates
		 * @param vertical
		 * @param horizontal
		 */
		public Box(int vertical, int horizontal)
		{
			this.positionVertical = vertical;
			this.positionHorizontal = horizontal;
		}
		/**
		 * 
		 * @return vertical position of the {@link Box}
		 */
		public int getPositionVertical()
			{
				return this.positionVertical;
			}
		/**
		 * setter de la position Horizontal 
		 * @return position horizontal de la {@link Box}
		 */
		public int getPositionHorizontal()
			{
				return this.positionHorizontal;
			}
		/**
		 * modifie la position veritcal de la {@link Box}
		 * @param positionVertical
		 */

		public void setPositionVertical(int positionVertical)
			{
				this.positionVertical = positionVertical;
			}
		/**
		 * modifie la position horizontal de la {@link Box}
		 * @param positionHorizontal
		 */
		public void setPositionHorizontal(int positionHorizontal)
			{
				this.positionHorizontal = positionHorizontal;
			}

		/** Par défaut, une Case est inaccessible. */
		
		public boolean isAvailable()
			{
				return false;
			}
	}
