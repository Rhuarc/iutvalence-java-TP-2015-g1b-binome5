package fr.iutvalence.pandemonium.labyrinth;

/**
 * Une dalle abstraite.
 * TODO Compléter la javadoc en situant (conceptuellement) Dalle par rapport à Case.
 *
 * @author chenavie.
 * @version TODO
 */
public abstract class Dalle extends Case {
    /** Par défaut, une dalle n'est pas une arrivée. */
    public boolean estUneArrivee() {
        return false;
    }

    /** Par défaut, une dalle n'est pas un départ. */
    public boolean estUnDepart() {
        return false;
    }

    /** Une Dalle est une Case accessible. */
    @Override
    public boolean estAccessible() {
        return true;
    }
}
