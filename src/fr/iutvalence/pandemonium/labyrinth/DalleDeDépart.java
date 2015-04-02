package fr.iutvalence.pandemonium.labyrinth;

/**
 * une Dalle qui sert de départ au joueur.
 * 
 * @author Eymeric
 *
 */
public class DalleDeDépart extends Dalle
	{
		/**
		 * une DalleDeDépart est un point de départ.
		 */
		private final boolean estUnDépart = true;

		public DalleDeDépart()
			{
				super();
			}

		/**
		 * une DalleDeDépart est Accessible.
		 * 
		 * @return true
		 */
		public boolean estAccessible()
			{
				return super.estAccessible();
			}

		/**
		 * retourne si la Dalle est un départ.
		 */
		public boolean estUnDépart()
			{
				return this.estUnDépart;
			}

		/**
		 * 
		 */
		public boolean estUneArrivée()
			{
				return super.estUneArrivée();
			}

		@Override
		public String toString()
			{
				return "DalleDeDépart [estAccessible()=" + estAccessible()
						+ ", estUnDépart()=" + estUnDépart()
						+ ", estUneArrivée()=" + estUneArrivée() + "]";
			}

		/**
		 * Représentation Texte d'une DalleDeDépart.
		 */
		


	}
