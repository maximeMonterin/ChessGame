import java.util.List;

public class Roi implements Piece{
    private int couleur;

    public Roi(int couleur) {
        this.couleur = couleur;
    }

    @Override
    public List<Case> mouvement(Case case_de_la_piece) {
        return null;
    }

    @Override
    public void manger() {

    }
}
