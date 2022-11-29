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
        int posi = position.getPosx();
        if(couleur == 0){ // couleur blanc, en bas
            res.add(new Case(posi+1, position.getPosy()));
            if(posi == 2) {
                res.add(new Case(posi + 2, position.getPosy()));
            }
        }
        else if(couleur ==1){ // couleur noir , en haut
            res.add (new Case(posi+1, position.getPosy()));
            if(posi == 2) {
                res.add(new Case(posi + 2, position.getPosy()));
            }
        }
        return res;
    }

    @Override
    public void manger() {

    }
}
