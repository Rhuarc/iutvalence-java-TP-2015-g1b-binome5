package fr.iutvalence.pandemonium.labyrinth;

/**
 * Une {@link Dalle} est une {@link Case} qui est accessible. TODO Compléter la
 * javadoc en situant (conceptuellement) Dalle par rapport à Case.
 *
 * @author chenavie.
 * @version 1.0
 */
public class Dalle implements Case
	{
		public boolean joueurEstPresent;
		
		/** Par défaut, une dalle n'est pas une arrivée. */
		public boolean estUneArrivee()
			{
				return false;
			}

		/** Par défaut, une dalle n'est pas un départ. */
		public boolean estUnDepart()
			{
				return false;
			}

		/** Une Dalle est une Case accessible. */
		@Override
		public boolean estAccessible()
			{
				return true;
			}
		
		public Dalle ()
		{
			this.joueurEstPresent = false;
		}
		

		@Override
		public String toString()
		{if (this.joueurEstPresent)
			return "J";
			else return " ";
		}
	}
