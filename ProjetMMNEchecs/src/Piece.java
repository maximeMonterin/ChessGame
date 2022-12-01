import java.util.List;

public abstract class Piece {
    private int posx;
    private int posy;
    protected Case position;

    protected int couleur;

    public int getCouleurPiece() {
        return couleur;
    }

    public Piece(Case position, int posx, int posy) {
        this.position = position;
        this.posx = posx;
        this.posy = posy;
        this.couleur = 0;
    }
    public Piece(Case position, int posx, int posy, int couleur) {
        this(position, posx, posy);
        this.couleur = couleur;
    }

    abstract String getNom();

    abstract List<Case> mouvement();

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    abstract Boolean manger(Piece next);
}
