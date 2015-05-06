package fr.iutvalence.pandemonium.labyrinth;

import java.util.List;

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
		private Case[][] cases;
		
		private CaseJoueur joueur;
		
		/**
		 * un plateau est créer. il contient un chemin de {@link Dalle}, une
		 * {@link DalleDepart}, une {@link DalleArrivée} et des {@link Mur}.
		 */
		public Plateau()
			{
				this.cases = new Case[NOMBRE_CASES_VERTICAL_LABYRINTHE][NOMBRE_CASES_HORIZONTAL_LABYRINTHE];
				labyrinthGenerator();			
			}
		/**
		 * génère un Labyrinth de {@link Case}
		 */
		public void labyrinthGenerator()
		{
			for (int indiceCasesVertical = 0; indiceCasesVertical < NOMBRE_CASES_VERTICAL_LABYRINTHE; indiceCasesVertical++)
				{
					for (int indicesCasesHorizontal = 0; indicesCasesHorizontal < NOMBRE_CASES_HORIZONTAL_LABYRINTHE; indicesCasesHorizontal++)
						{
							if (indicesCasesHorizontal == 5)
								{
									switch (indiceCasesVertical)
										{
										case 0:
											{
												joueur = new CaseJoueur(indiceCasesVertical, indicesCasesHorizontal);
												this.cases[indiceCasesVertical][indicesCasesHorizontal] = joueur;
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
							else if(indiceCasesVertical == 2)
								{
									this.cases[indiceCasesVertical][indicesCasesHorizontal] = new Dalle();
								}

							else
								{
									this.cases[indiceCasesVertical][indicesCasesHorizontal] = new Mur();
								}
						}
				}

			
		}
	

		/**
		 * deplacement de la {@link CaseJoueur} vers le bas du {@link Plateau}
		 * exceptions pour le déplacement sur une {@link DalleArrivée}
		 */
		// TODO réflechir a une methode d'esceptions pour la case d'arrivee
		public void deplacementVersLeBas()
			{
				int positionVerticalDuJoueur = this.joueur.donnePositionVertical();
				int positionHorizontalDuJoueur = this.joueur.donnePositionHorizontal();

				Case c = cases[positionVerticalDuJoueur + 1][positionHorizontalDuJoueur];
				if (c.estAccessible() 
				
						if (positionVerticalDuJoueur + 1 < NOMBRE_CASES_VERTICAL_LABYRINTHE)
					{
						if (((Dalle)cases[positionVerticalDuJoueur + 1][positionHorizontalDuJoueur]).estUneArrivee())

							{
								this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = new Dalle();
								this.joueur.determinePositionHorizontal(positionVerticalDuJoueur + 1);
							}

						else if (this.cases[positionVerticalDuJoueur + 1][positionHorizontalDuJoueur].estAccessible())

							{
								this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = this.cases[positionVerticalDuJoueur + 1][positionHorizontalDuJoueur];
								this.cases[positionVerticalDuJoueur + 1][positionHorizontalDuJoueur] = this.joueur;
								this.joueur.determinePositionVertical(positionVerticalDuJoueur + 1);
							}

					}
			}

		/**
		 * deplacement de la {@link CaseJoueur} vers le haut du {@link Plateau}
		 * exceptions pour le déplacement sur une {@link DalleArrivée}
		 */
		public void deplacementVersLeHaut()
			{
				int positionVerticalDuJoueur = this.joueur.donnePositionVertical();
				int positionHorizontalDuJoueur = this.joueur.donnePositionHorizontal();

				if (positionVerticalDuJoueur - 1 >= 0)
					{
						if (this.cases[positionVerticalDuJoueur - 1][positionHorizontalDuJoueur] instanceof DalleArrivée)

							{
								this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = new Dalle();
								this.joueur.determinePositionHorizontal(positionVerticalDuJoueur - 1);
							}

						else if (this.cases[positionVerticalDuJoueur - 1][positionHorizontalDuJoueur].estAccessible())

							{
								this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = this.cases[positionVerticalDuJoueur + 1][positionHorizontalDuJoueur];
								this.cases[positionVerticalDuJoueur - 1][positionHorizontalDuJoueur] = this.joueur;
								this.joueur.determinePositionVertical(positionVerticalDuJoueur - 1);
							}
					}
			}

		/**
		 * Déplace la {@link CaseJoueur} sur la gauche du {@link Plateau}.
		 * exceptions pour le déplacement sur une {@link DalleArrivée}
		 */
		public void deplacementVersLaGauche()
			{
				int positionVerticalDuJoueur = this.joueur.donnePositionVertical();
				int positionHorizontalDuJoueur = this.joueur.donnePositionHorizontal();

				if (positionHorizontalDuJoueur - 1 >= 0)
					{
						if (this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1] instanceof DalleArrivée)

							{
								this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = new Dalle();
								this.joueur.determinePositionHorizontal(positionHorizontalDuJoueur - 1);
							} else if (this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1].estAccessible())
							{
								this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1];
								this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1] = this.joueur;
								this.joueur.determinePositionHorizontal(positionHorizontalDuJoueur - 1);
							}

					}

			}

		/**
		 * Déplace la {@link CaseJoueur} vers la droite du {@link Plateau}.
		 * exceptions pour le déplacement sur une {@link DalleArrivée}
		 */
		public void deplacementVersLaDroite()
			{
				int positionVerticalDuJoueur = this.joueur.donnePositionVertical();
				int positionHorizontalDuJoueur = this.joueur.donnePositionHorizontal();

				if (positionHorizontalDuJoueur + 1 < NOMBRE_CASES_HORIZONTAL_LABYRINTHE)
					{
						if (this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1] instanceof DalleArrivée)

							{
								this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = new Dalle();
								this.joueur.determinePositionHorizontal(positionHorizontalDuJoueur + 1);
							} else if (this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1].estAccessible())

							{
								this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1];
								this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1] = this.joueur;
								this.joueur.determinePositionHorizontal(positionHorizontalDuJoueur + 1);
							}

					}

			}
		@Override
		public String toString()
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
