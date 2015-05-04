package fr.iutvalence.pandemonium.labyrinth;

/**
 * joueur qui se déplace dans le labyrinth
 * 
 * @author Eymeric
 *
 */
public class Joueur
	{
	/**
	 * position Vertical du joueur
	 */
	private int positionVertical;
	/**
	 * position Horizontal du joueur sur le plateau
	 */
	private int positionHorizontal;

	public Joueur(int positionInitialeVerticale, int positionInitialeHorizontal)
		{
			this.positionVertical = positionInitialeVerticale;

			this.positionHorizontal = positionInitialeHorizontal;
		}

	}
