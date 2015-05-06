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
		private Case[][] cases;

		private CaseJoueur joueur;

		private DalleArrivée arrivee;

		/**
		 * un plateau est créer. il contient un chemin de {@link Dalle}, une
		 * {@link DalleDepart}, une {@link DalleArrivée} et des {@link Mur}.
		 */
		public Plateau()
			{
				this.cases = new Case[NOMBRE_CASES_VERTICAL_LABYRINTHE][NOMBRE_CASES_HORIZONTAL_LABYRINTHE];
				labyrinthGenerator();

			}

		public CaseJoueur getJoueur()
			{
				return this.joueur;
			}

		public DalleArrivée getArrivee()
			{
				return this.arrivee;
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
													this.joueur = new CaseJoueur(indiceCasesVertical, indicesCasesHorizontal);
													this.cases[indiceCasesVertical][indicesCasesHorizontal] = this.joueur;
													break;
												}
											case NOMBRE_CASES_VERTICAL_LABYRINTHE - 1:
												{
													this.arrivee = new DalleArrivée(indiceCasesVertical, indicesCasesHorizontal);
													this.cases[indiceCasesVertical][indicesCasesHorizontal] = this.arrivee;
													break;
												}
											default:
												{
													this.cases[indiceCasesVertical][indicesCasesHorizontal] = new Dalle(indiceCasesVertical, indicesCasesHorizontal);
												}
											}
									} else if (indiceCasesVertical == 2)
									{
										this.cases[indiceCasesVertical][indicesCasesHorizontal] = new Dalle(indiceCasesVertical, indicesCasesHorizontal);
									}

								else
									{
										this.cases[indiceCasesVertical][indicesCasesHorizontal] = new Mur(indiceCasesVertical, indicesCasesHorizontal);
									}
							}
					}

			}

		/**
		 * deplacement de la {@link CaseJoueur} vers le bas du {@link Plateau}
		 * exceptions pour le déplacement sur une {@link DalleArrivée}
		 */
		// TODO réflechir a une methode d'esceptions pour la case d'arrivee.
		public void deplacementVersLeBas()
			{
				int positionVerticalDuJoueur = this.joueur.getPositionVertical();
				int positionHorizontalDuJoueur = this.joueur.getPositionHorizontal();
				
				Case nextCase = this.cases[positionVerticalDuJoueur + 1][positionHorizontalDuJoueur];
				if (positionVerticalDuJoueur + 1 < NOMBRE_CASES_VERTICAL_LABYRINTHE)
					{

						if (nextCase.estAccessible())
							{
								if (((Dalle) nextCase).estUneArrivee())

									{
										new Dalle(positionVerticalDuJoueur, positionHorizontalDuJoueur);
										nextCase = this.joueur;
										this.joueur.setPositionHorizontal(positionVerticalDuJoueur + 1);
									}

								else

									{	
										this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = nextCase;
										nextCase = this.joueur;
										this.joueur.setPositionVertical(positionVerticalDuJoueur + 1);
									}

							}
					}
			}

		/**
		 * deplacement de la {@link CaseJoueur} vers le haut du {@link Plateau}
		 * exceptions pour le déplacement sur une {@link DalleArrivée}
		 */
		public void deplacementVersLeHaut()
			{
				int positionVerticalDuJoueur = this.joueur.getPositionVertical();
				int positionHorizontalDuJoueur = this.joueur.getPositionHorizontal();

				Case nextCase = this.cases[positionVerticalDuJoueur - 1][positionHorizontalDuJoueur];
				if (positionVerticalDuJoueur - 1 >= 0)
					{
						if (nextCase.estAccessible())
							{
								if (((Dalle) nextCase).estUneArrivee())

									{
										new Dalle(positionVerticalDuJoueur, positionHorizontalDuJoueur);
										this.joueur.setPositionHorizontal(positionVerticalDuJoueur - 1);
										nextCase = this.joueur;
									}

								else

									{
										nextCase = this.joueur;
										this.joueur.setPositionVertical(positionVerticalDuJoueur - 1);
									}
							}
					}
			}

		/**
		 * Déplace la {@link CaseJoueur} sur la gauche du {@link Plateau}.
		 * exceptions pour le déplacement sur une {@link DalleArrivée}
		 */
		public void deplacementVersLaGauche()
			{
				int positionVerticalDuJoueur = this.joueur.getPositionVertical();
				int positionHorizontalDuJoueur = this.joueur.getPositionHorizontal();
				Case nextCase = this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1];
				if (positionHorizontalDuJoueur - 1 >= 0)
					{
						if (nextCase.estAccessible())
							{
								if (((Dalle) nextCase).estUneArrivee())

									{
										new Dalle(positionVerticalDuJoueur, positionHorizontalDuJoueur);
										nextCase = this.joueur;
										this.joueur.setPositionHorizontal(positionHorizontalDuJoueur - 1);
									} else
									{
										nextCase = this.joueur;
										this.joueur.setPositionHorizontal(positionHorizontalDuJoueur - 1);
									}

							}
					}

			}

		/**
		 * Déplace la {@link CaseJoueur} vers la droite du {@link Plateau}.
		 * exceptions pour le déplacement sur une {@link DalleArrivée}
		 */
		public void deplacementVersLaDroite()
			{
				int positionVerticalDuJoueur = this.joueur.getPositionVertical();
				int positionHorizontalDuJoueur = this.joueur.getPositionHorizontal();
				Case nextCase = this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1];
				if (positionHorizontalDuJoueur + 1 < NOMBRE_CASES_HORIZONTAL_LABYRINTHE)
					{
						if (nextCase.estAccessible())
							{
								if (((Dalle) nextCase).estUneArrivee())

									{
										new Dalle(positionVerticalDuJoueur, positionVerticalDuJoueur);
										nextCase = this.joueur;
										this.joueur.setPositionHorizontal(positionHorizontalDuJoueur + 1);
									} else

									{
										nextCase = this.joueur;
										this.joueur.setPositionHorizontal(positionHorizontalDuJoueur + 1);
									}

							}
					}

			}

		public boolean finished(int positionVerticaleJoueur, int positionHorizontaleJoueur)
			{
				if (this.arrivee.getPositionVertical() == positionVerticaleJoueur && this.arrivee.getPositionHorizontal() == positionHorizontaleJoueur)
					{
						return true;
					} else
					return false;

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
