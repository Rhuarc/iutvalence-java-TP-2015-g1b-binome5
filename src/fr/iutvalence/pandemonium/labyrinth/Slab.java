package fr.iutvalence.pandemonium.labyrinth;

/**
 * Une {@link Slab} est une {@link BoxInterface} qui est accessible. javadoc
 * en situant (conceptuellement) Dalle par rapport à Case.
 *
 * @author chenavie.
 * @version 1.0
 */
public class Slab extends AbstractBox
	{

		public Slab(int vertical, int horizontal)
			{
				super(vertical, horizontal);
			}

		/** Par défaut, une dalle n'est pas une arrivée. */
		public boolean isAnArrival()
			{
				return false;
			}

		/** Par défaut, une dalle n'est pas un départ. */
		public boolean isAnStart()
			{
				return false;
			}

		/** Une Dalle est une Case accessible. */
		@Override
		public boolean isAvailable()
			{
				return true;
			}

		@Override
		public String toString()
			{
				return " ";
			}
	}
