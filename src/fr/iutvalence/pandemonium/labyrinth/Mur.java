package fr.iutvalence.pandemonium.labyrinth;

/**
 * Modélise les murs de notre Labyrinthe.
 * 
 * @author Eymeric
 *
 */
public class Mur extends Case
	{

		/**
		 * un {@link Mur}à les mêmes attributs qu'une {@link Case}.
		 */
		public Mur()
			{

			}
		/**
		 * un Mur n'est pas accessible par le Joueur.
		 */
		public boolean estAccessible()
			{
				return super.estAccessible();
			}

		@Override
		public String toString()
			{
				return "Mur [estAccessible()=" + estAccessible() + "]";
			}

	}
