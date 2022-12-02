import java.util.Objects;
/***
 * Classe Case
 * Definie la position de la case sur un echiquier
 */
public class Case {
    private final int posx;
    private final int posy;

    /***
     * Constructeur de Case
     * @param posx position de la case en coordonnée x
     * @param posy position de la case en coordonnée y
     */
    public Case(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
    }

    /***
     * Getter pour la position de la case en coordonnée x
     * @return int
     */
    public int getPosx() {
        return posx;
    }

    /***
     * Getter pour la position de la case en coordonnée y
     * @return int
     */
    public int getPosy() {
        return posy;
    }

    /***
     * Permet d'afficher la position de la case selon ses coordonnées x et y
     * @return String
     */
    @Override
    public String toString() {
        return "{"+ posx +", " + posy +
                '}';
    }

    /***
     * Permet de comparer savoir si l'objet en attribut est égal à celui appelant
     * @param o un objet de classe Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Case aCase = (Case) o;
        return posx == aCase.posx && posy == aCase.posy;
    }

    /***
     * hashCode
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(posx, posy);
    }
}
