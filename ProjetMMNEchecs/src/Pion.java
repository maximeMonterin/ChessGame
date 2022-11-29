import java.util.ArrayList;
import java.util.List;

public class Pion extends Piece{
    private int couleur;
    private int posx;
    private char posy;

    public Pion(int couleur, int posx, char posy) {
        super(new Case(posx, posy));
        this.couleur = couleur;
        this.posx = posx;
        this.posy = posy;
    }

    @Override
    String getNom() {
        return "Pion";
    }

    @Override
    public List<Case> mouvement(){
        List<Case> res = new ArrayList<>();
        if(couleur == 1){ // couleur noir, en bas
            res.add(new Case(8-(posx -1), posy));
            if(posx == 6) {
                res.add(new Case(8-(posx - 2), posy));
            }
        }
        else if(couleur ==0){ // couleur blanc , en haut
            res.add (new Case(8-(posx +1), posy));
            if(posx == 1) {
                res.add(new Case(8-(posx + 2), posy));
            }
        }
        return res;
    }

    @Override
    public void manger() {

    }

    public int getCouleur() {
        return couleur;
    }
}
