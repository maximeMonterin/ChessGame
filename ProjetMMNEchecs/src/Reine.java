import java.util.ArrayList;
import java.util.List;

/***
 * Classe Reine héritant de Piece
 * Definie la Piece comme une Reine sur un échiquier
 */
public class Reine extends Piece{

    /***
     * Constructeur de Reine
     * @param couleur couleur de la reine (0=Blanc; 1=Noir)
     * @param posx position x sur l'échiquier
     * @param posy position y sur l'échiquier
     */
    public Reine(int couleur, int posx, int posy) {
        super(new Case(posx, posy), posx, posy,couleur);
    }

    /***
     * Getter pour recupérer la couleur de la Reine
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
        return "Reine";
    }

    /***
     * Mouvements correspondant aux cases où pourra aller la Reine au prochain coup
     * @return List<Case>
     */
    @Override
    public List<Case> mouvement() {
        List<Case> res = new ArrayList<>();
        for(int i=0;i<8;i++){
            if(i!=this.getPosx()){
                res.add(new Case(i, this.getPosy()));
            }

            if(i!=this.getPosy()) {
                res.add(new Case(this.getPosx(), i));
            }

            if(this.getPosx()+i<=7){
                if(this.getPosy()+i<=7){
                    res.add(new Case(this.getPosx()+i,this.getPosy()+i));
                }
                if(this.getPosy()-i>=0){
                    res.add(new Case(this.getPosx()+i,this.getPosy()-i));
                }
            }

            if (this.getPosx()-i>=0){
                if(this.getPosy()+i<=7){
                    res.add(new Case(this.getPosx()-i,this.getPosy()+i));
                }
                if(this.getPosy()-i>=0){
                    res.add(new Case(this.getPosx()-i,this.getPosy()-i));
                }
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
