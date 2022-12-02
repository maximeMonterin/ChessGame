import java.util.ArrayList;
import java.util.List;

/***
 * Classe Pion héritant de Piece
 * Definie la Piece comme un Pion sur un échiquier
 */
public class Pion extends Piece{

    /***
     * Constructeur de Pion
     * @param couleur couleur du pion (0=Blanc; 1=Noir)
     * @param posx position x sur l'échiquier
     * @param posy position y sur l'échiquier
     */
    public Pion(int couleur, int posx, int posy) {
        super(new Case(posx, posy), posx, posy,couleur);
    }

    /***
     * Getter pour recupérer la couleur du Pion
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
        return "Pion";
    }

    /***
     * Mouvements correspondant aux cases où pourra aller le pion au prochain coup
     * @return List<Case>
     */
    @Override
    public List<Case> mouvement(){
        List<Case> res = new ArrayList<>();
        if(couleur == 1){ // couleur noir, en bas
            res.add(new Case(this.getPosx()-1, this.getPosy()));
            if(this.getPosx() == 6) {
                res.add(new Case(this.getPosx() - 2, this.getPosy()));
            }
            res.add(new Case(this.getPosx()-1, this.getPosy()+1));
            res.add(new Case(this.getPosx()-1, this.getPosy()-1));
        }
        else if(couleur ==0){ // couleur blanc , en haut
            res.add (new Case(this.getPosx() +1, this.getPosy()));
            if(this.getPosx() == 1) {
                res.add(new Case(this.getPosx() + 2, this.getPosy()));
            }
            res.add(new Case(this.getPosx()+1, this.getPosy()+1));
            res.add(new Case(this.getPosx()+1, this.getPosy()-1));
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
