import java.util.ArrayList;
import java.util.List;

public class Vide extends Piece {
    private int posx;
    private int posy;
    public Vide(int posx, int posy) {
        super(new Case(posx, posy), posx, posy);
        this.posx = posx;
        this.posy = posy;
    }

    @Override
    String getNom() {
        return "Vide";
    }

    @Override
    public List<Case> mouvement() {

        List<Case> res = new ArrayList<>();
        res.add(new Case(this.getPosx(), this.getPosy()));
        return res;
    }

    @Override
    public void manger() {

    }
}
