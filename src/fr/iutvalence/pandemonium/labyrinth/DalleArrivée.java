package fr.iutvalence.pandemonium.labyrinth;

/**
 * {@link Dalle} qui sert d'arrivée au joueur.
 * 
 * @author Eymeric
 * @version 1.0
 */
public class DalleArrivée extends Dalle implements Case
	{
		
		public DalleArrivée()
		{
			super();
		}
		/** cette Dalle sert d'arrivée au joueur */
		public boolean estUneArrivee()
			{
				return true;
			}
		/**
		 * Representation d'une Dalle de dépat en ASCII art.
		 * @return A
		 */
		@Override
		public String toString()
			{if (this.joueurEstPresent)
				return "J";
				else return "A";
			}
	}
