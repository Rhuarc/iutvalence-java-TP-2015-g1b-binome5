package fr.iutvalence.pandemonium.labyrinth;

public class Partie
	{
	public final static int NOMBRE_CASES_HORIZONTAL_LABYRINTHE = 10;
	public final static int NOMBRE_CASES_VERTICAL_LABYRINTHE = 10;
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
	private Joueur joueur;

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
	 * création d'une partie. constituer {@link Plateau}, un {@link Joueur} et
	 * un ombre de tour initialiser a zéro
	 */
	public Partie()
		{
			this.plateau = new Plateau();
			this.nombreDeTours = 0;

			for (int indicesCasesHorizontal = 0; indicesCasesHorizontal < NOMBRE_CASES_HORIZONTAL_LABYRINTHE; indicesCasesHorizontal++)
				{
					for (int indiceCasesVerticale = 0; indiceCasesVerticale < NOMBRE_CASES_VERTICAL_LABYRINTHE; indiceCasesVerticale++)
						{
							if (this.plateau.cases[indiceCasesVerticale][indicesCasesHorizontal] instanceof DalleDepart)
								{
									this.joueur = new Joueur(
											indiceCasesVerticale,
											indicesCasesHorizontal);

								}
						}
				}
		}
	/**
	 * affiche la {@link Partie} en cours
	 * @return plateau
	 */
	public String afficherPartie()
		{ String partie = "";
			partie +="tour:";
			partie += this.nombreDeTours;
			partie += "\n";
			partie += this.plateau.affichePlateau();
			return partie;
		}

	}
