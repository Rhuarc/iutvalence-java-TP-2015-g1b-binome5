package fr.iutvalence.pandemonium.labyrinth;

/**
 * 
 * @author chenavie Une dalle accéssible. Le joueur peut accéder à une Dalle, on
 *         définit pour cette classe que aucune Dalle n'est un point de départ
 *         ni d'arrivée.
 */
public abstract class Dalle extends Case
	{
		/**
		 * Une dalle est accessible.
		 */
		private static boolean accès = true;
		
		/**
		 * une Dalle n'est pas un point de départ
		 * 
		 */
		private final boolean estUnDépart = false;
		
		/**
		 * Une dalle n'est pas un point de départ
		 */
		private static boolean estUneArrivée = false;

		/**
		 * Toute les Dalles sont accessible.
		 * @return true
		 */
		public boolean estAcces()
			{
				return true;
			}
		
		/**
		 * Une dalle ne peut être un départ.
		 * @return false;
		 */
		public boolean estUnDépart()
			{
				return this.estUnDépart;
			}
		/**
		 * Une dalle ne peut être une Arrivée.
		 * @return false
		 */
		public boolean estUneArrivée()
			{
				return false;
			}

	}
