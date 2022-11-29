import java.util.List;

public class Reine extends Piece{
    private int couleur;
    private int posx;
    private char posy;
    private Case caseReine;

    public Reine(int couleur, int posx, char posy) {
        super(new Case(posx, posy));
        this.couleur = couleur;
        this.posx = posx;
        this.posy = posy;
    }

    @Override
    String getNom() {
        return "Reine";
    }

    @Override
    public List<Case> mouvement() {

        return null;
    }

    @Override
    public void manger() {

    }
}
