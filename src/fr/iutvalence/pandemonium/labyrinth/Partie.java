package fr.iutvalence.pandemonium.labyrinth;

import java.util.Scanner;

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
		 * création d'une partie. constituer {@link Plateau}, une
		 * {@link CaseJoueur} et un nombre de tour initialiser a zéro elle
		 * initialise la {@link CaseJoueur} sur la {@link DalleDepart}.
		 */
		public Partie()
			{
				this.plateau = new Plateau();
				this.nombreDeTours = 0;
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
				switch (choixJoueur)
					{
					case 1:
						{
							this.plateau.deplacementVersLeBas();
							break;
						}
					case 2:
						{
							this.plateau.deplacementVersLeHaut();
							break;
						}
					case 3:
						{
							this.plateau.deplacementVersLaDroite();
							break;
						}
					case 4:
						{
							this.plateau.deplacementVersLaGauche();
							break;
						}
					default:
						// TODO Exception
						break;
					}
			}

		@Override
		public String toString()
			{
				String partie = "";
				partie += "tour:";
				partie += this.nombreDeTours;
				partie += "\n";
				partie += this.plateau;
				return partie;
			}

		public void start()
			{	CaseJoueur joueur = this.plateau.getJoueur();
				@SuppressWarnings("resource")
				Scanner monScanner = new Scanner(System.in);
				System.out.println(this);
				System.out.println("pour vous déplacer : \n 1 -> bas \n 2 -> haut \n 3 -> gauche \n 4 -> haut");
				while (!this.plateau.finished(joueur.getPositionVertical(), joueur.getPositionHorizontal()))
					{
						int ChoixJoueur = monScanner.nextInt();
						this.nombreDeTours++;
						choixJoueurParTour(ChoixJoueur);
						System.out.println(toString());
					}
				System.out.println("GG WP");
			}

	}
