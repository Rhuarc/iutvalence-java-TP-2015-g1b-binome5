package fr.iutvalence.pandemonium.labyrinth;
import java.util.Scanner;
/**
 * l'application servant a jouer au labyrinthe
 * 
 * @author Eymeric
 *
 */
public class AppliTest
{
		/**
		 * la partie qui est jouer par {@link AppliTest}
		 */

		public static void main(String[] args)
			{
				Scanner monScanner = new Scanner(System.in);
				Partie maPartie = new Partie();
				boolean joueurEstArrivee = maPartie.leJoueurNEstPasArrivee(maPartie.DonneJoueur().donnePositionVertical(), maPartie.DonneJoueur().donnePositionHorizontal());
				System.out.println(maPartie.afficherPartie());
				System.out.println("pour vous déplacer : \n 1 -> bas \n 2 -> haut \n 3 -> gauche \n 4 -> haut");
				while(joueurEstArrivee)
					{
						int ChoixJoueur = monScanner.nextInt();
						maPartie.choixJoueurParTour(ChoixJoueur);
						System.out.println(maPartie.afficherPartie());
					}
				System.out.println("GG WP");

			}


	

}

