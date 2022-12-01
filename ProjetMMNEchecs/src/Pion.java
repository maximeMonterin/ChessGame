import java.util.ArrayList;
import java.util.List;

public class Pion extends Piece{
    public Pion(int couleur, int posx, int posy) {
        super(new Case(posx, posy), posx, posy,couleur);
    }
    public int getCouleur(){
        return this.getCouleurPiece();
    }
    @Override
    String getNom() {
        return "Pion";
    }
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
    @Override
    public Boolean manger(Piece next) {
        return (couleur != next.getCouleurPiece());
    }

}
