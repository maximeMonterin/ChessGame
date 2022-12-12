import java.util.ArrayList;
import java.util.List;

/***
 * Classe Tour héritant de Piece
 * Definie la Piece comme une Tour sur un échiquier
 */
public class Tour extends Piece {

    /***
     * Constructeur de Tour
     * @param couleur couleur de la tour (0=Blanc; 1=Noir)
     * @param posx position x sur l'échiquier
     * @param posy position y sur l'échiquier
     */
    public Tour(Boolean couleur, int posx, int posy) {
        super(new Case(posx, posy), posx, posy, couleur);
    }

    /***
     * Getter pour récuperer le Nom de la Piece
     * @return String
     */
    @Override
    String getNom() {
        return "Tour";
    }

    /***
     * Mouvements correspondant aux cases où pourra aller la Tour au prochain coup
     * @return List<Case>
     */
    @Override
    public List<Case> mouvement() {

        List<Case> res = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (i != this.getPosx()) {
                res.add(new Case(i, this.getPosy()));
            }
            if (i != this.getPosx()) {
                res.add(new Case(this.getPosx(), i));
            }
        }
        return res;
    }

    /***
     * permet de définir si la piece que l'on souhaite manger est bien de la couleur opposée
     * @param p piece que l'on veut manger
     * @return Boolean
     */
    @Override
    public Boolean manger(Piece p) {
        return (couleur != p.getCouleurPiece());
    }
}