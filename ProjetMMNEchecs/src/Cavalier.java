import java.util.List;

public class Cavalier extends Piece{
    private int couleur;
    private int posx;
    private int posy;

    public Cavalier(int couleur, int posx, int posy) {
        super(new Case(posx, posy), posx, posy);
        this.couleur = couleur;
        this.posx = posx;
        this.posy = posy;
    }

    @Override
    String getNom() {
        return "Cavalier";
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
