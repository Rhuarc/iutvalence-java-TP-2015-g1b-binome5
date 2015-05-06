package fr.iutvalence.pandemonium.labyrinth;

/**
 * Un {@link Mur} de notre Labyrinthe.
 *
 * @author Eymeric
 * @version 1.0
 */
public class Mur extends Case
	{
		
		public Mur(int vertical, int horizontal)
		{
			super(vertical, horizontal);
		}

		/** un {@link Mur} est inaccessible */
		public boolean estAccessible()
			{
				return false;
			}
		
		/** representation d'un {@link Mur} en ASCII art.*/
		@Override
		public String toString()
					{
				return "X";
			}

	}
