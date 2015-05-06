package fr.iutvalence.pandemonium.labyrinth;

public class Partie
	{
		/**
		 * plateau de jeu
		 */
		private Plateau plateau;
		/**
		 * compteur de nombre de tour.
		 */
		private int nombreDeTours;
		/**
		 * test si la case suivante est la {@link DalleArrivée}.
		 * 
		 * @return true si la {@link Case} est une {@link DalleArrivée}, sinon
		 *         false.
		 */
		private CaseJoueur joueur;

		/**
		 * renvoie le joueur de la partie.
		 * 
		 * @return
		 */
		public CaseJoueur DonneJoueur()
			{
				return joueur;
			}

		/**
		 * test si la case est la {@link DalleArrivée}.
		 * 
		 * @return true si la {@link Case} est une {@link DalleArrivée}, sinon
		 *         false.
		 */
		public boolean estArrivée()
			{
				return false;
			}

		/**
		 * création d'une partie. constituer {@link Plateau}, un
		 * {@link CaseJoueur} et un ombre de tour initialiser a zéro elle
		 * initialise la {@link CaseJoueur} sur la {@link DalleDepart}.
		 */
		public Partie()
			{
				this.plateau = new Plateau();
				this.nombreDeTours = 0;

				for (int indicesCasesHorizontal = 0; indicesCasesHorizontal < plateau.NOMBRE_CASES_HORIZONTAL_LABYRINTHE; indicesCasesHorizontal++)
					{
						for (int indiceCasesVerticale = 0; indiceCasesVerticale < plateau.NOMBRE_CASES_VERTICAL_LABYRINTHE; indiceCasesVerticale++)
							{
								if (this.plateau.cases[indiceCasesVerticale][indicesCasesHorizontal] instanceof DalleDepart)
									{
										this.joueur = new CaseJoueur(indiceCasesVerticale, indicesCasesHorizontal);
										this.plateau.cases[indiceCasesVerticale][indicesCasesHorizontal] = this.joueur;
									}
							}
					}
			}

		/**
		 * deplacement de la {@link CaseJoueur} vers le bas du {@link Plateau}
		 */
		public void deplacementVersLeBas()
			{
				int positionVerticalDuJoueur = this.joueur.donnePositionVertical();
				int positionHorizontalDuJoueur = this.joueur.donnePositionHorizontal();

				if (positionVerticalDuJoueur + 1 < plateau.NOMBRE_CASES_VERTICAL_LABYRINTHE)
					{
						if (this.plateau.cases[positionVerticalDuJoueur + 1][positionHorizontalDuJoueur] instanceof DalleArrivée)

							{
								this.plateau.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = new Dalle();
								this.joueur.determinePositionHorizontal(positionVerticalDuJoueur + 1);
								this.nombreDeTours += 1;
							}
						
						
					else if (this.plateau.cases[positionVerticalDuJoueur + 1][positionHorizontalDuJoueur].estAccessible())
					
						{
							this.plateau.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = this.plateau.cases[positionVerticalDuJoueur + 1][positionHorizontalDuJoueur];
							this.plateau.cases[positionVerticalDuJoueur + 1][positionHorizontalDuJoueur] = this.joueur;
							this.joueur.determinePositionVertical(positionVerticalDuJoueur + 1);
							this.nombreDeTours += 1;
						}
					}
			}

		/**
		 * deplacement de la {@link CaseJoueur} vers le haut du {@link Plateau}
		 */
		public void deplacementVersLeHaut()
			{
				int positionVerticalDuJoueur = this.joueur.donnePositionVertical();
				int positionHorizontalDuJoueur = this.joueur.donnePositionHorizontal();

				if (positionVerticalDuJoueur - 1 >= 0)
					{
						if (this.plateau.cases[positionVerticalDuJoueur - 1][positionHorizontalDuJoueur] instanceof DalleArrivée)

							{
								this.plateau.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = new Dalle();
								this.joueur.determinePositionHorizontal(positionVerticalDuJoueur - 1);
							}

						else if (this.plateau.cases[positionVerticalDuJoueur - 1][positionHorizontalDuJoueur].estAccessible())

							{
								this.plateau.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = this.plateau.cases[positionVerticalDuJoueur + 1][positionHorizontalDuJoueur];
								this.plateau.cases[positionVerticalDuJoueur - 1][positionHorizontalDuJoueur] = this.joueur;
								this.joueur.determinePositionVertical(positionVerticalDuJoueur - 1);
								this.nombreDeTours += 1;
							}
					}
			}

		/**
		 * Déplace la {@link CaseJoueur} sur la gauche du {@link Plateau}.
		 */
		public void deplacementVersLaGauche()
			{
				int positionVerticalDuJoueur = this.joueur.donnePositionVertical();
				int positionHorizontalDuJoueur = this.joueur.donnePositionHorizontal();

				if (positionHorizontalDuJoueur - 1 >= 0)
					{
						if (this.plateau.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1] instanceof DalleArrivée)

							{
								this.plateau.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = new Dalle();
								this.joueur.determinePositionHorizontal(positionHorizontalDuJoueur - 1);
								this.nombreDeTours += 1;
							} else if (this.plateau.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1].estAccessible())
							{
								this.plateau.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = this.plateau.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1];
								this.plateau.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1] = this.joueur;
								this.joueur.determinePositionHorizontal(positionHorizontalDuJoueur - 1);
							}

					}

			}

		/**
		 * Déplace la {@link CaseJoueur} vers la droite du {@link Plateau}.
		 */
		public void deplacementVersLaDroite()
			{
				int positionVerticalDuJoueur = this.joueur.donnePositionVertical();
				int positionHorizontalDuJoueur = this.joueur.donnePositionHorizontal();

				if (positionHorizontalDuJoueur + 1 < this.plateau.NOMBRE_CASES_HORIZONTAL_LABYRINTHE)
					{
						if (this.plateau.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1] instanceof DalleArrivée)

							{
								this.plateau.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = new Dalle();
								this.joueur.determinePositionHorizontal(positionHorizontalDuJoueur + 1);
								this.nombreDeTours += 1;
							} else if (this.plateau.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1].estAccessible())

							{
								this.plateau.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur] = this.plateau.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1];
								this.plateau.cases[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1] = this.joueur;
								this.joueur.determinePositionHorizontal(positionHorizontalDuJoueur + 1);
							}

					}

			}

		/**
		 * chaque tour, le joueur choisit la direction de son prochain
		 * deplacement.
		 * 
		 * @param choixJoueur
		 * @return
		 */
		public void choixJoueurParTour(int choixJoueur)
			{
				int positionVerticalDuJoueur = joueur.donnePositionVertical();
				int positionHorizontalDuJoueur = joueur.donnePositionVertical();

				switch (choixJoueur)
					{
					case 1:
						{
							deplacementVersLeBas();
							break;
						}
					case 2:
						{
							deplacementVersLeHaut();
							break;
						}
					case 3:
						{
							deplacementVersLaDroite();
							break;
						}
					case 4:
						{
							deplacementVersLaGauche();
							break;
						}
					}
			}

		/**
		 * Est le test de victoire.
		 * 
		 * @param positionVerticaleDuJoueur
		 * @param positionHorizontalDuJoueur
		 * @return
		 */
		public boolean leJoueurNEstPasArrivee(int positionVerticaleDuJoueur, int positionHorizontalDuJoueur)
			{
				if (this.plateau.cases[positionVerticaleDuJoueur][positionHorizontalDuJoueur] instanceof DalleArrivée)
					return false;
				return true;
			}

		/**
		 * affiche la {@link Partie} en cours
		 * 
		 * @return plateau
		 */
		public String afficherPartie()
			{
				String partie = "";
				partie += "tour:";
				partie += this.nombreDeTours;
				partie += "\n";
				partie += this.plateau.affichePlateau();
				return partie;
			}

	}
