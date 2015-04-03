package fr.iutvalence.pandemonium.labyrinth;

/**
 * Un mur de notre Labyrinthe.
 *
 * @author Eymeric
 * @version TODO
 */
public class Mur extends Case {
    /* TODO toString peut judicieux… Utilisez le pour la génération de l'affichage textuel du labyrinthe. */
    @Override
    public String toString() {
        return "Mur [estAccessible()=" + estAccessible() + ']';
    }
}
