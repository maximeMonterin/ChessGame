import java.util.ArrayList;
import java.util.List;

public class Tour extends Piece {
    public Tour(int couleur, int posx, int posy) {
        super(new Case(posx, posy), posx, posy, couleur);
    }
    public int getCouleur(){
        return this.getCouleurPiece();
    }
    @Override
    String getNom() {
        return "Tour";
    }

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

    @Override
    public Boolean manger(Piece next) {
        return (couleur != next.getCouleurPiece());
    }
}