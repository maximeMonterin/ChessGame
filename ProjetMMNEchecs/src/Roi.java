import java.util.ArrayList;
import java.util.List;

/***
 * Classe Roi héritant de Piece
 * Definie la Piece comme un Roi sur un échiquier
 */
public class Roi extends Piece {

    /***
     * Constructeur de Roi
     * @param couleur couleur du Roi (0=Blanc; 1=Noir)
     * @param posx position x sur l'échiquier
     * @param posy position y sur l'échiquier
     */
    public Roi(int couleur, int posx, int posy) {
        super(new Case(posx, posy), posx, posy, couleur);
    }

    /***
     * Getter pour recupérer la couleur du Roi
     * @return int
     */
    public int getCouleur(){
        return this.getCouleurPiece();
    }

    /***
     * Getter pour récuperer le Nom de la Piece
     * @return String
     */
    @Override
    String getNom() {
        return "Roi";
    }

    /***
     * Mouvements correspondant aux cases où pourra aller le Roi au prochain coup
     * @return List<Case>
     */
    @Override
    public List<Case> mouvement() {

        List<Case> res = new ArrayList<>();
        if (this.getPosy() - 1 >= 0) {
            res.add(new Case(this.getPosx(), this.getPosy() - 1));
        }
        if (this.getPosy() + 1 <= 7) {
            res.add(new Case(this.getPosx(), this.getPosy() + 1));
        }

        if (this.getPosx() + 1 <= 7) {
            res.add(new Case(this.getPosx() + 1, this.getPosy()));

            if (this.getPosy() - 1 >= 0) {
                res.add(new Case(this.getPosx() + 1, this.getPosy() - 1));
            }
            if (this.getPosy() + 1 <= 7) {
                res.add(new Case(this.getPosx() + 1, this.getPosy() + 1));
            }
        }

        if (this.getPosx() - 1 >= 0) {
            res.add(new Case(this.getPosx() - 1, this.getPosy()));

            if (this.getPosy() - 1 >= 0) {
                res.add(new Case(this.getPosx() - 1, this.getPosy() - 1));
            }
            if (this.getPosy() + 1 <= 7) {
                res.add(new Case(this.getPosx() - 1, this.getPosy() + 1));
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