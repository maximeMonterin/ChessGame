import java.util.ArrayList;
import java.util.List;

public class Roi extends Piece {
    private int posx;
    private int posy;

    public Roi(int couleur, int posx, int posy) {
        super(new Case(posx, posy), posx, posy, couleur);
        this.posx = posx;
        this.posy = posy;
    }

    @Override
    String getNom() {
        return "Roi";
    }

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

    @Override
    public Boolean manger(Piece next) {

        return (couleur != next.getCouleurPiece());
    }

    public int getCouleur(){
        return this.getCouleurPiece();
    }

}