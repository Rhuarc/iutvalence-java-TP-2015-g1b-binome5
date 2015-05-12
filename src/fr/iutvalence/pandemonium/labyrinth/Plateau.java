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
		private Box[][] cases;

		private PlayerBox joueur;

		private DalleArrivée arrivee;

		/**
		 * un plateau est créer. il contient un chemin de {@link Slab}, une
		 * {@link DalleDepart}, une {@link DalleArrivée} et des {@link Mur}.
		 */
		public Plateau()
			{
				this.cases = new Box[NOMBRE_CASES_VERTICAL_LABYRINTHE][NOMBRE_CASES_HORIZONTAL_LABYRINTHE];
				labyrinthGenerator();

			}

		public PlayerBox getJoueur()
			{
				return this.joueur;
			}

		public DalleArrivée getArrivee()
			{
				return this.arrivee;
			}

		/**
		 * génère un Labyrinth de {@link Box}
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
													this.joueur = new PlayerBox(indiceCasesVertical, indicesCasesHorizontal);
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
													this.cases[indiceCasesVertical][indicesCasesHorizontal] = new Slab(indiceCasesVertical, indicesCasesHorizontal);
												}
											}
									} else if (indiceCasesVertical == 2)
									{
										this.cases[indiceCasesVertical][indicesCasesHorizontal] = new Slab(indiceCasesVertical, indicesCasesHorizontal);
									}

								else
									{
										this.cases[indiceCasesVertical][indicesCasesHorizontal] = new Mur(indiceCasesVertical, indicesCasesHorizontal);
									}
							}
					}

			}

		/**
		 * deplacement de la {@link PlayerBox} vers le bas du {@link Plateau}
		 * exceptions pour le déplacement sur une {@link DalleArrivée}
		 */
		public void deplacementVersLeBas()
			{
				int positionVerticalDuJoueur = this.joueur.getPositionVertical();
				int positionHorizontalDuJoueur = this.joueur.getPositionHorizontal();

				if (positionVerticalDuJoueur + 1 < NOMBRE_CASES_VERTICAL_LABYRINTHE)
					{

						if (this.cases[positionVerticalDuJoueur + 1][positionHorizontalDuJoueur].isAvailable())
							{
								if (((Slab) this.cases[positionVerticalDuJoueur + 1][positionHorizontalDuJoueur]).isAnArrival())

									{
										this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = new Slab(positionVerticalDuJoueur, positionHorizontalDuJoueur);
										this.cases[positionVerticalDuJoueur + 1][positionHorizontalDuJoueur] = this.joueur;
										this.joueur.setPositionVertical(positionVerticalDuJoueur + 1);
									}

								else

									{
										this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur].setPositionVertical(positionVerticalDuJoueur);
										this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = this.cases[positionVerticalDuJoueur + 1][positionHorizontalDuJoueur];
										this.cases[positionVerticalDuJoueur + 1][positionHorizontalDuJoueur] = this.joueur;
										this.joueur.setPositionVertical(positionVerticalDuJoueur + 1);
									}

							}
					}
			}

		/**
		 * deplacement de la {@link PlayerBox} vers le haut du {@link Plateau}
		 * exceptions pour le déplacement sur une {@link DalleArrivée}
		 */
		public void deplacementVersLeHaut()
			{
				int positionVerticalDuJoueur = this.joueur.getPositionVertical();
				int positionHorizontalDuJoueur = this.joueur.getPositionHorizontal();

				if (positionVerticalDuJoueur - 1 >= 0)
					{
						if (this.cases[positionVerticalDuJoueur - 1][positionHorizontalDuJoueur].isAvailable())
							{
								if (((Slab) this.cases[positionVerticalDuJoueur - 1][positionHorizontalDuJoueur]).isAnArrival())

									{
										this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = new Slab(positionVerticalDuJoueur, positionHorizontalDuJoueur);
										this.joueur.setPositionVertical(positionVerticalDuJoueur - 1);
										this.cases[positionVerticalDuJoueur - 1][positionHorizontalDuJoueur] = this.joueur;
									}

								else

									{	this.cases[positionVerticalDuJoueur - 1][positionHorizontalDuJoueur].setPositionVertical(positionVerticalDuJoueur);
										this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = this.cases[positionVerticalDuJoueur - 1][positionHorizontalDuJoueur];
										this.cases[positionVerticalDuJoueur - 1][positionHorizontalDuJoueur] = this.joueur;
										this.joueur.setPositionVertical(positionVerticalDuJoueur - 1);
									}
							}
					}
			}

		/**
		 * Déplace la {@link PlayerBox} sur la gauche du {@link Plateau}.
		 * exceptions pour le déplacement sur une {@link DalleArrivée}
		 */
		public void deplacementVersLaGauche()
			{
				int positionVerticalDuJoueur = this.joueur.getPositionVertical();
				int positionHorizontalDuJoueur = this.joueur.getPositionHorizontal();
				
				if (positionHorizontalDuJoueur - 1 >= 0)
					{
						if (this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1].isAvailable())
							{
								if (((Slab) this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1]).isAnArrival())

									{
										this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = new Slab(positionVerticalDuJoueur, positionHorizontalDuJoueur);
										this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1] = this.joueur;
										this.joueur.setPositionHorizontal(positionHorizontalDuJoueur - 1);
									} else
									{
										this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1].setPositionVertical(positionHorizontalDuJoueur);
										this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1];
										this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1] = this.joueur;
										this.joueur.setPositionHorizontal(positionHorizontalDuJoueur - 1);
									}

							}
					}

			}

		/**
		 * Déplace la {@link PlayerBox} vers la droite du {@link Plateau}.
		 * exceptions pour le déplacement sur une {@link DalleArrivée}
		 */
		public void deplacementVersLaDroite()
			{
				int positionVerticalDuJoueur = this.joueur.getPositionVertical();
				int positionHorizontalDuJoueur = this.joueur.getPositionHorizontal();
				if (positionHorizontalDuJoueur + 1 < NOMBRE_CASES_HORIZONTAL_LABYRINTHE)
					{
						if (this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1].isAvailable())
							{
								if (((Slab) this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1]).isAnArrival())

									{
										this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = new Slab(positionVerticalDuJoueur, positionVerticalDuJoueur);
										this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1] = this.joueur;
										this.joueur.setPositionHorizontal(positionHorizontalDuJoueur + 1);
									} else

									{
										this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1].setPositionHorizontal(positionHorizontalDuJoueur);
										this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1];
										this.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1] = this.joueur;
										this.joueur.setPositionHorizontal(positionHorizontalDuJoueur + 1);
									}

							}
					}

			}

		public boolean finished(int positionVerticaleJoueur, int positionHorizontaleJoueur)
			{
				System.err.printf("%d == %d && %d == %d", this.arrivee.getPositionVertical(), positionVerticaleJoueur, this.arrivee.getPositionHorizontal(), positionHorizontaleJoueur);
				return (this.arrivee.getPositionVertical() == positionVerticaleJoueur && this.arrivee.getPositionHorizontal() == positionHorizontaleJoueur);
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
