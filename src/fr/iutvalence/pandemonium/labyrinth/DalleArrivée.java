package fr.iutvalence.pandemonium.labyrinth;

/**
 * {@link Slab} qui sert d'arrivée au joueur.
 * 
 * @author Eymeric
 * @version 1.0
 */
public class DalleArrivée extends Slab implements BoxInterface
	{
		
		

		public DalleArrivée(int vertical, int horizontal)
		{
			super(vertical, horizontal);

		}
		/** cette Dalle sert d'arrivée au joueur */
		public boolean isAnArrival()
			{
				return true;
			}
		/**
		 * Representation d'une Dalle de dépat en ASCII art.
		 * @return A
		 */
		@Override
		public String toString()
			{
				return "A";
			}
	}
