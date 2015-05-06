package fr.iutvalence.pandemonium.labyrinth;

/**
 * Une {@link Dalle} est une {@link InterfaceCase} qui est accessible. javadoc
 * en situant (conceptuellement) Dalle par rapport à Case.
 *
 * @author chenavie.
 * @version 1.0
 */
public class Dalle extends Case
	{

		public Dalle(int vertical, int horizontal)
			{
				super(vertical, horizontal);
			}

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

		@Override
		public String toString()
			{
				return " ";
			}
	}
