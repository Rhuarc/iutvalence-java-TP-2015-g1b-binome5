package fr.iutvalence.pandemonium.labyrinth;

import java.util.Scanner;

public class Game
	{
		/**
		 * plateau de jeu
		 */
		private Board board;
		/**
		 * compteur de nombre de tour.
		 */
		private int numberTurns;

		/**
		 * création d'une partie. constituer {@link Board}, une
		 * {@link PlayerBox} et un nombre de tour initialiser a zéro elle
		 * initialise la {@link PlayerBox} sur la {@link DalleDepart}.
		 */
		public Game()
			{
				this.board = new Board();
				this.numberTurns = 0;
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
							this.board.deplacementVersLeBas();
							break;
						}
					case 2:
						{
							this.board.deplacementVersLeHaut();
							break;
						}
					case 3:
						{
							this.board.deplacementVersLaDroite();
							break;
						}
					case 4:
						{
							this.board.deplacementVersLaGauche();
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
				partie += this.numberTurns;
				partie += "\n";
				partie += this.board;
				return partie;
			}

		public void start()
			{	PlayerBox joueur = this.board.getJoueur();
				@SuppressWarnings("resource")
				Scanner monScanner = new Scanner(System.in);
				System.out.println(this);
				System.out.println("pour vous déplacer : \n 1 -> bas \n 2 -> haut \n 3 -> Droite \n 4 -> Gauche");
				while (!this.board.finished(joueur.getPositionVertical(), joueur.getPositionHorizontal()))
					{
						int ChoixJoueur = monScanner.nextInt();
						this.numberTurns++;
						choixJoueurParTour(ChoixJoueur);
						System.out.println(toString());
					}
				System.out.println("WINN");
			}

	}
