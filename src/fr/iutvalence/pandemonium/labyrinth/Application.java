package fr.iutvalence.pandemonium.labyrinth;


/**
 * l'application servant a jouer au labyrinthe
 * 
 * @author Eymeric
 *
 */
public class Application
	{
		/**
		 * la partie qui est jouer par {@link Application}
		 */

		public static void main(String[] args)
			{
				Partie maPartie = new Partie();
				maPartie.start();

			}

	}
