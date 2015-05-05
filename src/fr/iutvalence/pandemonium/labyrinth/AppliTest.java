package fr.iutvalence.pandemonium.labyrinth;

public class AppliTest
	{

		public static void main(String[] args)
			{
				Partie maPartie = new Partie();
				System.out.println(maPartie.afficherPartie());
				maPartie.deplacementVersLeBas();
				System.out.println(maPartie.afficherPartie());
				maPartie.deplacementVersLeBas();
				System.out.println(maPartie.afficherPartie());
				maPartie.deplacementVersLeHaut();
				System.out.println(maPartie.afficherPartie());
				maPartie.deplacementVersLeHaut();
				System.out.println(maPartie.afficherPartie());
			}

	}
