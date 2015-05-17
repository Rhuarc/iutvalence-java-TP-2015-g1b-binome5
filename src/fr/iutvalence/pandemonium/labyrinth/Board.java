package fr.iutvalence.pandemonium.labyrinth;

/**
 * Plateau de jeu contenant notre Labyrinthe.
 * 
 * @author Eymeric
 *
 */
public class Board
	{
		public final static int NUMBER_HORIZONTAL_BOX_LABYRINTH = 10;
		public final static int NUMBER_VERTICAL_BOX_LABYRINTH = 10;
		/** Le Plateau est un tableaux de Case a deux dimensions. */
		private AbstractBox[][] boxs;

		private PlayerBox player;

		private ArrivalSlab arrival;

		/**
		 * un plateau est créer. il contient un chemin de {@link Slab}, une
		 * {@link DalleDepart}, une {@link ArrivalSlab} et des {@link Wall}.
		 */
		public Board()
			{
				this.boxs = new AbstractBox[NUMBER_VERTICAL_BOX_LABYRINTH][NUMBER_HORIZONTAL_BOX_LABYRINTH];
				labyrinthGenerator();

			}

		public PlayerBox getJoueur()
			{
				return this.player;
			}

		public ArrivalSlab getArrivee()
			{
				return this.arrival;
			}

		/**
		 * génère un Labyrinth de {@link AbstractBox}
		 */
		public void labyrinthGenerator()
			{
				for (int boxIndexVertical = 0; boxIndexVertical < NUMBER_VERTICAL_BOX_LABYRINTH; boxIndexVertical++)
					{
						for (int boxIndexHorizontal = 0; boxIndexHorizontal < NUMBER_HORIZONTAL_BOX_LABYRINTH; boxIndexHorizontal++)
							{
								if (boxIndexHorizontal == 5)
									{
										switch (boxIndexVertical)
											{
											case 0:
												{
													this.player = new PlayerBox(boxIndexVertical, boxIndexHorizontal);
													this.boxs[boxIndexVertical][boxIndexHorizontal] = this.player;
													break;
												}
											case NUMBER_VERTICAL_BOX_LABYRINTH - 1:
												{
													this.arrival = new ArrivalSlab(boxIndexVertical, boxIndexHorizontal);
													this.boxs[boxIndexVertical][boxIndexHorizontal] = this.arrival;
													break;
												}
											default:
												{
													this.boxs[boxIndexVertical][boxIndexHorizontal] = new Slab(boxIndexVertical, boxIndexHorizontal);
												}
											}
									} else if (boxIndexVertical == 2)
									{
										this.boxs[boxIndexVertical][boxIndexHorizontal] = new Slab(boxIndexVertical, boxIndexHorizontal);
									}

								else
									{
										this.boxs[boxIndexVertical][boxIndexHorizontal] = new Wall(boxIndexVertical, boxIndexHorizontal);
									}
							}
					}

			}

		/**
		 * deplacement de la {@link PlayerBox} vers le bas du {@link Board}
		 * exceptions pour le déplacement sur une {@link ArrivalSlab}
		 */
		public void deplacementVersLeBas()
			{
				int playerVerticalPosition = this.player.getPositionVertical();
				int playerHorizontalPosition = this.player.getPositionHorizontal();

				if (playerVerticalPosition + 1 < NUMBER_VERTICAL_BOX_LABYRINTH)
					{

						if (this.boxs[playerVerticalPosition + 1][playerHorizontalPosition].isAvailable())
							{
								if (((Slab) this.boxs[playerVerticalPosition + 1][playerHorizontalPosition]).isAnArrival())

									{
										this.boxs[playerVerticalPosition][playerHorizontalPosition] = new Slab(playerVerticalPosition, playerHorizontalPosition);
										this.boxs[playerVerticalPosition + 1][playerHorizontalPosition] = this.player;
										this.player.setPositionVertical(playerVerticalPosition + 1);
									}

								else

									{
										this.boxs[playerVerticalPosition][playerHorizontalPosition].setPositionVertical(playerVerticalPosition);
										this.boxs[playerVerticalPosition][playerHorizontalPosition] = this.boxs[playerVerticalPosition + 1][playerHorizontalPosition];
										this.boxs[playerVerticalPosition + 1][playerHorizontalPosition] = this.player;
										this.player.setPositionVertical(playerVerticalPosition + 1);
									}

							}
					}
			}

		/**
		 * deplacement de la {@link PlayerBox} vers le haut du {@link Board}
		 * exceptions pour le déplacement sur une {@link ArrivalSlab}
		 */
		public void deplacementVersLeHaut()
			{
				int positionVerticalDuJoueur = this.player.getPositionVertical();
				int positionHorizontalDuJoueur = this.player.getPositionHorizontal();

				if (positionVerticalDuJoueur - 1 >= 0)
					{
						if (this.boxs[positionVerticalDuJoueur - 1][positionHorizontalDuJoueur].isAvailable())
							{
								if (((Slab) this.boxs[positionVerticalDuJoueur - 1][positionHorizontalDuJoueur]).isAnArrival())

									{
										this.boxs[positionVerticalDuJoueur][positionHorizontalDuJoueur] = new Slab(positionVerticalDuJoueur, positionHorizontalDuJoueur);
										this.player.setPositionVertical(positionVerticalDuJoueur - 1);
										this.boxs[positionVerticalDuJoueur - 1][positionHorizontalDuJoueur] = this.player;
									}

								else

									{	this.boxs[positionVerticalDuJoueur - 1][positionHorizontalDuJoueur].setPositionVertical(positionVerticalDuJoueur);
										this.boxs[positionVerticalDuJoueur][positionHorizontalDuJoueur] = this.boxs[positionVerticalDuJoueur - 1][positionHorizontalDuJoueur];
										this.boxs[positionVerticalDuJoueur - 1][positionHorizontalDuJoueur] = this.player;
										this.player.setPositionVertical(positionVerticalDuJoueur - 1);
									}
							}
					}
			}

		/**
		 * Déplace la {@link PlayerBox} sur la gauche du {@link Board}.
		 * exceptions pour le déplacement sur une {@link ArrivalSlab}
		 */
		public void deplacementVersLaGauche()
			{
				int positionVerticalDuJoueur = this.player.getPositionVertical();
				int positionHorizontalDuJoueur = this.player.getPositionHorizontal();
				
				if (positionHorizontalDuJoueur - 1 >= 0)
					{
						if (this.boxs[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1].isAvailable())
							{
								if (((Slab) this.boxs[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1]).isAnArrival())

									{
										this.boxs[positionVerticalDuJoueur][positionHorizontalDuJoueur] = new Slab(positionVerticalDuJoueur, positionHorizontalDuJoueur);
										this.boxs[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1] = this.player;
										this.player.setPositionHorizontal(positionHorizontalDuJoueur - 1);
									} else
									{
										this.boxs[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1].setPositionVertical(positionHorizontalDuJoueur);
										this.boxs[positionVerticalDuJoueur][positionHorizontalDuJoueur] = this.boxs[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1];
										this.boxs[positionVerticalDuJoueur][positionHorizontalDuJoueur - 1] = this.player;
										this.player.setPositionHorizontal(positionHorizontalDuJoueur - 1);
									}

							}
					}

			}

		/**
		 * Déplace la {@link PlayerBox} vers la droite du {@link Board}.
		 * exceptions pour le déplacement sur une {@link ArrivalSlab}
		 */
		public void deplacementVersLaDroite()
			{
				int positionVerticalDuJoueur = this.player.getPositionVertical();
				int positionHorizontalDuJoueur = this.player.getPositionHorizontal();
				if (positionHorizontalDuJoueur + 1 < NUMBER_HORIZONTAL_BOX_LABYRINTH)
					{
						if (this.boxs[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1].isAvailable())
							{
								if (((Slab) this.boxs[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1]).isAnArrival())

									{
										this.boxs[positionVerticalDuJoueur][positionHorizontalDuJoueur] = new Slab(positionVerticalDuJoueur, positionVerticalDuJoueur);
										this.boxs[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1] = this.player;
										this.player.setPositionHorizontal(positionHorizontalDuJoueur + 1);
									} else

									{
										this.boxs[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1].setPositionHorizontal(positionHorizontalDuJoueur);
										this.boxs[positionVerticalDuJoueur][positionHorizontalDuJoueur] = this.boxs[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1];
										this.boxs[positionVerticalDuJoueur][positionHorizontalDuJoueur + 1] = this.player;
										this.player.setPositionHorizontal(positionHorizontalDuJoueur + 1);
									}

							}
					}

			}

		public boolean finished(int positionVerticaleJoueur, int positionHorizontaleJoueur)
			{
				System.err.printf("%d == %d && %d == %d", this.arrival.getPositionVertical(), positionVerticaleJoueur, this.arrival.getPositionHorizontal(), positionHorizontaleJoueur);
				return (this.arrival.getPositionVertical() == positionVerticaleJoueur && this.arrival.getPositionHorizontal() == positionHorizontaleJoueur);
			}

		@Override
		public String toString()
			{
				String PlateauAsciiArt = "";
				for (int numeroCaseVertical = 0; numeroCaseVertical < NUMBER_VERTICAL_BOX_LABYRINTH; numeroCaseVertical++)
					{
						for (int numeroCaseHorizontal = 0; numeroCaseHorizontal < NUMBER_HORIZONTAL_BOX_LABYRINTH; numeroCaseHorizontal++)
							{
								PlateauAsciiArt += this.boxs[numeroCaseVertical][numeroCaseHorizontal];
							}
						PlateauAsciiArt += "\n";

					}
				return PlateauAsciiArt;

			}

	}
