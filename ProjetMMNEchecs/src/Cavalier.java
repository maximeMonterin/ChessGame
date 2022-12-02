import java.util.ArrayList;
import java.util.List;

/***
 * Classe Cavalier héritant de Piece
 * Definie la Piece comme un Cavalier sur un échiquier
 */
public class Cavalier extends Piece{

    /***
     * Constructeur de Cavalier
     * @param couleur couleur du cavalier (0=Blanc; 1=Noir)
     * @param posx position x sur l'échiquier
     * @param posy position y sur l'échiquier
     */
    public Cavalier(int couleur, int posx, int posy) {
        super(new Case(posx, posy), posx, posy, couleur);
    }

    /***
     * Getter pour recupérer la couleur du Cavalier
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
        return "Cavalier";
    }

    /***
     * Mouvements correspondant aux cases où pourra aller le Cavalier au prochain coup
     * @return List<Case>
     */
    @Override
    public List<Case> mouvement() {

        List<Case> res = new ArrayList<>();

        if(this.getPosx()+2<=7){
            if(this.getPosy()+1<=7){
                res.add(new Case(this.getPosx()+2, this.getPosy()+1));
            }
            if(this.getPosy()-1>=0){
                res.add(new Case(this.getPosx()+2, this.getPosy()-1));
            }
        }

        if(this.getPosx()-2>=0){
            if(this.getPosy()+1<=7){
                res.add(new Case(this.getPosx()-2, this.getPosy()+1));
            }
            if(this.getPosy()-1>=0){
                res.add(new Case(this.getPosx()-2, this.getPosy()-1));
            }
        }

        if(this.getPosx()+1<=7){
            if(this.getPosy()+2<=7){
                res.add(new Case(this.getPosx()+1, this.getPosy()+2));
            }
            if(this.getPosy()-2>=0){
                res.add(new Case(this.getPosx()+1, this.getPosy()-2));
            }
        }

        if(this.getPosx()-1>=0){
            if(this.getPosy()+2<=7){
                res.add(new Case(this.getPosx()-1, this.getPosy()+2));
            }
            if(this.getPosy()-2>=0){
                res.add(new Case(this.getPosx()-1, this.getPosy()-2));
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
