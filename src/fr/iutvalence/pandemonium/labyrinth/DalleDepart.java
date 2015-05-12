package fr.iutvalence.pandemonium.labyrinth;

/**
 * Dalle qui sert de départ au joueur.
 *
 * @author Eymeric
 * @version 1.0
 */
public class DalleDepart extends Slab implements BoxInterface
	{

		/**
		 * constructeur d'une {@link DalleDepart} une Dalle à ses coordonée sur
		 * le plateau.
		 * 
		 * @param vertical
		 * @param horizontal
		 */
		public DalleDepart(int vertical, int horizontal)
			{
				super(vertical, horizontal);
			}

		/** Dalle de départ. */
		@Override
		public boolean isAnStart()
			{
				return true;
			}

		/**
		 * Representation d'une {@link Slab} de dépat en ASCII art.
		 * 
		 * @return D
		 */
		@Override
		public String toString()

			{
				return "D";
			}

	}
