import java.util.ArrayList;
import java.util.List;

public class Pion extends Piece{
    private int couleur;

    public Pion(int couleur, int posx, char posy) {
        super(new Case(posx, posy), posx, posy);
        this.couleur = couleur;
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
        }
        else if(couleur ==0){ // couleur blanc , en haut
            res.add (new Case(this.getPosx() +1, this.getPosy()));
            if(this.getPosx() == 1) {
                res.add(new Case(this.getPosx() + 2, this.getPosy()));
            }
        }
        return res;
    }

    public void bouger(){

    }

    @Override
    public void manger() {

    }

    public int getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return "Pion{" +
                "position=" + position +
                '}';
    }
}
