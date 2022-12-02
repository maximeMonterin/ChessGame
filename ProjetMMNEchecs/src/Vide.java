import java.util.ArrayList;
import java.util.List;

/***
 * Classe Vide héritant de Piece
 * Definie la Piece comme un Vide sur un échiquier
 */
public class Vide extends Piece {

    /***
     * Concstructeur de Vide
     * @param posx position x sur l'échiquier
     * @param posy position y sur l'échiquier
     */
    public Vide(int posx, int posy) {
        super(new Case(posx, posy), posx, posy);
    }

    /***
     * Getter pour récuperer le Nom de la Piece
     * @return String
     */
    @Override
    String getNom() {
        return "Vide";
    }

    /***
     * Mouvements de Vide (Aucuns déplacements)
     * @return List<Case>
     */
    @Override
    public List<Case> mouvement() {
        List<Case> res = new ArrayList<>();
        res.add(new Case(this.getPosx(), this.getPosy()));
        return res;
    }

    /***
     * manger pour vide n'a pas d'effet
     * @param p piece que l'on veut manger
     * @return Boolean
     */
    @Override
    public Boolean manger(Piece p) {
        return true;
    }
}
