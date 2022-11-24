import java.util.List;

public class Cavalier implements Piece{
    private int couleur;

    public Cavalier(int couleur) {
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
