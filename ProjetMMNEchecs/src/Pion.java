import java.util.ArrayList;
import java.util.List;

public class Pion implements Piece{
    private int couleur;

    public Pion(int couleur) {
        this.couleur = couleur;
    }

    @Override
    public List<Case> mouvement(Case case_de_la_piece){
        List<Case> res = new ArrayList<>();
        int posi = case_de_la_piece.getPosx();
        if(couleur == 0){ // couleur blanc, en bas
            res.add(new Case(posi+1, case_de_la_piece.getPosy()));
            if(posi == 2) {
                res.add(new Case(posi + 2, case_de_la_piece.getPosy()));
            }
        }
        else if(couleur ==1){ // couleur noir , en haut
            res.add (new Case(posi+1, case_de_la_piece.getPosy()));
            if(posi == 2) {
                res.add(new Case(posi + 2, case_de_la_piece.getPosy()));
            }
        }
        return res;
    }

    @Override
    public void manger() {

    }
}
