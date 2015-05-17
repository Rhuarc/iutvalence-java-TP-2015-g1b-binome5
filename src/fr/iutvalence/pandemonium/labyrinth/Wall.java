package fr.iutvalence.pandemonium.labyrinth;

/**
 * Un {@link Wall} de notre Labyrinthe.
 *
 * @author Eymeric
 * @version 1.0
 */
public class Wall extends AbstractBox
	{

		public Wall(int vertical, int horizontal)
			{
				super(vertical, horizontal);
			}

		/** un {@link Wall} est inaccessible */
		public boolean isAvailable()
			{
				return false;
			}

		/** representation d'un {@link Wall} en ASCII art. */
		@Override
		public String toString()
			{
				return "X";
			}

	}
