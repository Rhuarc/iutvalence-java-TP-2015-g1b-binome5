package fr.iutvalence.pandemonium.labyrinth;

/* TODO JAVADOC. */
public class AppliTest {
    /* TODO JAVADOC. */
    public static void main(String[] args) {
        DalleBasique maDalle = new DalleBasique();
        DalleDeDepart maDalleDeDepart = new DalleDeDepart();
        Mur monMur = new Mur();
        System.out.println(maDalle.estAccessible());
    }
}
