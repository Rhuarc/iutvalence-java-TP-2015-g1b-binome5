package fr.iutvalence.pandemonium.labyrinth;

/* TODO Pourquoi Case est abstraite et non une interface ? */

/**
 * Case du labyrinthe.
 * <p>
 * Par défaut, les cases sont inaccessibles (donc des {@link Mur}).
 *
 * @author chenavie
 * @version TODO
 */
public abstract class Case {
    /** Par défaut, une Case est inaccessible. */
    public boolean estAccessible() {
        return false;
    }
}
