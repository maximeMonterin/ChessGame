import java.util.List;

public class Vide extends Piece {
    private int posx;
    private char posy;
    public Vide(int posx, char posy) {
        super(new Case(posx, posy));
        this.posx = posx;
        this.posy = posy;
    }
    @Override
    public List<Case> mouvement(Case case_de_la_piece) {

        return null;
    }

    @Override
    public void manger() {

    }
}
