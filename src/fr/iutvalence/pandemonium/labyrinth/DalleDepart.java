package fr.iutvalence.pandemonium.labyrinth;

/**
 * Dalle qui sert de départ au joueur.
 *
 * @author Eymeric
 * @version 1.0
 */
public class DalleDepart extends Dalle implements InterfaceCase
	{
		public DalleDepart()
		{
			super();
		}

		/** Dalle de départ. */
		@Override
		public boolean estUnDepart()
			{
				return true;
			}

		/**
		 * Representation d'une {@link Dalle} de dépat en ASCII art.
		 * 
		 * @return D
		 */
		@Override
	
		public String toString()
		
			{
				if (this.joueurEstPresent)
				return "J";
				else return "D";
			}

	}
