package fr.iutvalence.pandemonium.labyrinth;

/**
 * Une dalle abstraite.
 * 
 * @author chenavie.
 */
public abstract class Dalle extends Case
	{
		/**
		 * Une {@link Dalle} est accessible.
		 */
		private static boolean accès = true;

		/**
		 * une {@link Dalle} n'est pas un point de départ.
		 * 
		 */
		private final boolean estUnDépart = false;

		/**
		 * Une {@link Dalle} n'est pas un point de départ.
		 */
		private static boolean estUneArrivée = false;

		public Dalle()
			{

			}

		/**
		 * Obtenir si la case est une arrivée
		 * 
		 * @return false
		 */
		public boolean estUneArrivée()
			{
				return false;
			}

		/**
		 * Retourne si une Dalle est un départ.
		 * 
		 * @return si la Dalle est un départ.
		 */
		public boolean estUnDépart()
			{
				return false;
			}

		/**
		 * 
		 * @return si la case est accessible
		 */
		public boolean estAccessible()
			{
				return true;
			}

	}