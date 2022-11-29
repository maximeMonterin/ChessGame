import java.util.List;

public class Roi extends Piece{
    private int couleur;
    private int posx;
    private int posy;

    public Roi(int couleur, int posx, int posy) {
        super(new Case(posx, posy), posx, posy);
        this.couleur = couleur;
        this.posx = posx;
        this.posy = posy;
    }

    @Override
    String getNom() {
        return "Roi";
    }

    @Override
    public List<Case> mouvement() {
        return null;
    }

    @Override
    public void manger() {

    }

    public int getCouleur() {
        return couleur;
    }
}
