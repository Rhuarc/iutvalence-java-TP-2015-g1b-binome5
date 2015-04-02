package fr.iutvalence.pandemonium.labyrinth;

/**
 * modélise une dalle du labyrinthe.
 * 
 * @author Eymeric
 *
 */
public class DalleBasique extends Dalle
	{
		/**
		 * une {@link DalleBasique} a les mêmes attributs qu'une {@link Dalle}.
		 */
		public DalleBasique()
			{
				super();
			}

		/**
		 * une DalleBasique est accessible
		 */
		public boolean estAccessible()
			{
				return super.estAccessible();
			}

		/**
		 * une {@link DalleBasique} n'est pas une arrivée.
		 */
		public boolean estUneArrivée()
			{
				return super.estUneArrivée();
			}

		/**
		 * une {@link DalleBasique} n'est pas un départ.
		 */
		public boolean estUnDépart()
			{
				return super.estUnDépart();
			}

	}
