import java.util.List;

public class Fou extends Piece{
    private int couleur;
    private int posx;
    private char posy;

    public Fou(int couleur, int posx, char posy) {
        super(new Case(posx, posy), posx, posy);
        this.couleur = couleur;
        this.posx = posx;
        this.posy = posy;
    }

    @Override
    String getNom() {
        return "Fou";
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
