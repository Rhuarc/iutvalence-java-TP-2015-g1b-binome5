package fr.iutvalence.pandemonium.labyrinth;

/**
 * Dalle qui sert de départ au joueur.
 *
 * @author Eymeric
 * @version TODO
 */
public class DalleDeDepart extends Dalle {
    /** Dalle de départ. */
    @Override
    public boolean estUnDepart() {
        return true;
    }

    /* TODO toString peut judicieux… Utilisez le pour la génération de l'affichage textuel du labyrinthe. */
    @Override
    public String toString() {
        return "DalleDeDépart [estAccessible()=" + estAccessible() + ", estUnDepart()=" + estUnDepart() + ", estUneArrivee()=" + estUneArrivee() + ']';
    }
}
