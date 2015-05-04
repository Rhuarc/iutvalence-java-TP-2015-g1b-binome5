package fr.iutvalence.pandemonium.labyrinth;

/**
 * Plateau de jeu contenant notre Labyrinthe.
 * 
 * @author Eymeric
 *
 */
public class Plateau
	{
		public final static int NOMBRE_CASES_HORIZONTAL_LABYRINTHE = 10;
		public final static int NOMBRE_CASES_VERTICAL_LABYRINTHE = 10;
		/** Le Plateau est un tableaux de Case a deux dimensions. */
		public Case[][] cases;

		/**
		 * un plateau est créer. il contient un chemin de {@link Dalle}, une
		 * {@link DalleDepart}, une {@link DalleArrivée} et des {@link Mur}.
		 */
		public Plateau()
			{
				this.cases = new Case[NOMBRE_CASES_VERTICAL_LABYRINTHE][NOMBRE_CASES_HORIZONTAL_LABYRINTHE];
				for (int indiceCasesVertical = 0; indiceCasesVertical < NOMBRE_CASES_VERTICAL_LABYRINTHE; indiceCasesVertical++)
					{
						for (int indicesCasesHorizontal = 0; indicesCasesHorizontal < NOMBRE_CASES_HORIZONTAL_LABYRINTHE; indicesCasesHorizontal++)
							{
								if (indicesCasesHorizontal == 5)
									{
										switch (indiceCasesVertical) {
										case 0:
											{
												this.cases[indiceCasesVertical][indicesCasesHorizontal] = new DalleDepart();
												break;
											}
										case NOMBRE_CASES_VERTICAL_LABYRINTHE - 1:
											{
												this.cases[indiceCasesVertical][indicesCasesHorizontal] = new DalleArrivée();
												break;
											}
										default:
											{
												this.cases[indiceCasesVertical][indicesCasesHorizontal] = new Dalle();
											}
										}
									}

								else
									{
										this.cases[indiceCasesVertical][indicesCasesHorizontal] = new Mur();
									}
							}
					}

			}

		/**
		 * affiche le {@link Plateau} en ascii ART
		 * 
		 * @return le {@link Plateau} en console
		 */

		public String affichePlateau()
			{
				String PlateauAsciiArt = "";
				for (int numeroCaseVertical = 0; numeroCaseVertical < NOMBRE_CASES_VERTICAL_LABYRINTHE; numeroCaseVertical++)
					{
						for (int numeroCaseHorizontal = 0; numeroCaseHorizontal < NOMBRE_CASES_HORIZONTAL_LABYRINTHE; numeroCaseHorizontal++)
							{
								PlateauAsciiArt += this.cases[numeroCaseVertical][numeroCaseHorizontal];
							}
						PlateauAsciiArt += "\n";

					}
				return PlateauAsciiArt;

			}

	}
