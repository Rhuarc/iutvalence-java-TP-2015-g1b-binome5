package fr.iutvalence.pandemonium.labyrinth;

/**
 * joueur qui se déplace dans le labyrinth
 * 
 * @author Eymeric
 *
 */
public class PlayerBox extends AbstractBox implements BoxInterface
	{
		
			
		public PlayerBox(int vertical, int horizontal)
		{
			super(vertical, horizontal);
		}
		
		/**
		 * une {@link PlayerBox} ne peut pas être accessible.
		 */
		public boolean isAvailable()
			{
				return false;
			}

		/**
		 * representation ASCII d'une {@link PlayerBox}
		 */
		public String toString()
			{
				return "J";
			}

	}
